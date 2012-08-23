package org.require.ui.egit;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.IRequireImportSourceProvider;

public class GitRequireImportLocation implements IRequireImportLocation {

	private Repository repository;
	private IRequireImportSourceProvider provider;

	public GitRequireImportLocation(IRequireImportSourceProvider provider,
			Repository repository) {
		this.provider = provider;
		this.repository = repository;
	}

	public IRequireImportSourceProvider getProvider() {
		return provider;
	}

	public String getLocation() {
		return repository.getWorkTree().getAbsolutePath();
	}

	public String getName() {
		return repository.getWorkTree().getName();
	}

	public boolean isBrowseRequired() {
		return false;
	}

	public boolean doBrowse() {
		return true;
	}
}
