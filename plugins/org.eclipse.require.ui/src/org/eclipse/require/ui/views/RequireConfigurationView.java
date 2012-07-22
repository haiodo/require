package org.eclipse.require.ui.views;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.require.config.model.Configuration;
import org.eclipse.require.config.model.ModelPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclpse.require.config.RequireConfigManager;

public class RequireConfigurationView extends ViewPart {
	private TableViewer viewer;
	private DataBindingContext dbc;
	private List<Configuration> configurations;
	private WritableList list;

	// private ObservableList<>

	public RequireConfigurationView() {
		configurations = RequireConfigManager.getInstance().getConfigurations();
		if (configurations.size() == 0) {
			// create few demo
			Configuration config = RequireConfigManager.getInstance()
					.newConfig();
			config.setName("q7");
			config.setFilePath("/home/haiodo/Develop/git/q7");

			config = RequireConfigManager.getInstance().newConfig();
			config.setName("ecl");
			config.setFilePath("/home/haiodo/Develop/git/ecl");
			config = RequireConfigManager.getInstance().newConfig();
			config.setName("q7-server");
			config.setFilePath("/home/haiodo/Develop/git/q7server");
			RequireConfigManager.getInstance().save();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(parent);
		viewer = new TableViewer(parent);
		Table table = viewer.getTable();
		GridDataFactory.fillDefaults().grab(true, true).applyTo(table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		TableColumn nameCl = new TableViewerColumn(viewer, SWT.NONE)
				.getColumn();
		nameCl.setText("Name");
		nameCl.setWidth(100);
		TableColumn activeCl = new TableViewerColumn(viewer, SWT.NONE)
				.getColumn();
		activeCl.setText("Active");
		activeCl.setWidth(50);
		TableColumn projectCountCl = (new TableViewerColumn(viewer, SWT.NONE))
				.getColumn();
		projectCountCl.setWidth(50);
		projectCountCl.setText("Project count");
		TableColumn filePathCl = (new TableViewerColumn(viewer, SWT.NONE))
				.getColumn();
		filePathCl.setWidth(100);
		filePathCl.setText("File Path");
		TableColumn rootFolderCl = (new TableViewerColumn(viewer, SWT.NONE))
				.getColumn();
		rootFolderCl.setWidth(100);
		rootFolderCl.setText("Root Folder");
		TableColumn syncCl = (new TableViewerColumn(viewer, SWT.NONE))
				.getColumn();
		syncCl.setWidth(100);
		syncCl.setText("Last synchronization");

		ObservableListContentProvider cp = new ObservableListContentProvider();
		list = new WritableList(configurations, Configuration.class);
		viewer.setContentProvider(cp);

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				cp.getKnownElements(),
				new EStructuralFeature[] {
						ModelPackage.eINSTANCE.getConfiguration_Name(),
						ModelPackage.eINSTANCE.getConfiguration_Enabled(),
						ModelPackage.eINSTANCE.getConfiguration_Projects(),
						ModelPackage.eINSTANCE.getConfiguration_FilePath(),
						ModelPackage.eINSTANCE.getConfiguration_RootFolder(),
						ModelPackage.eINSTANCE
								.getConfiguration_LastSynchronization() });
		viewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		viewer.setInput(list);
	}

	@Override
	public void setFocus() {
	}

}
