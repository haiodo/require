package org.eclipse.require.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.internal.resources.ProjectDescriptionReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.require.core.configuration.Component;
import org.eclipse.require.core.configuration.Configuration;
import org.eclipse.require.core.configuration.PluginRequire;
import org.xml.sax.InputSource;

public class RequireEngine {
	private IPath baseDir;

	/**
	 * Map of [relative to base path: project info]
	 */
	public static class ProjectInfo {
		public String name;
		public IPath path;
		public IProject existingProject;
		public ProjectDescription description;
		public IPath absPath;
	}

	public static class ComponentProjectsInfo {
		public String componentName;
		public List<IPath> projects;
		public Component component;
	}

	private Map<IProject, IPath> conflicts = new HashMap<IProject, IPath>();

	private Map<IPath, ProjectInfo> projectsMap = new HashMap<IPath, ProjectInfo>();
	private Map<String, IPath> locationProjectsMap = new HashMap<String, IPath>();

	private List<IProject> unreferenced = new ArrayList<IProject>();

	private Set<IPath> availableProjects;

	public RequireEngine(String baseDir) {
		this.baseDir = new Path(new File(baseDir).getAbsolutePath());
	}

	public void findProjects(IProgressMonitor monitor) {
		findProjects();
		findExistingProjects();
	}

	private void findExistingProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (IProject iProject : projects) {
			try {
				IProjectDescription description = iProject.getDescription();
				URI locationURI = description.getLocationURI();
				if (locationURI != null) {
					// check project
					String loc = locationURI.toURL().getPath().substring(1);
					if (locationProjectsMap.containsKey(loc)) {
						ProjectInfo info = projectsMap.get(locationProjectsMap
								.get(loc));
						info.existingProject = iProject;
					} else {
						unreferenced.add(iProject);
					}

				} else {
					// local project, check for conflicts
					for (ProjectInfo info : projectsMap.values()) {
						if (info.name.equals(description.getName())) {
							conflicts.put(iProject, info.path);
						}
					}
				}
			} catch (Throwable e) {
				RequireCorePlugin.log(e);
			}
		}
	}

	private void findProjects() {
		findDotProjects();
	}

	private void findDotProjects() {
		File dir = baseDir.toFile();
		traverseFolders(dir, new ITraverseDirRunner() {
			@Override
			public boolean proceed(File dir) {
				File dotFile = new File(dir, ".project");
				if (dotFile.exists() && dotFile.isFile()) {
					checkAddDotProject(dir, dotFile);
				}
				return true;
			}
		});
	}

	protected void checkAddDotProject(File dir, File dotFile) {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dotFile));
			InputSource source = new InputSource(in);
			ProjectDescription description = new ProjectDescriptionReader()
					.read(source);
			ProjectInfo info = new ProjectInfo();
			info.path = new Path(dir.getAbsolutePath()).removeFirstSegments(
					baseDir.segmentCount()).setDevice(null);
			info.absPath = new Path(dir.getAbsolutePath());
			info.name = description.getName();
			info.description = description;
			projectsMap.put(info.path, info);
			locationProjectsMap.put(info.absPath.toString(), info.path);

		} catch (Throwable e) {
			RequireCorePlugin.log(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable e) {
					// ignore
				}
			}
		}
	}

	private interface ITraverseDirRunner {
		boolean proceed(File dir);
	}

	private void traverseFolders(File dir, ITraverseDirRunner run) {
		if (dir.exists() && dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File file : listFiles) {
				if (file.isDirectory()) {
					if (run.proceed(file)) {
						traverseFolders(file, run);
					}
				}
			}
		}
	}

	public List<ComponentProjectsInfo> processConfiguration(
			Configuration config, IProgressMonitor monitor) {
		availableProjects = new HashSet<IPath>(projectsMap.keySet());
		List<ComponentProjectsInfo> componentProjects = new ArrayList<ComponentProjectsInfo>();
		processComponents(config.getComponents(), availableProjects,
				componentProjects, "");

		return componentProjects;
	}

	public void applyConfiguration(final IProgressMonitor monitor,
			final List<ComponentProjectsInfo> componentProjects) {
		// apply
		// Create projects
		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					monitor.beginTask("Apply require project configuration",
							componentProjects.size());
					for (ComponentProjectsInfo cp : componentProjects) {
						if (monitor.isCanceled()) {
							return;
						}
						monitor.setTaskName("Apply component: "
								+ cp.componentName);
						for (IPath prj : cp.projects) {
							if (monitor.isCanceled()) {
								return;
							}
							ProjectInfo info = projectsMap.get(prj);
							if (info != null) {
								if (info.existingProject == null) {
									// Create project if it doesn't exist
									IProject project = ResourcesPlugin
											.getWorkspace().getRoot()
											.getProject(info.name);
									if (!project.exists()) {
										IProjectDescription description = ResourcesPlugin
												.getWorkspace()
												.newProjectDescription(
														info.name);
										description.setLocation(info.absPath);
										try {
											project.create(description,
													new NullProgressMonitor());
											project.open(new NullProgressMonitor());
										} catch (CoreException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									// Fill project
									info.existingProject = project;
								}
							}
						}
					}
				}
			}, monitor);
		} catch (CoreException e) {
			RequireCorePlugin.log(e);
		}
	}

	/**
	 * Process children at first, then process plugins section, and so on
	 */
	public static void processComponents(EList<Component> components,
			Set<IPath> availableProjects,
			List<ComponentProjectsInfo> componentProjects, String prefix) {
		for (Component component : components) {
			String name = prefix + component.getName();
			processComponents(component.getComponents(), availableProjects,
					componentProjects, name + ".");

			EList<PluginRequire> plugins = component.getPlugins();
			List<IPath> matches = new ArrayList<IPath>();
			for (PluginRequire pluginRequire : plugins) {
				matches.addAll(findProjectMatches(pluginRequire,
						availableProjects));
			}
			ComponentProjectsInfo cp = new ComponentProjectsInfo();
			cp.componentName = name;
			cp.projects = matches;
			cp.component = component;
			componentProjects.add(cp);
		}
	}

	/**
	 * Allow following matching scenarious:
	 * 
	 * 1) a/b/c/d a/b/c is treated as path. and last d is treated as plugin
	 * name.
	 * 
	 * 2) a is treated as plugin name.
	 * 
	 * 3) a* is treadted as wildcard for plugin name
	 * 
	 * 4) a/b/c/** is treated all plugins (include subfolders) with path prefix
	 * a/b/c/
	 * 
	 * 5) a/b/c/* is treated as all plugins(exclude subfolders) from folder
	 * a/b/c/
	 * 
	 * 
	 */
	public static Set<IPath> findProjectMatches(PluginRequire pluginRequire,
			Set<IPath> availableProjects) {
		String pattern = pluginRequire.getPattern();
		boolean disabledPluginSet = false;
		// add extra * to end of /
		if (pattern.endsWith("/")) {
			pattern = pattern + "*";
		}
		if (pattern.startsWith("!")) {
			disabledPluginSet = true;
			pattern = pattern.substring(1);
		}

		IPath basePath = new Path(pattern);
		String pluginPattern = basePath.lastSegment();
		IPath folderPattern = basePath.removeLastSegments(1);

		boolean exclude = false;
		if (pluginPattern.startsWith("-")) {
			exclude = true;
			pluginPattern = pluginPattern.substring(1);
		}

		// Go filter folders first
		Set<IPath> result = new HashSet<IPath>();
		result.addAll(availableProjects);
		for (int i = 0; i < folderPattern.segmentCount(); i++) {
			String part = folderPattern.segment(i);
			if (part.equals("**")) {
				break;// All already matched plugins is ok
			}
			if (part.equals("*")) {
				// All on this level is ok.
				continue;
			}
			List<IPath> toRemove = new ArrayList<IPath>();
			for (IPath iPath : result) {
				if (part.isEmpty() && i == folderPattern.segmentCount() - 1) {
					if (iPath.segmentCount() > folderPattern.segmentCount()) {
						toRemove.add(iPath);
					}
					continue;
				}
				if (iPath.segmentCount() < i + 1) {
					toRemove.add(iPath);// Doesn't match because segment count
										// is less
				} else {
					String segm = iPath.segment(i);
					boolean match = matchSegment(segm, part);
					if ((match == exclude)) {
						toRemove.add(iPath);
					}
				}
			}
			result.removeAll(toRemove);
		}
		// So lets filter plugin names here.
		List<IPath> toRemove = new ArrayList<IPath>();
		for (IPath iPath : result) {
			String pluginName = iPath.lastSegment();
			if (pluginPattern.equals("*")) {
				continue;
			}
			if (matchSegment(pluginName, pluginPattern) == exclude) {
				toRemove.add(iPath);
			}
		}
		result.removeAll(toRemove);
		availableProjects.removeAll(result);
		if (disabledPluginSet) {
			result.clear();
		}
		return result;
	}

	private static boolean matchSegment(String segm, String pattern) {
		String[] patternParts = split(pattern);
		String text = segm;
		int index = 0;
		for (String t : patternParts) {
			int idx = text.indexOf(t);
			if (idx == -1) {
				return false;
			}
			if (index == 0 && !pattern.startsWith("*") && idx != 0) {
				return false; // In case there is no * in start of pattern, and
								// we found first part not at start
			}
			text = text.substring(idx + t.length());
			index++;
		}
		return true;
	}

	private static String[] split(String pattern) {
		List<String> result = new ArrayList<String>();
		int pos = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '*') {
				result.add(pattern.substring(pos, i));
				pos = i + 1;
			}
		}
		if (pos == 0 && pattern.length() > 0) {
			result.add(pattern);
		}

		return result.toArray(new String[result.size()]);
	}

	public ProjectInfo getProjectInfo(IPath p) {
		return projectsMap.get(p);
	}
}
