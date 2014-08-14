package org.require.core.engine;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.internal.resources.ProjectDescriptionReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.require.core.RequireCorePlugin;
import org.require.core.model.ConfigurationFactory;
import org.require.core.model.RequireProject;
import org.xml.sax.InputSource;

public class RequireProjectEngine {
	public static List<RequireProject> findDotProjects(final String basePath,
			final IProgressMonitor monitor) {
		final int segms = new Path(basePath).segmentCount();
		monitor.beginTask("Process location:" + basePath, -1);
		final List<RequireProject> result = new ArrayList<RequireProject>();
		traverseFolders(new File(basePath), new ITraverseDirRunner() {
			@Override
			public boolean proceed(File dir) {
				monitor.worked(1);
				File dotFile = new File(dir, ".project");
                if (dir.toString().contains("bin")
                    || dir.toString().contains("target"))
                {
                    return false;
                }
				if (dotFile.exists() && dotFile.isFile()) {
					checkAddDotProject(dir, dotFile, segms, result);
				}
				return true;
			}
		});
		monitor.done();
		return result;
	}

	public static void checkAddDotProject(File dir, File dotFile, int segments,
			List<RequireProject> result) {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dotFile));
			InputSource source = new InputSource(in);
			ProjectDescription description = new ProjectDescriptionReader()
					.read(source);

			RequireProject info = ConfigurationFactory.eINSTANCE
					.createRequireProject();

			info.setFullPath(new Path(dir.getAbsolutePath()).toOSString());
			info.setPath(new Path(dir.getAbsolutePath())
					.removeFirstSegments(segments).setDevice(null).toOSString());
			info.setName(description.getName());

			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(description.getName());
			boolean exists = project.exists();
			if (exists) {
				URI locationURI = project.getDescription().getLocationURI();
				if (locationURI != null) {
					info.setExistingProjectFullPath(locationURI.getPath());
				}
			}
			info.setProjectExists(exists);
			result.add(info);

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

	private static interface ITraverseDirRunner {
		boolean proceed(File dir);
	}

	public static void traverseFolders(File dir, ITraverseDirRunner run) {
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
