package org.eclpse.require.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.require.config.model.Configuration;
import org.eclipse.require.config.model.ModelFactory;
import org.eclipse.require.ui.RequireUIPlugin;

public class RequireConfigManager {
	private Resource configs = null;
	private IPath root;
	private static RequireConfigManager instance;

	public static RequireConfigManager getInstance() {
		if (instance == null) {
			instance = new RequireConfigManager();
		}
		return instance;
	}

	public RequireConfigManager() {
		root = RequireUIPlugin.getDefault().getStateLocation()
				.append("configs");
		if (!root.toFile().exists()) {
			root.toFile().mkdirs();
		}
		IPath configPath = root.append(".config");
		configs = new XMIResourceImpl(
				URI.createFileURI(configPath.toOSString()));
		if (configPath.toFile().exists()) {
			try {
				configs.load(null);
			} catch (IOException e) {
				RequireUIPlugin.log("Failed to load stored config file", e);
			}
		}
	}

	public List<Configuration> getConfigurations() {
		List<Configuration> result = new ArrayList<Configuration>();
		EList<EObject> contents = configs.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Configuration) {
				result.add((Configuration) eObject);
			}
		}
		return result;
	}

	public Configuration newConfig() {
		Configuration config = ModelFactory.eINSTANCE.createConfiguration();
		configs.getContents().add(config);
		return config;
	}

	public void save() {
		try {
			configs.save(null);
		} catch (IOException e) {
			RequireUIPlugin.log("Failed to save configuration", e);
		}
	}

}
