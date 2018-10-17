package org.require.core;

public class JarCorrector {

    static void correctJarFile(ShowAllDependencies.DepInfo di) {
        if (di.name.equals("axis-ant.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Axis 1.0";
        }
        if (di.name.equals("axis.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Axis 1.0";
        }
        if (di.name.equals("org.apache.commons.logging_1.1.1.v20080605-1935.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Common Logging Support";
        }
        if (di.name.equals("saaj.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "SOAP with Attachments API for Java (SAAJ)";
        }
        if (di.name.equals("javaxzombie.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Axis 1.0";
        }
        if (di.name.equals("commons-codec-1.2.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Commons Codec";
        }
        if (di.name.equals("javax.wsdl_1.5.1.v200806030408.jar")) {
            di.providerName = "IBM";
            di.fullName = "WSDL4j";
        }
        if (di.name.equals("commons-discovery-0.2.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Commons Discovery";
        }
        if (di.name.equals("commons-httpclient-3.1.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Jakarta Commons HttpClient";
        }
        if (di.name.equals("jaxrpc.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "Java API for XML-Based RPC";
        }
        if (di.name.equals("jfreechart-1.0.12.jar")) {
            di.providerName = "JFree";
            di.fullName = "JFreeChart";
        }
        if (di.name.equals("jfreechart-1.0.12-experimental.jar")) {
            di.providerName = "JFree";
            di.fullName = "JFreeChart";
        }
        if (di.name.equals("jcommon-1.0.15.jar")) {
            di.providerName = "JFree";
            di.fullName = "JFreeChart";
        }
        if (di.name.equals("swtgraphics2d.jar")) {
            di.providerName = "JFree";
            di.fullName = "JFreeChart";
        }
        if (di.name.equals("iText-2.1.3.jar")) {
            di.providerName = "JFree";
            di.fullName = "JFreeChart";
        }
        if (di.name.equals("sqljdbc.jar")) {
            di.providerName = "Microsoft";
            di.fullName = "SQL Server JDBC Driver";
        }
        if (di.name.equals("ojdbc6.jar")) {
            di.providerName = "Oracle";
            di.fullName = "Oracle JDBC Driver";
        }
        if (di.name.equals("mysql-connector-java-5.1.7-bin.jar")) {
            di.providerName = "MySql";
            di.fullName = "Connector/J JDBC Driver";
        }
        if (di.name.equals("postgresql-8.4-701.jdbc4.jar")) {
            di.providerName = "PostgreSQL";
            di.fullName = "JDBC4 POstgreSQL Driver";
        }
        if (di.name.equals("maverick-all.jar")) {
            di.providerName = "SSHTOOLS.COM";
            di.fullName = "SSH libraries";
        }
        if (di.name.equals("Serialio.jar")) {
            di.providerName = "Serialio.com";
            di.fullName = "SerialPort";
        }
        if (di.name.equals("jargs.jar")) {
            di.providerName = "Author: Steve Purcell, Maintainer: Ewan Mellor";
            di.fullName = "JArgs command line option parsing suite for Java";
        }
        if (di.name.equals("Tidy.jar")) {
            di.providerName = "W3C";
            di.fullName = "HTML Tidy";
        }
        if (di.name.equals("derbyclient.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Apache Derby";
        }
        if (di.name.equals("derby.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Apache Derby";
        }
        if (di.name.equals("derbynet.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Apache Derby";
        }
        if (di.name.equals("derbytools.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Apache Derby";
        }
        if (di.name.equals("xmlwriter-2.2.jar")) {
            di.providerName = "Generation Java";
            di.fullName = "Xml Writer";
        }
        if (di.name.equals("jaxen-1.1.1.jar")) {
            di.providerName = "The Code Haus  http://jaxen.codehaus.org";
            di.fullName = "XPATH evaluation engine";
        }
        if (di.name.equals("truezip-6.jar")) {
            di.providerName = "https://truezip.dev.java.net/";
            di.fullName = "ZIP stream API for reading writing zip files";
        }
        if (di.name.equals("org.apache.commons.logging_1.0.4.v20080605-1930.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Commons Logging";
        }
        if (di.name.equals("saaj.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "SOAP with Attachments API for Java (SAAJ)";
        }
        if (di.name.equals("javax.wsdl_1.5.1.v200806030408.jar")) {
            di.providerName = "IBM";
            di.fullName = "WSDL4j";
        }
        if (di.name.equals("EccpressoAll.jar")) {
            di.providerName = "Acresso Inc.";
            di.fullName = "Flex Net Publisher Licensing Client";
        }
        if (di.name.equals("commons-discovery-0.2.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Commons Discovery";
        }
        if (di.name.equals("flexlm.jar")) {
            di.providerName = "Acresso Inc.";
            di.fullName = "Flex Net Publisher Licensing Client";
        }
        if (di.name.equals("axis.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Axis 1.0";
        }
        if (di.name.equals("jaxrpc.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "Java API for XML-Based RPC";
        }
        if (di.name.equals("ireasoningsnmp.jar")) {
            di.providerName = "iReasoning Inc.";
            di.fullName = "SNMP API";
        }
        if (di.name.equals("saxon8-dom.jar")) {
            di.providerName = "Open Source / Saxonica";
            di.fullName = "Saxon-B 8";
        }
        if (di.name.equals("saxon8.jar")) {
            di.providerName = "Open Source / Saxonica";
            di.fullName = "Saxon-B 8";
        }
        if (di.name.equals("smtp.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "part of JavaEE";
        }
        if (di.name.equals("activation.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "part of JavaEE";
        }
        if (di.name.equals("mailapi.jar")) {
            di.providerName = "Sun Microsystems";
            di.fullName = "part of JavaEE";
        }
        if (di.name.equals("MozillaInterfaces.jar")) {
            di.providerName = "Mozilla Foundation";
            di.fullName = "Mozilla Xulrunner";
        }
        if (di.name.equals("commons-beanutils-1.8.0.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Common Bean Utils";
        }
        if (di.name.equals("commons-lang-2.4.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Common Language Suuport";
        }
        if (di.name.equals("commons-logging-1.1.1.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Common Logging Support";
        }
        if (di.name.equals("ezmorph-1.0.5.jar")) {
            di.providerName = "SourceForge";
            di.fullName = "EZMorph";
        }
        if (di.name.equals("commons-collections-3.2.1.jar")) {
            di.providerName = "Apache Software Foundation";
            di.fullName = "Common Collections";
        }
        if (di.name.equals("annotation.jar")) {
            di.providerName = "FusionSoft - http://www.fusionsoft-online.com/annotation.php";
            di.fullName = "Java Inherited Annotations";
        }
        if (di.name.equals("json-lib-2.2.2-jdk15-javadoc.jar")) {
            di.providerName = "SourceForge";
            di.fullName = "JSON";
        }
        if (di.name.equals("json-lib-2.2.2-jdk15-sources.jar")) {
            di.providerName = "SourceForge";
            di.fullName = "JSON";
        }
        if (di.name.equals("json-lib-2.2.2-jdk15.jar")) {
            di.providerName = "SourceForge";
            di.fullName = "JSON";
        }
        if (di.name.equals("jacob.jar")) {
            di.providerName = "SourceForge";
            di.fullName = "JACOB Java Com Bridge - http://sourceforge.net/projects/jacob-project/";
        }
        if (di.name.equals("xmlwriter-2.2.jar")) {
            di.providerName = "Generation Java";
            di.fullName = "Xml Writer";
        }

        if (di.name.equals("abdera-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-client-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-core-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-gdata-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-geo-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-html-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-json-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-main-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-media-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-oauth-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-opensearch-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-serializer-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-sharing-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-extensions-wsse-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-filesystem-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-i18n-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-jcr-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-jdbc-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-parser-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-security-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-server-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("abdera-spring-1.1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("accessors-smart-1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "JSON Small and Fast Parser";
        }
        if (di.name.equals("activation-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Abdera";
        }
        if (di.name.equals("activation.jar")) {
            di.license = "CDDL 1.0";
            di.fullName = "JavaBeans(TM) Activation Framework";
        }
        if (di.name.equals("annotation.jar")) {
            di.license = "Commercial";
            di.fullName = "Fusionsoft";
        }
        if (di.name.equals("annotations-3.0.1.jar")) {
            di.license = "LGPL";
            di.fullName = "?";
        }
        if (di.name.equals("ant-contrib.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Ant";
        }
        if (di.name.equals("ant.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Ant";
        }
        if (di.name.equals("ant.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Ant";
        }
        if (di.name.equals("aopalliance-repackaged-2.5.0-b32.jar")) {
            di.license = "CDDL, GPL, Version 2.0 GPL, Version 1.1";
            di.fullName = "Aopalliance Version 1.0 Repackaged AS A Module";
        }
        if (di.name.equals("args4j-2.0.9.jar")) {
            di.license = "MIT";
            di.fullName = "Command Line Parser";
        }
        if (di.name.equals("asm-5.0.4.jar")) {
            di.license = "BSD";
            di.fullName = "ASM (Bytecode Libraries)";
        }
        if (di.name.equals("asm-all-repackaged-2.2.0-b14.jar")) {
            di.license = "BSD";
            di.fullName = "ASM Library Repackaged AS OSGi Bundle";
        }
        if (di.name.equals("axiom-api-1.2.10.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Axiom";
        }
        if (di.name.equals("axiom-impl-1.2.10.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Axiom";
        }
        if (di.name.equals("axiom-impl-1.2.10.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Axiom";
        }
        if (di.name.equals("axis.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Axis";
        }
        if (di.name.equals("axis.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Axis";
        }
        if (di.name.equals("bcpkix-jdk15on-1.59.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle";
        }
        if (di.name.equals("bcpkix-jdk15on-151.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle";
        }
        if (di.name.equals("bcprov-ext-jdk15on-151.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle Crypto";
        }
        if (di.name.equals("bcprov-jdk15-1.46.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle Crypto";
        }
        if (di.name.equals("bcprov-jdk15on-1.52.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle Crypto";
        }
        if (di.name.equals("bcprov-jdk15on-1.59.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle Crypto";
        }
        if (di.name.equals("bcprov-jdk16-1.46.jar")) {
            di.license = "BouncyCastle";
            di.fullName = "Bouncy Castle Crypto";
        }
        if (di.name.equals("binary-updater.jar")) {
            di.license = "";
            di.fullName = "Spirent";
        }
        if (di.name.equals("biz.aQute.bnd.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "AQute BND";
        }
        if (di.name.equals("byte-buddy-1.7.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Byte Buddy";
        }
        if (di.name.equals("caffeine-2.6.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Caffeine Cache";
        }
        if (di.name.equals("cglib-2.2.0-b14.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "CGLib";
        }
        if (di.name.equals("chardet.jar")) {
            di.license = "";
            di.fullName = "Chardet";
        }
        if (di.name.equals("cmd.sun.jna-1.0.0.jar")) {
            di.license = "?";
            di.fullName = "?";
        }
        if (di.name.equals("commons-beanutils-1.7.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-beanutils-1.8.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-beanutils-1.8.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-cli-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-cli-1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.10.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.11.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-codec-1.8.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-collections-3.2.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-collections-3.2.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-collections-3.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-compress-1.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-compress-1.8.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-discovery-0.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-discovery-0.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-exec-1.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-httpclient-3.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-io-2.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-lang-2.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-lang-2.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-lang-2.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-lang3-3.7.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.0.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-1.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-adapters-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging-api-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-logging.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("commons-ssl.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Commons";
        }
        if (di.name.equals("connect-api-1.0.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Kafka";
        }
        if (di.name.equals("connect-json-1.0.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Kafka";
        }
        if (di.name.equals("converter-jackson-1.9.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Converter: Jackson";
        }
        if (di.name.equals("core.jar")) {
            di.license = "?";
            di.fullName = "Jython Parser";
        }
        if (di.name.equals("dd-plist-1.0.jar")) {
            di.license = "MIT";
            di.fullName = "DD Plist";
        }
        if (di.name.equals("derby-10.13.1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Derby";
        }
        if (di.name.equals("dom4j-1.6.1.jar")) {
            di.license = "BSD";
            di.fullName = "Dom4J";
        }
        if (di.name.equals("eclipselink-2.5.0.jar")) {
            di.license = "EPL, Version 1.0, EDL, Version 1.0";
            di.fullName = "EclipseLink";
        }
        if (di.name.equals("elastic-client-7.2.0.jar")) {
            di.license = "?";
            di.fullName = "Spirent";
        }
        if (di.name.equals("elasticsearch-5.5.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Elasticsearch";
        }
        if (di.name.equals("exec-protocol-7.2.0.jar")) {
            di.license = "?";
            di.fullName = "Spirent";
        }
        if (di.name.equals("exec-streams-common-7.2.0.jar")) {
            di.license = "?";
            di.fullName = "Spirent";
        }
        if (di.name.equals("ezmorph-1.0.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Ezmorph";
        }
        if (di.name.equals("ezmorph-1.0.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Ezmorph";
        }
        if (di.name.equals("ezmorph-1.0.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Ezmorph";
        }
        if (di.name.equals("freemarker-gae-2.3.25.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache FreeMarker";
        }
        if (di.name.equals("geronimo-activation_1.0.2_spec-1.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Geronimo";
        }
        if (di.name.equals("geronimo-activation_1.1_spec-1.0.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Geronimo";
        }
        if (di.name.equals("geronimo-javamail_1.4_spec-1.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Geronimo";
        }
        if (di.name.equals("geronimo-stax-api_1.0_spec-1.0.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Geronimo";
        }
        if (di.name.equals("geronimo-stax-api_1.0_spec-1.0.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache Geronimo";
        }
        if (di.name.equals("google-collections-1.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Collections";
        }
        if (di.name.equals("google-collections-1.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Collections";
        }
        if (di.name.equals("google-http-client-1.20.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google HTTP Client";
        }
        if (di.name.equals("google-http-client-xml-1.20.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google HTTP Client";
        }
        if (di.name.equals("gradle-wrapper.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Gradle";
        }
        if (di.name.equals("grizzly-1.0.28.jar")) {
            di.license = "?";
            di.fullName = "GlassFish Grizzly";
        }
        if (di.name.equals("grizzly-http-server-core-2.3.5.jar")) {
            di.license = "CDDL, GNU GPL";
            di.fullName = "GlassFish Grizzly";
        }
        if (di.name.equals("grizzly-servlet-webserver-1.9.9.jar")) {
            di.license = "CDDL, Version 1.0";
            di.fullName = "GlassFish Grizzly";
        }
        if (di.name.equals("gson-2.8.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Code";
        }
        if (di.name.equals("gson-2.8.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Code";
        }
        if (di.name.equals("gson-2.8.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Code";
        }
        if (di.name.equals("guava-15.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Guava";
        }
        if (di.name.equals("guava-17.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Guava";
        }
        if (di.name.equals("guava-17.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Guava";
        }
        if (di.name.equals("guava-19.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Guava";
        }
        if (di.name.equals("guava-23.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Google Guava";
        }
        if (di.name.equals("hamcrest-core-1.3.jar")) {
            di.license = "BSD, Version 2";
            di.fullName = "Hamcrest";
        }
        if (di.name.equals("hamcrest-library-1.3.jar")) {
            di.license = "BSD, Version 2";
            di.fullName = "Hamcrest";
        }
        if (di.name.equals("HdrHistogram-2.1.9.jar")) {
            di.license = "CCO, Version 1.0";
            di.fullName = "HdrHistogram";
        }
        if (di.name.equals("hk2-api-2.2.0-b14.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hk2-api-2.5.0-b32.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hk2-locator-2.2.0-b14.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hk2-locator-2.5.0-b32.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hk2-utils-2.2.0-b14.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hk2-utils-2.5.0-b32.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("hppc-0.7.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Carrotsearch";
        }
        if (di.name.equals("htmlparser-1.0.5.jar")) {
            di.license = "MIT";
            di.fullName = "Validator";
        }
        if (di.name.equals("httpasyncclient-4.1.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpclient-4.0-beta2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpclient-4.0-beta2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpclient-4.2.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpclient-4.5.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpclient-4.5.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-4.2.1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-4.3-beta1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-4.3-beta1.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-4.4.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-4.4.9.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpcore-nio-4.4.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpmime-4.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("httpmime-4.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Apache HttpComponents";
        }
        if (di.name.equals("icu4j-51_2.jar")) {
            di.license = "ICU";
            di.fullName = "IBM ICU";
        }
        if (di.name.equals("ireasoning.snmp-5.0.29.jar")) {
            di.license = "Commercial";
            di.fullName = "iReasoning SNMP APIs";
        }
        if (di.name.equals("iText-2.1.3.jar")) {
            di.license = "MPL, Version 1.1";
            di.fullName = "Lowagie";
        }
        if (di.name.equals("jackson-all-1.9.11.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jackson";
        }
        if (di.name.equals("jackson-annotations-2.8.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-annotations-2.9.0.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-core-2.1.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-core-2.8.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-core-2.9.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-core-asl-1.9.13.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jackson";
        }
        if (di.name.equals("jackson-core-asl-1.9.13.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jackson";
        }
        if (di.name.equals("jackson-databind-2.8.5.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-databind-2.9.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-dataformat-cbor-2.8.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-dataformat-smile-2.8.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-dataformat-yaml-2.8.6.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "FasterXML Jackson";
        }
        if (di.name.equals("jackson-mapper-asl-1.9.13.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jackson";
        }
        if (di.name.equals("jackson-mapper-asl-1.9.13.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jackson";
        }
        if (di.name.equals("jacob.jar")) {
            di.license = "LGPL, Version 2.0";
            di.fullName = "JAVA COM Bridge";
        }
        if (di.name.equals("java-xmlbuilder-0.3.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Jamesmurty Utilities";
        }
        if (di.name.equals("javassist-3.20.0-GA.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Javassist";
        }
        if (di.name.equals("javax.annotation-api-1.2.jar")) {
            di.license = "CDDL,GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.annotation-api-1.2.jar")) {
            di.license = "CDDL,GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.inject-2.2.0-b14.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("javax.inject-2.5.0-b32.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "GlassFish HK2";
        }
        if (di.name.equals("javax.servlet-api-3.0.1.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.servlet-api-3.1.0.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.ws.rs-api-2.0.1.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.ws.rs-api-2.0.jar")) {
            di.license = "CDDL,GNU GPL, Version 1.1, GNU GPL, Version 2.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("javax.wsdl_1.5.1.v200806030408.jar")) {
            di.license = "EPL, Version 1.0";
            di.fullName = "Javax";
        }
        if (di.name.equals("jaxb-api-2.2.7.jar")) {
            di.license = "CDDL, Version 1.1,GNU GPL, Version 1.1";
            di.fullName = "Javax";
        }
        if (di.name.equals("jaxb-api-2.2.9.jar")) {
            di.license = "CDDL, Version 1.1, GNU GPL, Version 1.1";
            di.fullName = "Javax";
        }
        if (di.name.equals("jaxen-1.1.1.jar")) {
            di.license = "The Apache Software License, Version 1.0";
            di.fullName = "Jaxen";
        }
        if (di.name.equals("jaxen-1.1.1.jar")) {
            di.license = "The Apache Software License, Version 1.0";
            di.fullName = "Jaxen";
        }
        if (di.name.equals("jaxrpc.jar")) {
            di.license = "Part of Java";
            di.fullName = "Javax";
        }
        if (di.name.equals("jaxrpc.jar")) {
            di.license = "Part of java";
            di.fullName = "Javax";
        }
        if (di.name.equals("jcip-annotations-1.0.jar")) {
            di.license = "Public";
            di.fullName = "JCIP";
        }
        if (di.name.equals("jcommon-1.0.15.jar")) {
            di.license = "LGPL, Version 1.0";
            di.fullName = "JFree";
        }
        if (di.name.equals("jdom.jar")) {
            di.license = "The Apache Software License, Version 1.0";
            di.fullName = "JDOM";
        }
        if (di.name.equals("jersey-client.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-client.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-common.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-common.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-container-grizzly2-http-2.2.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-container-servlet-core.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-container-servlet-core.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-container-servlet.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-container-servlet.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-core-1.17.1.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-guava-2.25.1.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-json-1.17.1-sources.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "Sun Jersey";
        }
        if (di.name.equals("jersey-json-1.17.1.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "Sun Jersey";
        }
        if (di.name.equals("jersey-media-jaxb.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-media-json-jackson-2.2.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-media-moxy-2.0.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-server-linking-1.9.1.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "Sun Jersey";
        }
        if (di.name.equals("jersey-server.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-server.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-test-framework-1.1.5.2.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "Sun Jersey";
        }
        if (di.name.equals("jersey-test-framework-core-2.2.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jersey-test-framework-provider-grizzly2-2.1.jar")) {
            di.license = "CDDL, Version 1.0, GNU GPL, Version 1.1";
            di.fullName = "GlassFish Jersey";
        }
        if (di.name.equals("jest-5.3.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Searchbox Jest";
        }
        if (di.name.equals("jest-common-5.3.2.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Searchbox Jest";
        }
        if (di.name.equals("jettison-1.3.4.jar")) {
            di.license = "The Apache Software License, Version 2.0";
            di.fullName = "Codehaus Jettison";
        }
        if (di.name.equals("jetty-6.1.24.jar")) {
            di.license = "The Apache Software License, Version 2.0, EPL, Version 1.0";
            di.fullName = "MortBay Jetty";
        }
        if (di.name.equals("jetty-all-9.2.21.v20170120.jar")) {
            di.license = "The Apache Software License, Version 2.0, EPL, Version 1.0";
            di.fullName = "Eclipse Jetty";
        }
        if (di.name.equals("jetty-util-6.1.24.jar")) {
            di.license = "The Apache Software License, Version 2.0, EPL, Version 1.0";
            di.fullName = "MortBay Jetty";
        }
        if (di.name.equals("jfreechart-1.0.12-experimental.jar")) {
            di.license = "LGPL, Version 1.0";
            di.fullName = "JFree";
        }
        if (di.name.equals("jfreechart-1.0.12-swt.jar")) {
            di.license = "LGPL, Version 1.0";
            di.fullName = "JFree";
        }
        if (di.name.equals("jfreechart-1.0.12.jar")) {
            di.license = "LGPL, Version 1.0";
            di.fullName = "JFree";
        }
        if (di.name.equals("jmf.jar")) {
            di.license = "Part of java";
            di.fullName = "Javax";
        }
        if (di.name.equals("jna-4.4.0.jar")) {
            di.license = "The Apache Software License, Version 2.0, LGPL, Version 2.1";
            di.fullName = "Java Dev JNA";
        }
        if (di.name.equals("jna-platform.jar")) {
            di.license = "The Apache Software License, Version 2.0, LGPL, Version 2.1";
            di.fullName = "Java Dev JNA";
        }
        if (di.name.equals("jna.jar")) {
            di.license = "The Apache Software License, Version 2.0, LGPL, Version 2.1";
            di.fullName = "Java Dev JNA";
        }

    }

}
