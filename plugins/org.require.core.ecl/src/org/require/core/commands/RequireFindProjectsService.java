package org.require.core.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ecl.core.Command;
import org.eclipse.ecl.runtime.BoxedValues;
import org.eclipse.ecl.runtime.ICommandService;
import org.eclipse.ecl.runtime.IPipe;
import org.eclipse.ecl.runtime.IProcess;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.require.core.commands.RequireFindProjects;
import org.require.core.engine.RequireProjectEngine;
import org.require.core.model.RequireProject;

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
				List<RequireProject> list = RequireProjectEngine
						.findDotProjects((String) unbox);
				for (RequireProject requireProject : list) {
					output.write(requireProject);
				}
			}
		}

		return Status.OK_STATUS;
	}
}
