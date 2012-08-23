package org.require.core.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ecl.core.Command;
import org.eclipse.ecl.runtime.ICommandService;
import org.eclipse.ecl.runtime.IProcess;
import org.require.core.commands.RequireImport;
import org.require.core.engine.RequireImportEngine;
import org.require.core.model.RequireProject;

public class RequireImportService implements ICommandService {

	public RequireImportService() {
	}

	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		RequireImport cmd = (RequireImport) command;
		List<String> path = cmd.getPattern();

		List<RequireProject> availableProjects = cmd.getProjects();

		new RequireImportEngine().importProjects(path, availableProjects);

		return Status.OK_STATUS;
	}
}
