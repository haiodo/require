package org.require.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.require.core.engine.RequireProjectEngine;
import org.require.core.model.RequireProject;

public class DependencyGenerator {

	private static StringBuilder addQuoted(StringBuilder sb, String value) {
		char quote = '"';
		return sb.append(quote).append(value).append(quote);
	}

	public static void generateFolderDependencyDiagram(String diagamFile, String searchRoot,
			final List<String> filters) {
		List<RequireProject> projects = RequireProjectEngine.findDotProjects(searchRoot, new NullProgressMonitor(),
				false);

		projects = projects.stream().filter(e -> {
			String path = e.getParentPath();
			for (String s : filters) {
				if (path.contains(s)) {
					return false;
				}
			}
			return true;
		}).collect(Collectors.toList());

		Map<String, RequireProject> projectNames = new HashMap<>();
		for (RequireProject prj : projects) {
			projectNames.put(prj.getName(), prj);
		}

		StringBuilder sb = new StringBuilder();

		File diagramFile = new File(diagamFile);

		File parentFile = diagramFile.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}

		Map<String, Set<String>> folderFolder = new HashMap<>();

		for (RequireProject prj : projects) {

			// From source check
			String fullPath = prj.getPath();
			boolean skip = false;
			for (String s : filters) {
				if (s.startsWith("+")) {
					if (!fullPath.contains(s.substring(1))) {
						skip = true;
						break;
					}
				}
			}
			if (skip) {
				continue;
			}

			String folder = prj.getParentPath();
			Set<String> to = folderFolder.get(folder);
			if (to == null) {
				to = new HashSet<>();
				folderFolder.put(folder, to);
			}
			for (String dep : prj.getDependencies()) {
				RequireProject rprj = projectNames.get(dep);
				if (rprj != null) {
					String parentPath = rprj.getParentPath();
					if (!parentPath.equals(folder)) {
						to.add(parentPath);
					}
				}
			}
		}

		sb.append("digraph unix {\n" +
		// "\tsize=\"800,600\";\n" +
				"\tnode [color=lightblue2, style=filled];\n");

		for (Map.Entry<String, Set<String>> prj : folderFolder.entrySet()) {
			for (String dep : prj.getValue()) {
				addQuoted(sb, prj.getKey()).append(" -> ");
				addQuoted(sb, dep).append(";\n");
			}
		}

		sb.append("\n}\n");

		try {
			Files.write(diagramFile.toPath(), sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Map.Entry<String, Set<String>> folderE : folderFolder.entrySet()) {
			if (folderE.getValue().size() == 0) {
				continue;
			}
			for (String depE : folderE.getValue()) {
				System.out.println("Dependencies from: " + folderE.getKey() + " to " + depE);
				// Print all entties in prj have links to dep

				for (RequireProject prj : projects) {
					String folder = prj.getParentPath();

					if (!folder.equals(folderE.getKey())) {
						continue;
					}

					String fullPath = prj.getPath();
					boolean skip = false;
					for (String s : filters) {
						if (s.startsWith("+")) {
							if (!fullPath.contains(s.substring(1))) {
								skip = true;
								break;
							}
						}
					}
					if (skip) {
						continue;
					}

					for (String dep : prj.getDependencies()) {
						RequireProject rprj = projectNames.get(dep);
						if (rprj != null) {

							String fullPath2 = rprj.getPath();
							boolean skip2 = false;
							for (String s : filters) {
								if (s.startsWith("+")) {
									if (!fullPath2.contains(s.substring(1))) {
										skip2 = true;
										break;
									}
								}
							}
							if (skip2) {
								continue;
							}

							String parentPath = rprj.getParentPath();
							if (parentPath.equals(depE)) {
								System.out.println("\t" + prj.getName() + " depend on " + rprj.getName());
							}
						}
					}
				}
			}
		}
	}

}
