package org.eclipse.require.ui.editors.config;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class RequireConfigWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
}
