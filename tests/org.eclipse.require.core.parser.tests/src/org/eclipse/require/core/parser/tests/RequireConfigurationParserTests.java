package org.eclipse.require.core.parser.tests;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.require.core.configuration.Component;
import org.eclipse.require.core.configuration.Configuration;
import org.eclipse.require.core.configuration.PluginRequire;
import org.eclipse.require.core.parser.RequireConfigLexer;
import org.eclipse.require.core.parser.RequireConfigParser;
import org.junit.Test;

public class RequireConfigurationParserTests {
	@Test
	public void parseRequreConfigComponent() throws Exception {
		String content = "component \"core\" { }";

		ANTLRStringStream input = new ANTLRStringStream(content);
		RequireConfigLexer lexer = new RequireConfigLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RequireConfigParser parser = new RequireConfigParser(tokens);
		Configuration configuration = parser.configuration();
		TestCase.assertNotNull(configuration);
		EList<Component> components = configuration.getComponents();
		TestCase.assertEquals(1, components.size());
		Component coreComponent = components.get(0);
		TestCase.assertEquals("core", coreComponent.getName());
	}

	@Test
	public void parseRequreConfigComponent2() throws Exception {
		String content = "component core { }";

		ANTLRStringStream input = new ANTLRStringStream(content);
		RequireConfigLexer lexer = new RequireConfigLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RequireConfigParser parser = new RequireConfigParser(tokens);
		Configuration configuration = parser.configuration();
		TestCase.assertNotNull(configuration);
		EList<Component> components = configuration.getComponents();
		TestCase.assertEquals(1, components.size());
		Component coreComponent = components.get(0);
		TestCase.assertEquals("core", coreComponent.getName());
	}

	@Test
	public void parseRequreConfigComponent3() throws Exception {
		String content = "component core { }\n" + "component ui {}";

		ANTLRStringStream input = new ANTLRStringStream(content);
		RequireConfigLexer lexer = new RequireConfigLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RequireConfigParser parser = new RequireConfigParser(tokens);
		Configuration configuration = parser.configuration();
		TestCase.assertNotNull(configuration);
		EList<Component> components = configuration.getComponents();
		TestCase.assertEquals(2, components.size());
		Component coreComponent = components.get(0);
		TestCase.assertEquals("core", coreComponent.getName());

		Component uiComponent = components.get(1);
		TestCase.assertEquals("ui", uiComponent.getName());

	}

	@Test
	public void parseRequreConfigPlugins1() throws Exception {
		String content = //
		"component core {\n" + //
				"plugins \"org.eclipse.require*\"\n" + //
				"}"; //

		ANTLRStringStream input = new ANTLRStringStream(content);
		RequireConfigLexer lexer = new RequireConfigLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RequireConfigParser parser = new RequireConfigParser(tokens);
		Configuration configuration = parser.configuration();
		TestCase.assertNotNull(configuration);
		EList<Component> components = configuration.getComponents();
		TestCase.assertEquals(1, components.size());
		Component coreComponent = components.get(0);
		TestCase.assertEquals("core", coreComponent.getName());
		EList<PluginRequire> plugins = coreComponent.getPlugins();
		TestCase.assertEquals(1, plugins.size());

	}
}
