package org.require.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ShowDependenciesApplication {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Please specify a base directory file://contentJar and included filters.");
            return;
        }

        String searchRoot = args[0];
        String contentJarFile = args[1];

        List<String> filters = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            filters.add(args[i]);
        }
        Document repositoryContent = null;

        try (ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(contentJarFile))))) {
            ZipEntry nextEntry = zin.getNextEntry();
            if (!nextEntry.getName().equals("content.xml")) {
                System.err.println("Invalid eclipse repository resource...");
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            repositoryContent = builder.parse(zin);
        }

        ShowAllDependencies.generateDependenties(searchRoot, repositoryContent, filters);

    }

}
