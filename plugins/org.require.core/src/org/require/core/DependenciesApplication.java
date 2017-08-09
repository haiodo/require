package org.require.core;

import java.util.ArrayList;
import java.util.List;

public class DependenciesApplication {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Please specify a base directory and a output .dot file to generate");
			return;
		}
		String diagamFile = args[1];

		String searchRoot = args[0];

		List<String> filters = new ArrayList<>();
		for (int i = 2; i < args.length; i++) {
			filters.add(args[i]);
		}
		DependencyGenerator.generateFolderDependencyDiagram(diagamFile, searchRoot, filters);

	}

}
