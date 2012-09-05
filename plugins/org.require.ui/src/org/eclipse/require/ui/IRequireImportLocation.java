package org.eclipse.require.ui;

import org.eclipse.swt.graphics.Image;

public interface IRequireImportLocation {
	/**
	 * Return selected location in file system.
	 */
	String getLocation();

	/**
	 * Location name;
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Return true if call to browse is required before getting the location.
	 * 
	 * @return
	 */
	boolean isBrowseRequired();

	/**
	 * Do browse before getting location, if return false, then do not continue.
	 * 
	 * @return
	 */
	boolean doBrowse();

	IRequireImportSourceProvider getProvider();
	
	Image getImage();
}
