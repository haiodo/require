package org.require.core;

public class DependenciesApplication {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please specify a base directory and a output .dot file to generate");
			return;
		}
		String diagamFile = args[1];
		
		String searchRoot = args[0];
		
		DependencyGenerator.generateFolderDependencyDiagram(diagamFile, searchRoot);

	}

}
