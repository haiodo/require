package org.eclipse.require.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class RequireImportWizard extends Wizard implements IImportWizard {

	private IWorkbench workbench;
	private IStructuredSelection input;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.input = selection;
		setWindowTitle("Require import");
	}

	@Override
	public void addPages() {
		addPage(new RequireLocationPage("require.location"));
	}

	@Override
	public boolean performFinish() {
		return false;
	}
}
