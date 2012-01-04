package org.eclipse.require.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.internal.resources.ProjectDescriptionReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.xml.sax.InputSource;

public class RequireEngine {
	private IPath baseDir;

	/**
	 * Map of [relative to base path: project info]
	 */
	private static class ProjectInfo {
		String name;
		IPath path;
		IProject existingProject;
		public ProjectDescription description;
		public IPath absPath;
	}

	private Map<IProject, IPath> conflicts = new HashMap<IProject, IPath>();

	private Map<IPath, ProjectInfo> projectsMap = new HashMap<IPath, ProjectInfo>();
	private Map<String, IPath> locationProjectsMap = new HashMap<String, IPath>();

	private List<IProject> unreferenced = new ArrayList<IProject>();

	public RequireEngine(String baseDir) {
		this.baseDir = new Path(new File(baseDir).getAbsolutePath());
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
}
