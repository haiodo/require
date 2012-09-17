package org.eclipse.require.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.require.ui.wizards.ProjectSelectionPage.RequireProjectEntry;
import org.eclipse.require.ui.wizards.ProjectSelectionPage.RequireProjectGroup;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.require.core.RequireCorePlugin;
import org.require.core.engine.RequireImportEngine;
import org.require.core.model.RequireProject;

public class RequireImportWizard extends Wizard implements IImportWizard {

	private IWorkbench workbench;
	private IStructuredSelection input;
	private ProjectSelectionPage selectionPage;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.input = selection;
		setWindowTitle("Require import");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		addPage(new RequireLocationPage("require.location"));
		selectionPage = new ProjectSelectionPage("require.project.select",
				"Select projects");
		addPage(selectionPage);
	}

	@Override
	public boolean canFinish() {
		return getPage("require.project.select").isPageComplete();
	}

	@Override
	public boolean performFinish() {
		final List<RequireProjectGroup> projects = selectionPage.getProjects();
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					RequireImportEngine engine = new RequireImportEngine();
					monitor.beginTask("Import projects", projects.size() * 10);
					for (RequireProjectGroup gr : projects) {
						monitor.subTask("Process:" + gr.getName());
						List<RequireProject> prlist = new ArrayList<RequireProject>();
						for (RequireProjectEntry e : gr.getEntries()) {
							prlist.add(e.getProject());
						}
						try {
							List<IProject> importProjects = engine
									.importProjects(prlist,
											new SubProgressMonitor(monitor, 10));
							IWorkingSetManager mgr = PlatformUI.getWorkbench()
									.getWorkingSetManager();
							IWorkingSet[] workingSets = mgr.getAllWorkingSets();
							IWorkingSet set = null;
							for (IWorkingSet ws : workingSets) {
								if (ws.getName().equals(gr.getName())) {
									set = ws;
								}
							}
							if (set == null) {
								set = mgr.createWorkingSet(gr.getName(),
										new IAdaptable[] {});
								mgr.addWorkingSet(set);
							}
							if (set != null) {
								for (IProject p : importProjects) {
									mgr.addToWorkingSets(p,
											new IWorkingSet[] { set });
								}
							}
						} catch (CoreException e1) {
							RequireCorePlugin.log(e1);
						}
					}
				}
			});
		} catch (Exception e) {
			RequireCorePlugin.log(e);
		}
		return true;
	}
}
