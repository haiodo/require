package org.eclipse.require.ui;

import java.util.List;

public interface IRequireImportSourceProvider {
	/**
	 * Return Source provider name
	 * 
	 * @return
	 */
	String getName();

	List<IRequireImportLocation> getLocations();
}
