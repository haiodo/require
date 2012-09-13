package org.eclipse.require.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.require.core.engine.RequireProjectEngine;
import org.require.core.model.RequireProject;

public class ProjectSelectionPage extends WizardPage {

	private static final String GROUP_UNDEFINED = "<undefined>";
	private List<RequireProject> projects = new ArrayList<RequireProject>();
	private List<RequireProjectGroup> input = new ArrayList<RequireProjectGroup>();
	private CheckboxTreeViewer tree;
	private List<IRequireImportLocation> selection;

	public static abstract class TreeRequireElement {
		private boolean enabled = false;

		public abstract String getName();

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}

	public static class RequireProjectEntry extends TreeRequireElement {
		private RequireProject project;
		private RequireProjectGroup workingSet;

		public RequireProjectEntry(RequireProject prj) {
			this.project = prj;
		}

		@Override
		public String getName() {
			return project.getName();
		}

		public RequireProjectGroup getWorkingSet() {
			return workingSet;
		}

		public void setWorkingSet(RequireProjectGroup workingSet) {
			this.workingSet = workingSet;
		}

		public RequireProject getProject() {
			return project;
		}

	}

	public static class RequireProjectGroup extends TreeRequireElement {
		private List<RequireProjectEntry> entries;
		private String name;

		public String getName() {
			return name;
		}

		public List<RequireProjectEntry> getEntries() {
			return entries;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEntries(List<RequireProjectEntry> entries) {
			this.entries = entries;
		}
	}

	protected ProjectSelectionPage(String pageName, String title) {
		super(pageName, title, null);
	}

	@Override
	public void createControl(Composite parent) {
		setDescription("Please select importing projects.");
		Composite control = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(control);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);

		tree = new CheckboxTreeViewer(control, SWT.MULTI | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).hint(600, 300)
				.applyTo(tree.getControl());

		tree.getTree().setHeaderVisible(true);

		TreeViewerColumn name = new TreeViewerColumn(tree, SWT.NONE);
		name.getColumn().setText("Name");
		name.getColumn().setWidth(300);
		name.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TreeRequireElement) {
					return ((TreeRequireElement) element).getName();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof RequireProjectGroup) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER);
				}
				if (element instanceof RequireProject) {
					if (((RequireProjectEntry) element).project
							.getExistingProjectFullPath() != null) {
						return PlatformUI
								.getWorkbench()
								.getSharedImages()
								.getImage(
										org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT);
					} else {
						return PlatformUI
								.getWorkbench()
								.getSharedImages()
								.getImage(
										org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED);
					}
				}
				return null;
			}

		});

		tree.setComparator(new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return getText(e1).compareToIgnoreCase(getText(e2));
			}

			private String getText(Object e1) {
				if (e1 instanceof TreeRequireElement) {
					return ((TreeRequireElement) e1).getName();
				}
				return "";
			}
		});

		name.setEditingSupport(new CheckBoxEditingSupport(tree));

		// Working set column
		TreeViewerColumn workingSet = new TreeViewerColumn(tree, SWT.NONE);
		workingSet.getColumn().setText("Working set");
		workingSet.getColumn().setWidth(100);
		workingSet.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof RequireProjectEntry) {
					return ((RequireProjectEntry) element).getWorkingSet()
							.getName();
				}
				return null;
			}
		});

		TreeViewerColumn location = new TreeViewerColumn(tree, SWT.NONE);
		location.getColumn().setText("Relative Path");
		location.getColumn().setWidth(200);
		location.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof RequireProjectEntry) {
					return ((RequireProjectEntry) element).getProject()
							.getPath();

				}
				return null;
			}
		});

		tree.setContentProvider(new ITreeContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {

			}

			@Override
			public void dispose() {
			}

			@Override
			public boolean hasChildren(Object element) {
				if (element instanceof RequireProjectGroup) {
					return !((RequireProjectGroup) element).getEntries()
							.isEmpty();
				}
				return false;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					return ((List) inputElement).toArray();
				}
				if (inputElement instanceof RequireProjectGroup) {
					return ((RequireProjectGroup) inputElement).getEntries()
							.toArray();
				}
				return null;
			}

			@Override
			public Object[] getChildren(Object element) {
				if (element instanceof RequireProjectGroup) {
					return ((RequireProjectGroup) element).getEntries()
							.toArray();
				}
				return null;
			}
		});

		tree.setInput(input);
		tree.expandAll();

		setControl(control);
		setPageComplete(false);
	}

	@Override
	public void setPreviousPage(IWizardPage page) {
		super.setPreviousPage(page);
		try {
			final List<IRequireImportLocation> selection = ((RequireLocationPage) page)
					.getSelection();
			getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					setLocation(selection, monitor);
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setLocation(List<IRequireImportLocation> selection,
			IProgressMonitor monitor) {
		this.selection = selection;
		monitor.beginTask("Find projects", selection.size() * 10 + 10);

		RequireProjectGroup undefined = new RequireProjectGroup();
		undefined.setName(GROUP_UNDEFINED);
		input.add(undefined);
		undefined
				.setEntries(new ArrayList<ProjectSelectionPage.RequireProjectEntry>());

		for (IRequireImportLocation loc : selection) {
			SubProgressMonitor sub = new SubProgressMonitor(monitor, 10);
			List<RequireProject> list = RequireProjectEngine.findDotProjects(
					loc.getLocation(), sub);
			for (RequireProject project : list) {
				RequireProjectEntry e = new RequireProjectEntry(project);
				if (project.getExistingProjectFullPath() == null) {
					e.setEnabled(true);
				}
				undefined.getEntries().add(e);
				e.setWorkingSet(undefined);
			}
			monitor.worked(10);
		}

		groupProjects(input);

		if (tree != null) {
			tree.getControl().getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					tree.refresh();
					tree.expandAll();
				}
			});
		}

		monitor.done();
	}

	private void groupProjects(List<RequireProjectGroup> workingSets) {

		// Put all projects to groups.
		Map<IPath, List<RequireProjectEntry>> prefixes = new HashMap<IPath, List<RequireProjectEntry>>();
		for (RequireProjectGroup group : workingSets) {
			for (RequireProjectEntry prj : group.getEntries()) {
				IPath path = new Path(prj.project.getPath())
						.removeLastSegments(1);
				if (prefixes.containsKey(path)) {
					prefixes.get(path).add(prj);
				} else {
					List<RequireProjectEntry> np = new ArrayList<RequireProjectEntry>();
					np.add(prj);
					prefixes.put(path, np);
				}
			}
		}
		RequireProjectGroup unspecified = new RequireProjectGroup();
		unspecified.setName(GROUP_UNDEFINED);
		unspecified
				.setEntries(new ArrayList<ProjectSelectionPage.RequireProjectEntry>());
		// Reduce groups
		loop: while (true) {
			List<IPath> keys = new ArrayList<IPath>(prefixes.keySet());
			Collections.sort(keys, new Comparator<IPath>() {
				@Override
				public int compare(IPath arg0, IPath arg1) {
					return Integer.valueOf(arg1.toString().length()).compareTo(
							arg0.toString().length());
				}

			});
			for (Map.Entry<IPath, List<RequireProjectEntry>> path : prefixes
					.entrySet()) {
				List<RequireProjectEntry> list = path.getValue();
				if (list.size() < 3) {
					// reduce list to parent or unspecified
					List<RequireProjectEntry> parent = prefixes.get(path
							.getKey().removeLastSegments(1));
					if (parent != null) {
						parent.addAll(list);
					} else {
						unspecified.getEntries().addAll(list);
					}
					prefixes.remove(path.getKey());
					continue loop;
				}
			}
			break;
		}
		workingSets.clear();
		for (Map.Entry<IPath, List<RequireProjectEntry>> path : prefixes
				.entrySet()) {
			String ws = path.getKey().toString().replace("/", ".");
			RequireProjectGroup gr = new RequireProjectGroup();
			gr.setName(ws);
			gr.setEntries(path.getValue());
			workingSets.add(gr);
			for (RequireProjectEntry prj : path.getValue()) {
				prj.setWorkingSet(gr);
			}
		}
		if (unspecified.getEntries().size() > 0) {
			workingSets.add(unspecified);
		}
	}
}
