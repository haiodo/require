package org.eclipse.require.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

public class RequireOpenFileHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MessageDialog.open(MessageDialog.INFORMATION, PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Require", "Test", MessageDialog.OK);
		return null;
	}
}
