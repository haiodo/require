package org.require.ui.egit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.core.Activator;
import org.eclipse.egit.core.RepositoryUtil;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.require.ui.IRequireImportLocation;
import org.eclipse.require.ui.IRequireImportSourceProvider;

public class GitImportSourceProvider
    implements IRequireImportSourceProvider
{

    public GitImportSourceProvider()
    {

    }

    public String getName()
    {
        return "git";
    }

    public List<IRequireImportLocation> getLocations()
    {
        Activator gitPlugin = Activator.getDefault();
        RepositoryUtil util = gitPlugin.getRepositoryUtil();
        List<String> configuredRepositories = util.getConfiguredRepositories();

        List<IRequireImportLocation> locations =
            new ArrayList<IRequireImportLocation>();
        for (String repo : configuredRepositories)
        {
            if (new File(repo).exists())
            {
                try
                {
                    FileRepository fileRepo = new FileRepository(repo);
                    if (fileRepo.getConfig() != null)
                    {
                        locations.add(new GitRequireImportLocation(this,
                            fileRepo));
                    }
                }
                catch (IOException e)
                {
                    RequireGitUIPlugin.log("Failed to access git repository: "
                        + repo, e);
                }
            }
        }
        return locations;
    }
}
