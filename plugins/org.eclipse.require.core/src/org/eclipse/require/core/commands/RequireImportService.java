package org.eclipse.require.core.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ecl.core.Command;
import org.eclipse.ecl.runtime.ICommandService;
import org.eclipse.ecl.runtime.IProcess;

public class RequireImportService implements ICommandService {

	public RequireImportService() {
	}

	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		
		return null;
	}

}
