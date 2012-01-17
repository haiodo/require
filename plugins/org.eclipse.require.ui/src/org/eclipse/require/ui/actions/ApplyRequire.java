package org.eclipse.require.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.require.core.RequireCore;
import org.eclipse.require.core.RequireEngine;
import org.eclipse.require.core.RequireEngine.ComponentProjectsInfo;
import org.eclipse.require.core.RequireEngine.ProjectInfo;
import org.eclipse.require.core.configuration.Configuration;
import org.eclipse.require.ui.wizards.RequireConfirmationDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;

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
			final Object element = ssel.getFirstElement();
			if (element instanceof IFile) {
				if (((IFile) element).getFileExtension().equals("require")) {
					ProgressMonitorDialog pmd = new ProgressMonitorDialog(
							targetPart.getSite().getShell());
					try {
						pmd.run(true, true, new IRunnableWithProgress() {

							@Override
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								monitor.beginTask(
										"Apply require project configuration",
										100);
								Configuration configuration = RequireCore
										.loadConfiguration((IFile) element);
								RequireEngine engine = new RequireEngine(
										(((IFile) element).getParent()
												.getLocation()).toString());
								engine.findProjects(new SubProgressMonitor(
										monitor, 20));
								List<ComponentProjectsInfo> components = engine
										.processConfiguration(configuration,
												new SubProgressMonitor(monitor,
														40));

								// Create workingsets, if required
								RequireConfirmationDialog dialog = new RequireConfirmationDialog(
										targetPart.getSite().getShell());
								if (dialog.open(components)) {
									components = dialog.getResultComponents();
									engine.applyConfiguration(
											new SubProgressMonitor(monitor, 40),
											components);
									IWorkingSetManager mgr = PlatformUI
											.getWorkbench()
											.getWorkingSetManager();
									for (ComponentProjectsInfo cp : components) {
										if( cp.projects.isEmpty()) {
											continue;
										}
										IWorkingSet[] allWorkingSets = mgr
												.getAllWorkingSets();
										IWorkingSet set = null;
										for (IWorkingSet iWorkingSet : allWorkingSets) {
											if (iWorkingSet.getName().equals(
													cp.componentName)) {
												// found
												set = iWorkingSet;
												break;
											}
										}
										List<IAdaptable> projects = new ArrayList<IAdaptable>();
										for (IPath p : cp.projects) {
											ProjectInfo info = engine
													.getProjectInfo(p);
											if (info != null) {
												projects.add(info.existingProject);
											}
										}
										if (set == null) {
											// Create working set
											IWorkingSet workingSet = mgr
													.createWorkingSet(
															cp.componentName,
															new IAdaptable[0]);
											workingSet
													.setId("org.eclipse.jdt.ui.JavaWorkingSetPage");
											workingSet.setElements(projects
													.toArray(new IAdaptable[projects
															.size()]));
											mgr.addWorkingSet(workingSet);
										}
									}
								}
							}
						});
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
