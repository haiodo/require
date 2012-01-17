package org.eclipse.require.ui.wizards;

import java.util.List;

import org.eclipse.require.core.RequireEngine.ComponentProjectsInfo;
import org.eclipse.swt.widgets.Shell;

public class RequireConfirmationDialog {

	private Shell parentShell;
	private List<ComponentProjectsInfo> result = null;

	public RequireConfirmationDialog(Shell shell) {
		this.parentShell = shell;
	}

	public boolean open(List<ComponentProjectsInfo> components) {
		result = components;
		return true;
	}

	public List<ComponentProjectsInfo> getResultComponents() {
		return result;
	}

}
