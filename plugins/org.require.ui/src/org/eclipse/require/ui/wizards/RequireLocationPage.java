package org.eclipse.require.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.IRequireImportSourceProvider;
import org.eclipse.require.ui.ImportSourceProviderManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class RequireLocationPage extends WizardPage {
	private DataBindingContext dbc = new DataBindingContext();

	private WritableList checked = new WritableList();
	private WritableValue filterValue = new WritableValue("", String.class);

	protected RequireLocationPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		setDescription("Please select one of require supported locations");

		final List<IRequireImportLocation> locations = new ArrayList<IRequireImportLocation>();
		List<IRequireImportSourceProvider> providers = ImportSourceProviderManager
				.getInstance().getProviders();
		for (IRequireImportSourceProvider provider : providers) {
			locations.addAll(provider.getLocations());
		}

		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(parent);
		Composite control = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(control);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);

		Text text = new Text(control, SWT.SINGLE | SWT.BORDER | SWT.SEARCH
				| SWT.ICON_CANCEL);
		text.setFocus();

		ISWTObservableValue modify = SWTObservables.observeText(text,
				SWT.Modify);
		dbc.bindValue(modify, filterValue);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1)
				.applyTo(text);

		final TableViewer table = new TableViewer(control, SWT.MULTI);

		text.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					table.getControl().setFocus();
					String pattern = (String) filterValue.getValue();
					if (pattern.trim().length() == 0) {
						pattern = null;
					}
					IRequireImportLocation toSelect = null;
					if (pattern != null) {
						for (IRequireImportLocation loc : locations) {
							if (!isFiltered(pattern, loc)) {
								toSelect = loc;
								break;
							}
						}
					}
					if (toSelect != null) {
						table.setSelection(new StructuredSelection(toSelect));
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		filterValue.addChangeListener(new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				final String pattern = (String) filterValue.getValue();
				table.getControl().getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						table.refresh(true);
						// Select most suitable name

						String pat = pattern;
						if (pattern.trim().length() == 0) {
							pat = null;
						}
						IRequireImportLocation toSelect = null;
						int len = Integer.MAX_VALUE;
						if (pat != null) {
							for (IRequireImportLocation loc : locations) {
								if (isFiltered(pat, loc)) {
									if (loc.getName().length() < len) {
										len = loc.getName().length();
										toSelect = loc;
									}
								}
							}
						}
						if (toSelect != null) {
							table.setSelection(new StructuredSelection(toSelect));
						}

					};
				});
			}
		});
		table.setFilters(new ViewerFilter[] { new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (filterValue.getValue() != null && element != null) {
					String pattern = (String) filterValue.getValue();
					if (pattern.trim().length() == 0) {
						return true;
					}
					IRequireImportLocation loc = (IRequireImportLocation) element;
					return isFiltered(pattern, loc);
				}
				return true;
			}
		} });

		GridDataFactory.fillDefaults().grab(true, true).hint(600, 400)
				.applyTo(table.getControl());

		table.getTable().setHeaderVisible(true);

		TableViewerColumn nameColumn = new TableViewerColumn(table, SWT.NONE);
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IRequireImportLocation) element).getName();
			}

			@Override
			public Image getImage(Object element) {
				return ((IRequireImportLocation) element).getImage();
			}
		});
		nameColumn.getColumn().setWidth(100);
		nameColumn.getColumn().setText("Name");

		TableViewerColumn typeColumn = new TableViewerColumn(table, SWT.NONE);
		typeColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IRequireImportLocation) element).getProvider()
						.getName();
			}
		});
		typeColumn.getColumn().setWidth(100);
		typeColumn.getColumn().setText("Source");

		TableViewerColumn locationColumn = new TableViewerColumn(table,
				SWT.NONE);
		locationColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				IRequireImportLocation el = (IRequireImportLocation) element;
				return !el.isBrowseRequired() ? el.getLocation() : "";
			}

			@Override
			public Image getImage(Object element) {
				return PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_FOLDER);
			}

		});
		locationColumn.getColumn().setWidth(300);
		locationColumn.getColumn().setText("Location");

		table.setContentProvider(new ArrayContentProvider());
		table.setInput(locations);

		FontRegistry fr = new FontRegistry();
		fr.put("sans", new FontData[] { new FontData("sans", 14, SWT.NONE) });

		table.getTable().setFont(fr.get("sans"));

		dbc.bindList(ViewersObservables.observeMultiSelection(table), checked);
		checked.addChangeListener(new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				setPageComplete(checked.size() > 0);
			}
		});
		setControl(control);
		setPageComplete(checked.size() > 0);
	}

	private boolean isFiltered(String pattern, IRequireImportLocation loc) {
		if (loc.getName().startsWith(pattern)) {
			return true;
		}
		return false;
	}
}
