package org.eclipse.require.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.require.core.RequireCore;
import org.eclipse.require.core.RequireEngine;
import org.eclipse.require.core.configuration.Configuration;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ApplyRequire implements IObjectActionDelegate {

	private ISelection selection;
	private IAction action;
	private IWorkbenchPart targetPart;

	public ApplyRequire() {
	}

	@Override
	public void run(IAction action) {
		if (selection != null && !selection.isEmpty()
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Object element = ssel.getFirstElement();
			if (element instanceof IFile) {
				if (((IFile) element).getFileExtension().equals("require")) {
					Configuration configuration = RequireCore
							.loadConfiguration((IFile) element);
					DirectoryDialog dialog = new DirectoryDialog(targetPart
							.getSite().getShell());
					String baseDir = "C:\\Develop\\git\\q7";// dialog.open();
					if (baseDir != null) {
						System.out.println("#");
						RequireEngine engine = new RequireEngine(baseDir);
						System.out.println("$");
					}
				}
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.action = action;
		this.targetPart = targetPart;
	}
}
