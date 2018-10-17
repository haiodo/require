package org.require.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.require.core.engine.RequireProjectEngine;
import org.require.core.model.RequireProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ShowAllDependencies {

    public static void generateDependenties(String searchRoot, Document repository, final List<String> filters) throws ParserConfigurationException {
        List<RequireProject> projects = RequireProjectEngine.findDotProjects(searchRoot, new NullProgressMonitor(), false);

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

        Map<String, List<RequireProject>> projectDeps = new HashMap<>();

        List<DepInfo> allDeps = new ArrayList<>();

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

            if (prj.getJars().size() > 0) {
                for (String j : prj.getJars()) {
                    allDeps.addAll(processJarFile(prj, j));
                }
            }

            for (String dep : prj.getDependencies()) {
                if (projectNames.containsKey(dep)) {
                    continue;
                }
                List<RequireProject> deps = projectDeps.get(dep);
                if (deps == null) {
                    deps = new ArrayList<RequireProject>();
                    projectDeps.put(dep, deps);
                }
                deps.add(prj);
            }
        }

        // Print JAR deps
        System.err.println("Bundled JARS");
        printUsedJars(allDeps, repository);
        //        printClean(allDeps);

        System.err.println("Eclipse platform deps");
        //        allDeps = calcDependencies(projectDeps, repository);
//        printUsedDeps(allDeps);
        //        printClean(allDeps);

    }

    private static List<DepInfo> processJarFile(RequireProject prj, String j) {

        File jarFile = new File(prj.getFullPath(), j);
        List<DepInfo> deps = new ArrayList<>();
        if (!jarFile.exists()) {
            System.err.println("Jar file doesn't exists: " + jarFile.getAbsolutePath());
        } else {

            try (JarFile jarJarFile = new JarFile(jarFile)) {
                Manifest manifest = jarJarFile.getManifest();
                if (manifest != null) {
                    Attributes mainAttributes = manifest.getMainAttributes();

                    DepInfo dep = new DepInfo();
                    dep.name = new Path(jarFile.getName()).lastSegment();
                    dep.path = prj.getPath() + "/" + j;
                    dep.providerName = "unknown";
                    dep.prj = prj;
                    dep.size = jarFile.length();

                    processAttributes(dep, mainAttributes);

                    deps.add(dep);

                    for (Map.Entry<String, Attributes> attr : manifest.getEntries().entrySet()) {
                        DepInfo cdep = new DepInfo();
                        cdep.name = dep.name;
                        cdep.path = prj.getPath() + "/" + j + "#/" + attr.getKey();
                        cdep.providerName = null;
                        if (cdep.path.contains("org/eclipse") && !cdep.path.endsWith(".class")) {
                            cdep.providerName = "Eclipse";
                        }

                        processAttributes(cdep, attr.getValue());

                        if (cdep.providerName != null) {
                            deps.add(cdep);
                            //                            deps.remove(dep);
                        }
                    }
                    JarCorrector.correctJarFile(dep);
                }
            } catch (Exception e) {
            } finally {
            }
        }

        return deps;
    }

    private static void processAttributes(DepInfo dep, Attributes mainAttributes) {
        dep.license = mainAttributes.getValue("Bundle-License");
        //        String bundleSymName = mainAttributes.getValue("Bundle-SymbolicName");
        //        if (bundleSymName != null) {
        //            dep.name = bundleSymName;
        //        }
        String fullName = mainAttributes.getValue("Implementation-Title");
        if (fullName != null) {
            dep.fullName = fullName;
        }

        fullName = mainAttributes.getValue("Bundle-Name");
        if (fullName != null) {
            dep.fullName = fullName;
        }
        fullName = mainAttributes.getValue("Specification-Title");
        if (fullName != null) {
            dep.fullName = fullName;
        }

        String prName = mainAttributes.getValue("Implementation-Vendor");
        if (prName != null) {
            dep.providerName = prName;
        }
        prName = mainAttributes.getValue("Implementation-Vendor-Id");
        if (prName != null) {
            dep.providerName = prName;
        }

        prName = mainAttributes.getValue("Bundle-Vendor");
        if (prName != null) {
            dep.providerName = prName;
        }
        prName = mainAttributes.getValue("Specification-Vendor");
        if (prName != null) {
            dep.providerName = prName;
        }

        if (dep.fullName != null && dep.fullName.contains("Google") || dep.name.toLowerCase().contains("google")) {
            dep.providerName = "Google";
        }

        if (dep.providerName == null && dep.license != null && dep.license.startsWith("http")) {
            dep.providerName = dep.fullName;
        }

        dep.sourceUri = mainAttributes.getValue("Implementation-URL");
    }

    static class DepInfo {
        String name;
        String providerName;
        String fullName;
        String sourceUri;
        String version;
        long size;
        List<String> bundleDeps;

        RequireProject prj;

        String path;
        String license;

        public void addDep(String dep) {
            if (bundleDeps == null) {
                bundleDeps = new ArrayList<>();
            }
            bundleDeps.add(dep);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            //            if (name != null) {
            //                sb.append(name);
            //            }
            if (fullName != null) {
                sb.append(" fn: ").append(fullName);
            }
            if (path != null) {
                sb.append(" path:").append(path);
            }
            //            if (license != null) {
            //                sb.append(" license: " + license);
            //            }
            if (size != 0) {
                sb.append(" size: " + size);
            }
            return sb.toString();
        }

        public String toString2() {
            StringBuilder sb = new StringBuilder();
            if (fullName != null) {
                sb.append(fullName);
            }
            if (license != null) {
                sb.append("\n* license: " + license);
            }
            return sb.toString();
        }
    }

    private static List<DepInfo> calcDependencies(Map<String, List<RequireProject>> projectDeps, Document repository) {
        Map<String, DepInfo> infos = calcRepositoryInfo(repository);

        Map<String, DepInfo> used = new HashMap<>();

        for (String depName : projectDeps.keySet()) {
            DepInfo info = infos.get(depName);
            if (info != null) {
                used.put(info.name, info);
                fillDeps(used, info, infos);
            }
        }

        return new ArrayList<>(used.values());

    }

    private static Map<String, DepInfo> calcRepositoryInfo(Document repository) {
        NodeList elementsByTagName = repository.getElementsByTagName("unit");

        Map<String, DepInfo> infos = new HashMap<>();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Element el = (Element) elementsByTagName.item(i);
            DepInfo info = new DepInfo();
            info.path = "*update-site*";
            info.name = el.getAttribute("id");
            info.version = el.getAttribute("version");

            // Parse properties
            NodeList properties = el.getElementsByTagName("property");
            Map<String, String> namedProps = new HashMap<>();
            for (int j = 0; j < properties.getLength(); j++) {
                Element prop = (Element) properties.item(j);
                String name = prop.getAttribute("name");
                String value = prop.getAttribute("value");
                namedProps.put(name, value);
            }

            String provider = namedProps.get("org.eclipse.equinox.p2.provider");
            String fullName = namedProps.get("org.eclipse.equinox.p2.name");

            if (provider != null && provider.startsWith("%")) {
                provider = findPropertyName(namedProps, provider);
            }

            if (fullName != null && fullName.startsWith("%")) {
                fullName = findPropertyName(namedProps, fullName);
            }

            info.providerName = provider;
            info.fullName = fullName;

            // Parse bundles deps if have ones.

            NodeList required = el.getElementsByTagName("required");
            for (int j = 0; j < required.getLength(); j++) {
                Element prop = (Element) required.item(j);
                String namespace = prop.getAttribute("namespace");
                if ("osgi.bundle".equals(namespace)) {
                    info.addDep(prop.getAttribute("name"));
                }
            }
            infos.put(info.name, info);
        }
        return infos;
    }

    private static void fillDeps(Map<String, DepInfo> used, DepInfo info, Map<String, DepInfo> infos) {
        if (info.bundleDeps != null) {
            for (String dep : info.bundleDeps) {
                DepInfo depInfo = infos.get(dep);
                if (depInfo != null && !used.containsKey(depInfo.name)) {
                    used.put(depInfo.name, depInfo);
                    fillDeps(used, depInfo, infos);
                }
            }
        }

    }

    static String getN(String val) {
        if (val == null) {
            return "";
        }
        return val;
    }

    static String getN1(String val) {
        if (val == null) {
            return " ";
        }
        return val;
    }

    private static void printUsedDeps(List<DepInfo> used) {
        Map<String, List<DepInfo>> byProvider = used.stream().collect(Collectors.groupingBy(e -> getUnifiedProvider(e.providerName, e.name)));
        for (Map.Entry<String, List<DepInfo>> e : byProvider.entrySet()) {
            System.out.println("Provider: " + e.getKey());

            Map<String, List<DepInfo>> byName = e.getValue().stream().sorted((a, b) -> a.name.compareToIgnoreCase(b.name))
                    .collect(Collectors.groupingBy(eee -> getBundleName(eee.name)));

            for (Map.Entry<String, List<DepInfo>> infoE : byName.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("\t").append(infoE.getKey());

                if (infoE.getValue().size() > 1) {
                    sb.append("\n\t\t");
                    sb.append(infoE.getValue().stream().map(ee -> ee.toString()).collect(Collectors.joining("\n\t\t")));
                } else {
                    DepInfo de = infoE.getValue().get(0);
                    sb.append(" " + de);
                }
                System.out.println(sb.toString());
            }

        }
    }
    private static void printUsedJars(List<DepInfo> used, Document repository) {
        
        Map<String, DepInfo> info = calcRepositoryInfo(repository);
        long waste = 0;
        long total = 0;
        Map<String, List<DepInfo>> byProvider = used.stream().collect(Collectors.groupingBy(e -> getUnifiedProvider(e.providerName, e.name)));
        for (Map.Entry<String, List<DepInfo>> e : byProvider.entrySet()) {
            System.out.println("Provider: " + e.getKey());

            Map<String, List<DepInfo>> byName = e.getValue().stream().sorted((a, b) -> a.name.compareToIgnoreCase(b.name))
                    .collect(Collectors.groupingBy(eee -> getBundleName(eee.name)));

            for (Map.Entry<String, List<DepInfo>> infoE : byName.entrySet()) {
                StringBuilder sb = new StringBuilder();
                
                String bName = getBundleName2(infoE.getKey());
                DepInfo di = info.get(bName);
                sb.append("\t").append(infoE.getKey());
                if( di != null) {
                    sb.append("***ORBIT MODULE EXISTS***");
                }

                if (infoE.getValue().size() > 1) {
                    sb.append("\n\t\t");
                    sb.append(infoE.getValue().stream().map(ee -> ee.toString()).collect(Collectors.joining("\n\t\t")));
                    total += infoE.getValue().stream().mapToLong(e33 -> e33.size).sum();
                    waste += infoE.getValue().stream().skip(1).mapToLong(e33 -> e33.size).sum();
                } else {
                    DepInfo de = infoE.getValue().get(0);
                    sb.append(" " + de);
                    total += de.size;
                }
                System.out.println(sb.toString());
            }
        }
        System.err.println("Wasted space:" + waste + " total:" + total );
    }

    private static void printClean(List<DepInfo> used) {
        Map<String, List<DepInfo>> byProvider = used.stream().collect(Collectors.groupingBy(e -> getUnifiedProvider(e.providerName, e.name)));

        List<DepInfo> unknown = null;
        for (Map.Entry<String, List<DepInfo>> e : byProvider.entrySet()) {
            if (e.getKey().equals("unknown")) {
                unknown = e.getValue();
                break;
            }
            System.out.print("|" + e.getKey() + "|");

            Map<String, List<DepInfo>> names = e.getValue().stream().collect(Collectors.groupingBy(ee -> ee.name));

            System.out.print("* " + names.keySet().stream().sorted().collect(Collectors.joining("\n* ")) + "|");
            //            System.out.print("* " +e.getValue().stream().map(e1 -> getN(e1.fullName)).collect(Collectors.joining("\n* ")) + "|");
            System.out.print("* " + e.getValue().stream().map(e1 -> e1.license).filter(l -> l != null).limit(1).collect(Collectors.joining("\n* ")));

            System.out.println("|");
        }

        System.err.println("Unidentified jars");
        if (unknown != null) {
            for (DepInfo di : unknown) {
                System.out.println("|" + di.name + "|" + getN1(di.fullName) + "|" + getN1(di.license) + "|");
            }
        }
    }

    private static String getBundleName(String name) {
        int pos = name.lastIndexOf("-");
        if (pos != -1 && (pos + 1 < name.length()) && Character.isDigit(name.charAt(pos + 1))) {
            // Versioned jar name
            return name.substring(0, pos) + ".jar";
        }
        return name;
    }
    private static String getBundleName2(String name) {
        int pos = name.lastIndexOf("-");
        if (pos != -1 && (pos + 1 < name.length()) && Character.isDigit(name.charAt(pos + 1))) {
            // Versioned jar name
            return name.substring(0, pos);
        }
        return name;
    }

    private static String getUnifiedProvider(String provider, String name) {
        if (provider.toLowerCase().contains("sun microsystems".toLowerCase()) || provider.contains("com.sun")) {
            return "Sun Microsystems, Inc., Oracle Corp";
        }
        if (provider.contains("Eclipse")) {
            return "Eclipse.org";
        }
        if (provider.toLowerCase().contains("apache")) {
            return "Apache Software Foundation";
        }
        if (provider.contains("FasterXML")) {
            return "http://fasterxml.com";
        }
        if (provider.contains("Google")) {
            return "Google";
        }

        return provider.trim();
    }

    private static String findPropertyName(Map<String, String> namedProps, String provider) {
        String varName = provider.substring(1);

        String value = namedProps.get(varName);
        if (value != null) {
            return value;
        }
        value = namedProps.get("df_LT." + varName);
        if (value != null) {
            return value;
        }
        return provider;
    }

}
