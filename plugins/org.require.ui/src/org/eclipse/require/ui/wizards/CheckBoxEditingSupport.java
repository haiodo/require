package org.eclipse.require.ui.wizards;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.require.ui.wizards.ProjectSelectionPage.TreeRequireElement;
import org.eclipse.require.ui.wizards.ProjectSelectionPage.RequireProjectEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class CheckBoxEditingSupport extends EditingSupport {

	private CheckboxTreeViewer tree;

	public CheckBoxEditingSupport(CheckboxTreeViewer viewer) {
		super(viewer);
		this.tree = viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof RequireProjectEntry) {
			return new CheckboxCellEditor((Composite) getViewer().getControl(),
					SWT.NONE);
		}
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof RequireProjectEntry;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof TreeRequireElement) {
			return ((RequireProjectEntry) element).isEnabled();
		}
		return Boolean.FALSE;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof RequireProjectEntry && value instanceof Boolean) {
			((RequireProjectEntry) element).setEnabled(((Boolean) value)
					.booleanValue());
			tree.setChecked(element, true);
			tree.update(element, null);
		}
	}
}
