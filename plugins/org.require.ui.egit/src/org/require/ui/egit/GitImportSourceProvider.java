package org.require.ui.egit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.core.Activator;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.IRequireImportSourceProvider;

public class GitImportSourceProvider implements IRequireImportSourceProvider {

	public GitImportSourceProvider() {
	}

	public String getName() {
		return "git";
	}

	public List<IRequireImportLocation> getLocations() {
		Repository[] repositories = Activator.getDefault().getRepositoryCache()
				.getAllRepositories();
		List<IRequireImportLocation> locations = new ArrayList<IRequireImportLocation>();
		for (Repository repository : repositories) {
			locations.add(new GitRequireImportLocation(this, repository));
		}
		return locations;
	}
}
