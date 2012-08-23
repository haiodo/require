package org.require.core.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.require.core.model.RequireProject;

public class RequireImportEngine {
	public void importProjects(List<String> path,
			List<RequireProject> availableProjects) throws CoreException {
		Set<RequireProject> available = new HashSet<RequireProject>(
				availableProjects);
		final List<RequireProject> matches = new ArrayList<RequireProject>();

		for (String part : path) {
			if (!part.startsWith("-")) {
				matches.addAll(findProjectMatches(part, available));
			}
		}
		for (String part : path) {
			if (part.startsWith("-")) {
				Set<RequireProject> newMatches = new HashSet<RequireProject>();
				newMatches.addAll(matches);
				matches.clear();
				matches.addAll(findProjectMatches(part, newMatches));
			}
		}
		/**
		 * Import all non exist matched project
		 */
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				monitor.beginTask("Import unexisting projects",
						matches.size() * 2);
				for (RequireProject matched : matches) {
					if (matched.getExistingProjectFullPath() == null) {
						// Just create new project
						createProject(monitor, matched);
						monitor.worked(1);
					} else if (!matched.getExistingProjectFullPath().equals(
							matched.getFullPath())) {
						IProject project = ResourcesPlugin.getWorkspace()
								.getRoot().getProject(matched.getName());
						project.delete(false, true, new SubProgressMonitor(
								null, 1));
						createProject(monitor, matched);
					}
				}
			}

			private void createProject(IProgressMonitor monitor,
					RequireProject matched) {
				IProject project = ResourcesPlugin.getWorkspace().getRoot()
						.getProject(matched.getName());
				if (!project.exists()) {
					IProjectDescription description = ResourcesPlugin
							.getWorkspace().newProjectDescription(
									matched.getName());
					description.setLocation(new Path(matched.getFullPath()));
					try {
						project.create(description, new SubProgressMonitor(
								monitor, 1));
						project.open(new SubProgressMonitor(monitor, 1));
						project.refreshLocal(IResource.DEPTH_INFINITE,
								new SubProgressMonitor(monitor, 1));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}, null);
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
	public static Set<RequireProject> findProjectMatches(String pattern,
			Set<RequireProject> availableProjects) {
		boolean disabledPluginSet = false;
		// add extra * to end of /
		if (pattern.endsWith("/")) {
			pattern = pattern + "*";
		}
		if (pattern.startsWith("!")) {
			disabledPluginSet = true;
			pattern = pattern.substring(1);
		}

		boolean exclude = false;
		if (pattern.startsWith("-")) {
			exclude = true;
			pattern = pattern.substring(1);
		}
		IPath basePath = new Path(pattern);
		String pluginPattern = basePath.lastSegment();
		IPath folderPattern = basePath.removeLastSegments(1);

		// Go filter folders first
		Set<RequireProject> result = new HashSet<RequireProject>();
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
			List<RequireProject> toRemove = new ArrayList<RequireProject>();
			for (RequireProject prj : result) {
				IPath iPath = new Path(prj.getPath());
				if (part.isEmpty() && i == folderPattern.segmentCount() - 1) {
					if (iPath.segmentCount() > folderPattern.segmentCount()) {
						toRemove.add(prj);
					}
					continue;
				}
				if (iPath.segmentCount() < i + 1) {
					toRemove.add(prj);// Doesn't match because segment count
										// is less
				} else {
					String segm = iPath.segment(i);
					boolean match = matchSegment(segm, part);
					// Only if full pattern match, do exclude
					if ((match == (exclude && i == folderPattern.segmentCount() - 1))) {
						toRemove.add(prj);
					}
				}
			}
			result.removeAll(toRemove);
		}
		// So lets filter plugin names here.
		List<RequireProject> toRemove = new ArrayList<RequireProject>();
		for (RequireProject prj : result) {
			IPath iPath = new Path(prj.getPath());
			String pluginName = iPath.lastSegment();
			if (pluginPattern.equals("*")) {
				continue;
			}
			if (matchSegment(pluginName, pluginPattern) == exclude) {
				toRemove.add(prj);
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
}
