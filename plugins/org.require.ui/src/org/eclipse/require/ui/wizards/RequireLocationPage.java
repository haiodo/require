package org.eclipse.require.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.IRequireImportSourceProvider;
import org.eclipse.require.ui.ImportSourceProviderManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class RequireLocationPage extends WizardPage {

	protected RequireLocationPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		setDescription("Please select one of require supported locations");

		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(parent);
		Composite control = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(control);

		CheckboxTableViewer table = CheckboxTableViewer.newCheckList(parent,
				SWT.NONE);

		GridDataFactory.fillDefaults().grab(true, true).hint(600, 400)
				.applyTo(table.getControl());

		table.getTable().setHeaderVisible(true);

		List<IRequireImportLocation> locations = new ArrayList<IRequireImportLocation>();
		List<IRequireImportSourceProvider> providers = ImportSourceProviderManager
				.getInstance().getProviders();
		for (IRequireImportSourceProvider provider : providers) {
			locations.addAll(provider.getLocations());
		}

		TableViewerColumn nameColumn = new TableViewerColumn(table, SWT.NONE);
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IRequireImportLocation) element).getName();
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
		});
		locationColumn.getColumn().setWidth(300);
		locationColumn.getColumn().setText("Location");

		table.setContentProvider(new ArrayContentProvider());
		table.setInput(locations);

		setControl(control);

	}
}
