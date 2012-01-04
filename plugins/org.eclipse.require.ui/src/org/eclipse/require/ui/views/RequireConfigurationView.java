package org.eclipse.require.ui.views;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class RequireConfigurationView extends ViewPart {
	private TreeViewer viewer;
//	private ObservableList<>
	
	
	public RequireConfigurationView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(parent);
		viewer = new TreeViewer(parent);
		
		
	}

	@Override
	public void setFocus() {
	}

}
