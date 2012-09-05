package org.require.egit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ecl.core.Command;
import org.eclipse.ecl.runtime.ICommandService;
import org.eclipse.ecl.runtime.IProcess;
import org.eclipse.egit.core.Activator;
import org.eclipse.jgit.lib.Repository;
import org.require.egit.RequireGitRoot;

public class RequireGitRootService implements ICommandService {
	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		Repository[] repositories = Activator.getDefault().getRepositoryCache()
				.getAllRepositories();
		RequireGitRoot cmd = (RequireGitRoot) command;
		for (Repository repository : repositories) {
			if (repository.getWorkTree().getName().equals(cmd.getName())) {
				context.getOutput().write(
						repository.getWorkTree().getAbsolutePath());
				break;
			}
		}
		return Status.OK_STATUS;
	}
}
