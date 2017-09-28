package org.eclipse.require.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.RequireUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.require.core.RequireCorePlugin;
import org.require.core.engine.RequireProjectEngine;
import org.require.core.model.RequireProject;

public class ProjectSelectionPage extends WizardPage {
    private DataBindingContext dbc = new DataBindingContext();
    private List<RequireProjectGroup> input = new ArrayList<RequireProjectGroup>();
    private CheckboxTreeViewer tree;
    private WritableSet checked = new WritableSet(new ArrayList<TreeRequireElement>(), TreeRequireElement.class);

    private WritableValue includeFilterValue = new WritableValue("", String.class);
    private WritableValue excludeFilterValue = new WritableValue("", String.class);
    
    private boolean hideExistingValue = false;

    private final class ProjectsContentProvider implements ITreeContentProvider {
        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

        }

        @Override
        public void dispose() {
        }

        @Override
        public boolean hasChildren(Object element) {
            if (element instanceof RequireProjectGroup) {
                return !((RequireProjectGroup) element).getEntries().isEmpty();
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
                return ((List<?>) inputElement).toArray();
            }
            if (inputElement instanceof RequireProjectGroup) {
                return ((RequireProjectGroup) inputElement).getEntries().toArray();
            }
            return null;
        }

        @Override
        public Object[] getChildren(Object element) {
            if (element instanceof RequireProjectGroup) {
                return ((RequireProjectGroup) element).getEntries().toArray();
            }
            return null;
        }
    }

    private final class ProjectsComparator extends ViewerComparator {
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
    }

    private final class ProjectsLabelProvider extends ColumnLabelProvider {
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
                return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
            }
            if (element instanceof RequireProjectEntry) {
                if (((RequireProjectEntry) element).project.getExistingProjectFullPath() != null) {
                    return PlatformUI.getWorkbench().getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED);
                } else {
                    return PlatformUI.getWorkbench().getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT);
                }
            }
            return null;
        }
    }

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

    public List<RequireProjectGroup> getProjects() {
        List<RequireProjectGroup> result = new ArrayList<RequireProjectGroup>();
        for (TreeRequireElement ee : input) {
            if (ee instanceof RequireProjectGroup) {
                List<RequireProjectEntry> entries = ((RequireProjectGroup) ee).getEntries();
                List<RequireProjectEntry> enabled = new ArrayList<RequireProjectEntry>();
                for (RequireProjectEntry p : entries) {
                    if (p.isEnabled()) {
                        enabled.add(p);
                    }
                }
                if (!enabled.isEmpty()) {
                    RequireProjectGroup gg = new RequireProjectGroup();
                    gg.setName(ee.getName());
                    gg.setEnabled(true);
                    gg.setEntries(enabled);
                    result.add(gg);
                }
            }
        }
        return result;
    }

    public static class RequireProjectEntry extends TreeRequireElement {
        private RequireProject project;
        private RequireProjectGroup workingSet;
        private IRequireImportLocation location;

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

        public void setLocation(IRequireImportLocation loc) {
            this.location = loc;
        }

        public IRequireImportLocation getLocation() {
            return location;
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

    private SelectionAdapter checkAllListener = new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            for (TreeRequireElement ee : input) {
                ee.setEnabled(true);
                checked.add(ee);
                if (ee instanceof RequireProjectGroup) {
                    List<RequireProjectEntry> entries = ((RequireProjectGroup) ee).getEntries();
                    for (RequireProjectEntry p : entries) {
                        p.setEnabled(true);
                    }
                    checked.addAll(entries);
                }
            }
            tree.refresh();
        }
    };
    private SelectionAdapter uncheckAllListener = new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            for (TreeRequireElement ee : input) {
                ee.setEnabled(false);
                checked.remove(ee);
                if (ee instanceof RequireProjectGroup) {
                    List<RequireProjectEntry> entries = ((RequireProjectGroup) ee).getEntries();
                    for (RequireProjectEntry p : entries) {
                        p.setEnabled(false);
                    }
                    checked.removeAll(entries);
                }
            }
            tree.refresh();
        }
    };
    private ICheckStateProvider checkStateProvider = new ICheckStateProvider() {
        @Override
        public boolean isGrayed(Object element) {
            if (element instanceof RequireProjectGroup) {
                List<RequireProjectEntry> entries = ((RequireProjectGroup) element).getEntries();
                boolean a = false;
                boolean b = false;
                for (RequireProjectEntry e : entries) {
                    if (e.isEnabled()) {
                        a = true;
                    }
                    if (!e.isEnabled()) {
                        b = true;
                    }
                }
                return a && b;
            }
            return false;
        }

        @Override
        public boolean isChecked(Object element) {
            return ((TreeRequireElement) element).isEnabled();
        }
    };
    private ICheckStateListener checkStateListener = new ICheckStateListener() {
        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            TreeRequireElement element = (TreeRequireElement) event.getElement();
            element.setEnabled(event.getChecked());
            if (element instanceof RequireProjectGroup) {
                for (RequireProjectEntry e : ((RequireProjectGroup) element).getEntries()) {
                    e.setEnabled(event.getChecked());
                }
                checked.addAll(((RequireProjectGroup) element).getEntries());
            }
            tree.refresh();
        }
    };

    @Override
    public void createControl(Composite parent) {
        setDescription("Please select importing projects.");
        Composite control = new Composite(parent, SWT.NONE);
        GridLayoutFactory.swtDefaults().numColumns(3).applyTo(control);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(control);

        createToolbar(control);
        createFilters(control);

        createViewer(control, 3);
        setControl(control);
        setPageComplete(false);

        checked.addChangeListener(new IChangeListener() {
            @Override
            public void handleChange(ChangeEvent event) {
                boolean hasEnabledProject = false;
                for (Object e : checked.toArray()) {
                    if (e instanceof RequireProjectEntry) {
                        hasEnabledProject = true;
                        break;
                    }
                }
                setPageComplete(hasEnabledProject);
            }
        });
    }

    private void createFilters(Composite control) {
        Text includeText = new Text(control, SWT.SEARCH);
        includeText.setToolTipText("Include patterns");
        GridDataFactory.fillDefaults().grab(true, false).applyTo(includeText);
        Text excludeText = new Text(control, SWT.SEARCH);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(excludeText);

        dbc.bindValue(SWTObservables.observeText(includeText, SWT.Modify), includeFilterValue);
        dbc.bindValue(SWTObservables.observeText(excludeText, SWT.Modify), excludeFilterValue);

        excludeFilterValue.addChangeListener(new IChangeListener() {
            @Override
            public void handleChange(ChangeEvent event) {
                processIncludeExclude();
            }
        });
        includeFilterValue.addChangeListener(new IChangeListener() {
            @Override
            public void handleChange(ChangeEvent event) {
                processIncludeExclude();
            }
        });
    }

    private boolean isMatch(RequireProjectEntry prj, String pattern) {
        String[] patterns = pattern.split(",");
        for (String pat : patterns) {
            if (pat.trim().length() > 0) {
                String regexp = pat.replace("*", ".*").trim();
                Pattern compile = Pattern.compile(regexp);
                if (compile.matcher(prj.getName()).find()) {
                    return true;
                }
            }
        }
        return false;
    };

    private void createToolbar(Composite control) {
        ToolBar tbar = new ToolBar(control, SWT.FLAT);
        GridDataFactory.fillDefaults().grab(false, false).applyTo(tbar);

        ToolItem checkAll = new ToolItem(tbar, SWT.FLAT);
        checkAll.setImage(RequireUIPlugin.getImageDescriptor("icons/checkAll.png").createImage());
        checkAll.addSelectionListener(checkAllListener);

        ToolItem uncheckAll = new ToolItem(tbar, SWT.FLAT);
        uncheckAll.setImage(RequireUIPlugin.getImageDescriptor("icons/uncheckAll.png").createImage());
        uncheckAll.addSelectionListener(uncheckAllListener);
        
        ToolItem hideExisting = new ToolItem(tbar, SWT.CHECK);
//        hideExisting.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED));
        hideExisting.setText("Hide existing");
        
        hideExisting.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                hideExistingValue = !hideExistingValue;
                tree.refresh();
            }
        });        
    }

    private void createViewer(Composite control, int span) {
        tree = new CheckboxTreeViewer(control, SWT.MULTI | SWT.BORDER);
        GridDataFactory.fillDefaults().grab(true, true).span(span, 1).hint(600, 300).applyTo(tree.getControl());

        tree.setCheckStateProvider(checkStateProvider);

        tree.getTree().setHeaderVisible(true);

        tree.addCheckStateListener(checkStateListener);
        dbc.bindSet(ViewersObservables.observeCheckedElements(tree, TreeRequireElement.class), checked);

        TreeViewerColumn name = new TreeViewerColumn(tree, SWT.NONE);
        name.getColumn().setText("Name");
        name.getColumn().setWidth(300);
        name.setLabelProvider(new ProjectsLabelProvider());

        tree.setComparator(new ProjectsComparator());

        // Working set column
        TreeViewerColumn workingSet = new TreeViewerColumn(tree, SWT.NONE);
        workingSet.getColumn().setText("Working set");
        workingSet.getColumn().setWidth(100);
        workingSet.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof RequireProjectEntry) {
                    return ((RequireProjectEntry) element).getWorkingSet().getName();
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
                    return ((RequireProjectEntry) element).getProject().getPath();

                }
                return null;
            }
        });
        
        tree.setFilters(new ViewerFilter() {            
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                if( hideExistingValue) {
                    if( element instanceof RequireProjectEntry) {
                        RequireProjectEntry projectEntry = (RequireProjectEntry) element;
                        if( projectEntry.project.getExistingProjectFullPath() == null) {
                            return true;
                        }
                        if( !projectEntry.project.getFullPath().equals(projectEntry.project.getExistingProjectFullPath())) {
                            return true;
                        }
                        return false;
                    }
                }
                return true;
            }
        });

        tree.setContentProvider(new ProjectsContentProvider());

        tree.setInput(input);
    }

    @Override
    public void setPreviousPage(IWizardPage page) {
        super.setPreviousPage(page);
        try {
            final List<IRequireImportLocation> selection = ((RequireLocationPage) page).getSelection();
            getContainer().run(true, false, new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    setLocation(selection, monitor);
                }
            });
        } catch (Throwable e) {
            RequireCorePlugin.log(e);
        }
    }

    public void setLocation(List<IRequireImportLocation> selection, IProgressMonitor monitor) {

        input.clear();
        monitor.beginTask("Find projects", selection.size() * 10 + 10);

        for (IRequireImportLocation loc : selection) {
            RequireProjectGroup locGroup = new RequireProjectGroup();
            locGroup.setName(loc.getName());
            input.add(locGroup);
            locGroup.setEntries(new ArrayList<ProjectSelectionPage.RequireProjectEntry>());

            SubProgressMonitor sub = new SubProgressMonitor(monitor, 10);
            List<RequireProject> list = RequireProjectEngine.findDotProjects(loc.getLocation(), sub);
            for (RequireProject project : list) {
                RequireProjectEntry e = new RequireProjectEntry(project);
                if (project.getExistingProjectFullPath() == null) {
                    e.setEnabled(false);
                } else {
                    if (project.getExistingProjectFullPath().equals(project.getFullPath())) {
                        e.setEnabled(false);
                    }
                }
                e.setLocation(loc);
                locGroup.getEntries().add(e);
                e.setWorkingSet(locGroup);
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
                IPath prjPath = new Path(prj.project.getPath());
                IPath path = new Path(prj.getLocation().getName()).append(prjPath.removeLastSegments(1));
                if (prjPath.lastSegment().startsWith("com._1c.g5.v8")) {
                    path = path.append(prjPath.lastSegment().substring(13).replace(".", "/"));
                }

                if (path.lastSegment().equals("plugins")) {
                    path = path.removeLastSegments(1);
                }
                if (prefixes.containsKey(path)) {
                    prefixes.get(path).add(prj);
                } else {
                    List<RequireProjectEntry> np = new ArrayList<RequireProjectEntry>();
                    np.add(prj);
                    prefixes.put(path, np);
                }
                // Add top location if not existed
                IPath locPath = new Path(prj.getLocation().getName());
                if (!prefixes.containsKey(locPath)) {
                    prefixes.put(locPath, new ArrayList<RequireProjectEntry>());
                }
            }
        }
        // Reduce groups
        loop: while (true) {
            List<IPath> keys = new ArrayList<IPath>(prefixes.keySet());
            Collections.sort(keys, new Comparator<IPath>() {
                @Override
                public int compare(IPath arg0, IPath arg1) {
                    return Integer.valueOf(arg1.toString().length()).compareTo(arg0.toString().length());
                }

            });
            for (IPath path : keys) {
                List<RequireProjectEntry> list = prefixes.get(path);
                if (list.size() == 1) {
                    // reduce list to parent or unspecified
                    List<RequireProjectEntry> parent = prefixes.get(path.removeLastSegments(1));
                    if (parent != null) {
                        parent.addAll(list);
                        prefixes.remove(path);
                        continue loop;
                    }
                }
            }
            break;
        }
        workingSets.clear();
        for (Map.Entry<IPath, List<RequireProjectEntry>> path : prefixes.entrySet()) {
            String ws = path.getKey().toString().replace("/", ".");
            RequireProjectGroup gr = new RequireProjectGroup();
            gr.setName(ws);
            gr.setEntries(path.getValue());
            workingSets.add(gr);
            for (RequireProjectEntry prj : path.getValue()) {
                prj.setWorkingSet(gr);
            }
        }
    }

    private void processIncludeExclude() {
        tree.getControl().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                final String includePattern = (String) includeFilterValue.getValue();
                final String excludePattern = (String) excludeFilterValue.getValue();
                for (TreeRequireElement ee : input) {
                    if (ee instanceof RequireProjectGroup) {
                        List<RequireProjectEntry> entries = ((RequireProjectGroup) ee).getEntries();
                        int enabled = 0;
                        for (RequireProjectEntry p : entries) {
                            if (isMatch(p, excludePattern)) {
                                p.setEnabled(false);
                                tree.setChecked(p, false);
                                checked.remove(p);
                            } else if (isMatch(p, includePattern)) {
                                p.setEnabled(true);
                                tree.setChecked(p, true);
                                checked.add(p);
                            }
                            enabled += p.isEnabled() ? 1 : 0;
                        }
                        if (enabled == entries.size()) {
                            tree.setChecked(ee, true);
                        }
                        if (enabled == 0) {
                            tree.setChecked(ee, false);
                        }
                    }
                }
            }

        });
    }
}
