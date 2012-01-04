package org.eclipse.require.ui.editors.config;

import org.eclipse.ui.editors.text.TextEditor;

public class RequireConfigurationEditor extends TextEditor {

	private ColorManager colorManager;

	public RequireConfigurationEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new RequireConfigConfiguration(
				colorManager));
		setDocumentProvider(new RequireConfigDocumentProvider());
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
