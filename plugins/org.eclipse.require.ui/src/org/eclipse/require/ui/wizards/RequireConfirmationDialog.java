package org.eclipse.require.ui.wizards;

import java.util.List;

import org.eclipse.core.runtime.IPath;
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
		for (ComponentProjectsInfo cp : components) {
			System.out.println("component: " + cp.componentName);
			List<IPath> projects = cp.projects;
			for (IPath iPath : projects) {
				System.out.println("\t\t " + iPath.lastSegment());
			}
		}

		return false;
	}

	public List<ComponentProjectsInfo> getResultComponents() {
		return result;
	}

}
