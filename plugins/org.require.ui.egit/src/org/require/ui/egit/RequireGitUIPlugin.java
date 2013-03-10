package org.require.ui.egit;

import java.net.URL;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RequireGitUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.require.ui.egit"; //$NON-NLS-1$

	// The shared instance
	private static RequireGitUIPlugin plugin;

	/**
	 * The constructor
	 */
	public RequireGitUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static RequireGitUIPlugin getDefault() {
		return plugin;
	}

	public Image getImage(String path) {
		ImageRegistry registry = getImageRegistry();
		Image image = registry.get(path);
		if (image == null) {
			URL url = getBundle().getEntry(path);
			if (url != null) {
				ImageDescriptor imageDescriptor = ImageDescriptor
						.createFromURL(url);
				registry.put(path, imageDescriptor);
			}
		}
		return registry.get(path);
	}

	public static void log(String msg, Exception e) {
		getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID, msg, e));
	}

}
