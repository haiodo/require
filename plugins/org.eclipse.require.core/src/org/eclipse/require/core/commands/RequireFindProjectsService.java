package org.eclipse.require.core.commands;

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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ecl.core.Command;
import org.eclipse.ecl.runtime.BoxedValues;
import org.eclipse.ecl.runtime.ICommandService;
import org.eclipse.ecl.runtime.IPipe;
import org.eclipse.ecl.runtime.IProcess;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.require.core.RequireCorePlugin;
import org.eclipse.require.core.model.ConfigurationFactory;
import org.eclipse.require.core.model.RequireProject;
import org.eclipse.require.core.model.commands.RequireFindProjects;
import org.xml.sax.InputSource;

public class RequireFindProjectsService implements ICommandService {

	public RequireFindProjectsService() {
	}

	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		RequireFindProjects cmd = (RequireFindProjects) command;
		EList<EObject> roots = cmd.getRoots();
		IPipe output = context.getOutput();
		if (roots.size() == 0) {
			return Status.CANCEL_STATUS;
		}
		for (EObject eObject : roots) {
			Object unbox = BoxedValues.unbox(eObject);
			if (unbox instanceof String) {
				List<RequireProject> list = findDotProjects((String)unbox);
				for (RequireProject requireProject : list) {
					output.write(requireProject);
				}
			}
		}

		return Status.OK_STATUS;
	}

	private List<RequireProject> findDotProjects(final String basePath) {
		final int segms = new Path(basePath).segmentCount();
		final List<RequireProject> result = new ArrayList<RequireProject>();
		traverseFolders(new File(basePath), new ITraverseDirRunner() {
			@Override
			public boolean proceed(File dir) {
				File dotFile = new File(dir, ".project");
				if (dotFile.exists() && dotFile.isFile()) {
					checkAddDotProject(dir, dotFile, segms, result);
				}
				return true;
			}
		});
		return result;
	}

	protected void checkAddDotProject(File dir, File dotFile, int segments,
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
