package org.require.core.engine;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.internal.resources.ProjectDescriptionReader;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.ManifestElement;
import org.require.core.RequireCorePlugin;
import org.require.core.model.ConfigurationFactory;
import org.require.core.model.RequireProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class RequireProjectEngine {

    public static List<RequireProject> findDotProjects(final String basePath, final IProgressMonitor monitor) {
        return findDotProjects(basePath, monitor, true);
    }

    public static List<RequireProject> findDotProjects(final String basePath, final IProgressMonitor monitor, boolean parseDotProjectFile) {
        final int segms = new Path(basePath).segmentCount();
        monitor.beginTask("Process location:" + basePath, -1);
        final List<RequireProject> result = new ArrayList<RequireProject>();
        traverseFolders(new File(basePath), new ITraverseDirRunner() {
            @Override
            public boolean proceed(File dir) {
                monitor.worked(1);
                File dotFile = new File(dir, ".project");
                if (dir.toString().contains("bin") || dir.toString().contains("target")) {
                    return false;
                }
                if (dotFile.exists() && dotFile.isFile()) {
                    checkAddDotProject(dir, dotFile, segms, result, parseDotProjectFile);
                }
                return true;
            }
        });
        monitor.done();
        return result;
    }

    public static void checkAddDotProject(File dir, File dotFile, int segments, List<RequireProject> result, boolean parseDotProjectFile) {

        if (parseDotProjectFile) {
            InputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(dotFile));
                InputSource source = new InputSource(in);
                ProjectDescription description = new ProjectDescriptionReader().read(source);

                RequireProject info = ConfigurationFactory.eINSTANCE.createRequireProject();

                info.setName(description.getName());
                updatePaths(dir, segments, info);

                IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
                boolean exists = project.exists();
                if (exists) {
                    URI locationURI = project.getDescription().getLocationURI();
                    if (locationURI != null) {
                        info.setExistingProjectFullPath(locationURI.getPath());
                    }
                }
                info.setProjectExists(exists);

                Map<String, String> manifest = parseManifest(dotFile);
                parseDependencies(info, manifest);

                result.add(info);

            } catch (Throwable e) {
                RequireCorePlugin.log(e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Throwable e) {
                        // ignore
                    }
                }
            }
        } else {
            // Check if project has manifest and retrive information from it.
            Map<String, String> manifest = parseManifest(dotFile);

            if (manifest != null) {
                String name = manifest.get("Bundle-SymbolicName");
                if (name != null) {
                    RequireProject info = ConfigurationFactory.eINSTANCE.createRequireProject();

                    updatePaths(dir, segments, info);

                    int pos = name.indexOf(";");
                    if (pos != -1) {
                        name = name.substring(0, pos);
                    }
                    info.setName(name);
                    parseDependencies(info, manifest);

                    result.add(info);
                }
            } else {
                RequireProject info = parseFeature(dotFile);
                if (info != null) {
                    updatePaths(dir, segments, info);
                    result.add(info);
                }
            }

        }
    }

    private static void updatePaths(File dir, int segments, RequireProject info) {
        info.setFullPath(new Path(dir.getAbsolutePath()).toOSString());
        info.setPath(new Path(dir.getAbsolutePath()).removeFirstSegments(segments).setDevice(null).toOSString());

        IPath parentPath = new Path(dir.getAbsolutePath()).removeFirstSegments(segments).removeLastSegments(1).setDevice(null);
        if (parentPath.lastSegment().equals("plugins") || parentPath.lastSegment().equals("features")) {
            parentPath = parentPath.removeLastSegments(1);
        }
        info.setParentPath(parentPath.toOSString());
    }

    private static void parseDependencies(RequireProject info, Map<String, String> manifest) {
        if (manifest != null) {
            String reqBundles = manifest.get("Require-Bundle");
            if (reqBundles != null) {
                parseRerequireBundle(info, reqBundles);
            }

            String classPath = manifest.get("Bundle-ClassPath");
            if (classPath != null) {
                StringTokenizer tk = new StringTokenizer(classPath, ",");
                while (tk.hasMoreTokens()) {
                    String el = tk.nextToken().trim();
                    if (!".".equals(el)) {
                        info.getJars().add(el);
                    }
                }
            }
        }
    }

    private static void parseRerequireBundle(RequireProject info, String reqBundles) {
        StringBuilder sb = new StringBuilder();
        char[] chars = reqBundles.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            if (c == ',') {
                if (sb.length() > 0) {
                    info.getDependencies().add(sb.toString().trim());
                    sb.setLength(0);
                }
                i++;
                continue; // Skip this symbol
            }
            if (c == ';') {
                if (sb.length() > 0) {
                    info.getDependencies().add(sb.toString().trim());
                    sb.setLength(0);
                }
                i++;
                // We need to wait for next ,
                boolean inRange = false;
                while (i < chars.length) {
                    c = chars[i];
                    if (c == ',' && !inRange) {
                        break;
                    }
                    if (c == '[' || c == '(') {
                        inRange = true;
                    }
                    if (c == ']' || c == ')') {
                        inRange = false;
                    }
                    i++;
                }
            } else {
                sb.append(c);
                i++;
            }
        }
    }

    private static Map<String, String> parseManifest(File dotFile) {
        File manifestDir = new File(dotFile.getParent(), "META-INF");
        if (manifestDir.exists()) {
            File manifestFile = new File(manifestDir, "MANIFEST.MF");
            if (manifestFile.exists()) {
                try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(manifestFile))) {
                    Map<String, String> manifest = ManifestElement.parseBundleManifest(bin, null);
                    if (manifest != null) {
                        return manifest;
                    }
                } catch (Exception e) {
                } finally {
                }
            }
        }
        return null;
    }

    private static RequireProject parseFeature(File dotFile) {
        File featureXml = new File(dotFile.getParent(), "feature.xml");
        if (featureXml.exists()) {
            RequireProject info = ConfigurationFactory.eINSTANCE.createRequireProject();
            try (InputStream zin = new BufferedInputStream(new FileInputStream(featureXml))) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(zin);

                // Add plugin dependencies
                NodeList nodeList = document.getElementsByTagName("plugin");
                if (nodeList != null && nodeList.getLength() > 0) {
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Element el = (Element) nodeList.item(i);
                        String pluginId = el.getAttribute("id");
                        if (pluginId != null) {
                            info.getDependencies().add(pluginId);
                        }
                    }
                }

                info.setName(document.getDocumentElement().getAttribute("id"));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
            return info;
        }
        return null;
    }

    private static interface ITraverseDirRunner {
        boolean proceed(File dir);
    }

    public static void traverseFolders(File dir, ITraverseDirRunner run) {
        if (dir.exists() && dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    if (run.proceed(file)) {
                        traverseFolders(file, run);
                    }
                }
            }
        }
    }
}
