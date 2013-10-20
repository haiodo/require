package org.eclipse.require.internal.ui;

import org.eclipse.require.internal.ui.extrakeys.ExtraKeysTool;
import org.eclipse.ui.IStartup;

public class RequireToolsStartup implements IStartup {

	@Override
	public void earlyStartup() {
		new ExtraKeysTool().install();
	}
}
