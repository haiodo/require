package org.eclipse.require.ui.actions;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.WorkbenchPlugin;

public class PathSelectPopupDialog extends PopupDialog {

	public PathSelectPopupDialog(IWorkbenchWindow window) {
		super(window.getShell(), SWT.RESIZE, true, true, // persist size
				false, // but not location
				true, true, null, "Start typing path");

		refresh("");
	}

	@Override
	protected Control createTitleControl(Composite parent) {

		viewer = new TextViewer(parent, SWT.SINGLE);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(viewer.getControl());
		viewer.getControl().addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// do nothing
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.TAB:
					break;
				case SWT.CR:
				case SWT.KEYPAD_CR:
					break;
				case SWT.ARROW_UP:
					break;
				case SWT.ARROW_DOWN:
					break;
				}
			}
		});
		return viewer.getControl();

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite area = (Composite) super.createDialogArea(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(area);

		getShell().addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				int height = area.getSize().y / 2;
				area.layout();

			}
		});
		return area;
	}

	@Override
	protected Control getFocusControl() {
		return viewer.getControl();
	}

	protected IDialogSettings getDialogSettings() {
		final IDialogSettings workbenchDialogSettings = WorkbenchPlugin.getDefault().getDialogSettings();
		IDialogSettings result = workbenchDialogSettings.getSection(getId());
		if (result == null) {
			result = workbenchDialogSettings.addNewSection(getId());
		}
		return result;
	}

	protected String getId() {
		return "org.require.ui.openPathDialog"; //$NON-NLS-1$
	}

	protected void refresh(String text) {
	}

	private void setFilterText(String text) {
		viewer.getDocument().set(text);
		focusFilterText();
	}

	private void focusFilterText() {
		viewer.getControl().setFocus();
		viewer.setSelectedRange(viewer.getDocument().getLength(), 0);
	}

	private boolean closed = false;
	private TextViewer viewer;

	@Override
	public boolean close() {
		closed = true;
		return super.close();
	}
}
