package org.eclipse.require.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ImportSourceProviderManager {
	private static ImportSourceProviderManager manager;
	private List<IRequireImportSourceProvider> providers = new ArrayList<IRequireImportSourceProvider>();

	private ImportSourceProviderManager() {
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						RequireUIPlugin.PLUGIN_ID + ".importSourceProvider");
		for (IConfigurationElement config : configs) {
			try {
				IRequireImportSourceProvider provider = (IRequireImportSourceProvider) config
						.createExecutableExtension("class");
				providers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public static ImportSourceProviderManager getInstance() {
		initialize();
		return manager;
	}

	private synchronized static void initialize() {
		if (manager == null) {
			manager = new ImportSourceProviderManager();
		}
	}

	public List<IRequireImportSourceProvider> getProviders() {
		return providers;
	}
}
