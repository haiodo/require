package org.eclipse.require.internal.ui.extrakeys;

import org.eclipse.require.ui.RequireUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;

/**
 * This little extension to Eclispe allows to perform some additional actions
 * over controls by pressing some key sequences.
 * 
 * @author haiodo
 * 
 */
public class ExtraKeysTool implements Listener {
	public void install() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getDisplay().addFilter(SWT.KeyDown, ExtraKeysTool.this);
			}
		});
	}

	@Override
	public void handleEvent(Event event) {
		if (event.widget instanceof Tree) {
			Tree tree = (Tree) event.widget;
			if ((tree.getStyle() & SWT.CHECK) != 0) {
				if (event.character == SWT.SPACE) {
					TreeItem[] selection = tree.getSelection();
					for (TreeItem treeItem : selection) {
						treeItem.setChecked(!treeItem.getChecked());
						sendEvent(event.widget, treeItem, SWT.Selection, SWT.CHECK);
					}
				}
			}
		}
		else if (event.widget instanceof Table) {
			Table table = (Table) event.widget;
			if ((table.getStyle() & SWT.CHECK) != 0) {
				if (event.character == SWT.SPACE) {
					TableItem[] selection = table.getSelection();
					for (TableItem tableItem : selection) {
						tableItem.setChecked(!tableItem.getChecked());
						sendEvent(event.widget, tableItem, SWT.Selection, SWT.CHECK);
					}
				}
			}
		}
	}

	public Event sendEvent(final Widget w, final Widget item, final int event,
			int detail) {
		try {
			Event e1 = new Event();
			e1.widget = w;
			e1.display = w.getDisplay();
			e1.time = (int) System.currentTimeMillis();
			Event e = e1;
			e.item = item;
			e.detail = detail;
			if (e.time == 0) {
				e.time = (int) System.currentTimeMillis();
			}
			e.widget.notifyListeners(event, e);
			return e;
		} catch (SecurityException e) {
			RequireUIPlugin.log(e);
		} catch (IllegalArgumentException e) {
			RequireUIPlugin.log(e);
		}
		return null;
	}
}
