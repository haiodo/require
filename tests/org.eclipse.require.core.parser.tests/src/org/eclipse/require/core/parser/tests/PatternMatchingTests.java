package org.eclipse.require.core.parser.tests;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.require.core.RequireCore;
import org.eclipse.require.core.RequireEngine;
import org.eclipse.require.core.RequireEngine.ComponentsProjects;
import org.eclipse.require.core.configuration.Configuration;
import org.junit.Test;

public class PatternMatchingTests {
	@Test
	public void testPatterbMatching0() throws Throwable {
		InputStream stream = PatternMatchingTests.class
				.getResourceAsStream("pattern.test0.require");
		Configuration configuration = RequireCore.loadConfiguration(stream);
		Set<IPath> projects = new HashSet<IPath>();
		fillPaths(projects);
		List<ComponentsProjects> componentProjects = new ArrayList<ComponentsProjects>();
		RequireEngine.processComponents(configuration.getComponents(),
				projects, componentProjects, "");
		TestCase.assertEquals(32, projects.size());
		StringBuilder bld = new StringBuilder();
		for (ComponentsProjects cp : componentProjects) {
			bld.append("\n").append(cp.componentName).append(" size: ")
					.append(Integer.toString(cp.projects.size())).append(", ");
			for (IPath prj : cp.projects) {
				bld.append(prj.toString()).append(", ");
			}
		}
		TestCase.assertEquals(
				"\n"
						+ "q7.core.contexts size: 6, core/contexts/com.xored.q7.ctx.debug, core/contexts/com.xored.q7.ctx.group, core/contexts/com.xored.q7.ctx.resources, core/contexts/com.xored.q7.ctx.preferences, core/contexts/com.xored.q7.ctx.workbench, core/contexts/com.xored.q7.ctx.script, \n"
						+ "q7.core size: 24, core/com.xored.tesla.core.context, core/com.xored.q7.ecl.core, core/com.xored.tesla.core, core/com.xored.q7.core, core/com.xored.tesla.recording.core.java, core/com.xored.tesla.ecl, core/com.xored.q7.core.builder, core/com.xored.q7.util.resources, core/com.xored.tesla-feature, core/com.xored.tesla.recording.core.ecl, core/com.xored.q7.core.scenario, core/com.xored.q7.ecl.parser, core/com.xored.tesla.recording.core, core/com.xored.q7.licensing, core/com.xored.q7.reporting.html, core/com.xored.tesla.ecl-feature, core/com.xored.q7.util, core/com.xored.peg, core/com.xored.q7.reporting, launching/com.xored.q7.launching.injection, launching/com.xored.q7.launching, launching/com.xored.q7.launching.ext, launching/com.xored.q7.launching.configuration, launching/com.xored.q7.reporting.util, \n"
						+ "q7.runtime.tesla.recording size: 19, runtime/tesla/com.xored.tesla.recording.canvas, runtime/tesla/com.xored.tesla.recording.aspects.gef, runtime/tesla/com.xored.tesla.recording.swt.iml, runtime/tesla/com.xored.tesla.recording.aspects.jface, runtime/tesla/com.xored.tesla.recording.workbench.texteditor, runtime/tesla/com.xored.tesla.recording.aspects.workbench.texteditor, runtime/tesla/com.xored.tesla.recording.draw2d, runtime/tesla/com.xored.tesla.recording.aspects.swt, runtime/tesla/com.xored.tesla.recording.swt, runtime/tesla/com.xored.tesla.recording.gef, runtime/tesla/com.xored.tesla.recording.jface.text, runtime/tesla/com.xored.tesla.recording.ui.dev, runtime/tesla/com.xored.tesla.recording.aspects.workbench, runtime/tesla/com.xored.tesla.recording.core.java.tests, runtime/tesla/com.xored.tesla.recording.aspects.gmf, runtime/tesla/com.xored.tesla.recording.aspects.forms, runtime/tesla/com.xored.tesla.recording.aspects.draw2d, runtime/tesla/com.xored.tesla.recording.gmf, runtime/tesla/com.xored.tesla.recording.aspects.jface.text, \n"
						+ "q7.runtime.tesla size: 30, runtime/tesla/com.xored.tesla.jface.text, runtime/tesla/com.xored.tesla.jface.databinding.observable.aspects, runtime/tesla/com.xored.tesla.testapp.feature, runtime/tesla/com.xored.tesla.swt, runtime/tesla/com.xored.tesla.canvas, runtime/tesla/com.xored.tesla.runtime-feature, runtime/tesla/com.xored.tesla.workbench.texteditor.aspects, runtime/tesla/com.xored.tesla.jface.databinding.aspects, runtime/tesla/com.xored.tesla.jobs.aspects, runtime/tesla/com.xored.tesla.gef, runtime/tesla/com.xored.tesla.jface.text.aspects, runtime/tesla/com.xored.tesla.junit, runtime/tesla/com.xored.tesla.swt.iml, runtime/tesla/com.xored.tesla.swt.fragment, runtime/tesla/com.xored.tesla.workbench.texteditor, runtime/tesla/com.xored.tesla.jface.fragment, runtime/tesla/com.xored.tesla.swt.aspects, runtime/tesla/com.xored.tesla.core.am, runtime/tesla/com.xored.tesla.gef.aspects, runtime/tesla/com.xored.tesla.gmf, runtime/tesla/com.xored.tesla.gef.tests, runtime/tesla/com.xored.tesla.gmf.aspects, runtime/tesla/com.xored.tesla.jface.databinding, runtime/tesla/com.xored.tesla.ui.tests, runtime/tesla/com.xored.tesla.testapp, runtime/tesla/com.xored.tesla.workbench.aspects, runtime/tesla/com.xored.tesla.ui.ide, runtime/tesla/com.xored.tesla.jface.aspects, runtime/tesla/com.xored.tesla.jface.text.reconciler.aspects, runtime/tesla/com.xored.tesla.gmf.tests, \n"
						+ "q7.runtime.iml size: 15, runtime/iml/com.xored.iml.ocr.test, runtime/iml/com.xored.iml.core, runtime/iml/com.xored.iml.ocr.win64, runtime/iml/com.xored.iml.ocr.linux.x86_64, runtime/iml/com.xored.iml.recognition, runtime/iml/com.xored.iml.orc.sources, runtime/iml/com.xored.iml.fft, runtime/iml/com.xored.iml.image, runtime/iml/com.xored.iml.ocr, runtime/iml/com.xored.iml-feature, runtime/iml/com.xored.iml.ocr.linux.x86, runtime/iml/com.xored.iml.ocr.win32, runtime/iml/com.xored.iml.ocr.macosx, runtime/iml/com.xored.iml.imagesearch, runtime/iml/com.xored.iml.array, \n"
						+ "q7.runtime.updates size: 6, runtime/updates/com.xored.q7.updates.runtime, runtime/updates/com.xored.q7.updates.helios, runtime/updates/com.xored.q7.updates.ganymede, runtime/updates/com.xored.q7.updates.indigo, runtime/updates/com.xored.q7.updates.galileo, runtime/updates/com.xored.q7.updates-feature, \n"
						+ "q7.runtime size: 14, runtime/contexts/com.xored.q7.ctx.preferences.aspects, runtime/ecl/com.xored.tesla.ecl.impl, runtime/ecl/com.xored.tesla.ecl.runtime-feature, runtime/contexts/com.xored.q7.ctx.debug.impl, runtime/contexts/com.xored.q7.ctx.resources.impl, runtime/com.xored.q7.runtime.ui, runtime/contexts/com.xored.q7.ctx.preferences.impl, runtime/com.xored.q7.runtime-updatesite, runtime/contexts/com.xored.q7.ctx.workbench.impl, runtime/com.xored.q7.runtime-feature, runtime/contexts/com.xored.q7.ctx.script.impl, runtime/contexts/com.xored.q7.ctx.workbench.aspect, runtime/ecl/com.xored.tesla.ecl.update-site, runtime/contexts/com.xored.q7.ctx.group.impl, \n"
						+ "q7.x5 size: 19, x5/com.xored.q7.x5.agent, x5/com.xored.q7.x5.runtime, x5/com.xored.q7.x5.server-feature, x5/com.xored.q7.x5.server, x5/com.xored.q7.x5.startup, x5/com.xored.q7.x5.agent-feature, x5/com.xored.q7.x5-feature, x5/com.xored.q7.x5.report, x5/com.xored.q7.x5.agent-site, watson/com.xored.watson.ui-feature, watson/com.xored.watson.ui, watson/com.xored.watson-feature, watson/com.xored.watson.aspects.jobs, watson/com.xored.watson.core, watson/com.xored.watson.jface, watson/com.xored.watson.jobs, watson/com.xored.watson.aspects.swt, x5/com.xored.q7.sherlock.sources, x5/com.xored.q7.sherlock.model, \n"
						+ "q7.rcp.contexts size: 6, rcp/contexts/com.xored.q7.ctx.script.ui, rcp/contexts/com.xored.q7.ctx.workbench.ui, rcp/contexts/com.xored.q7.ctx.group.ui, rcp/contexts/com.xored.q7.ctx.resources.ui, rcp/contexts/com.xored.q7.ctx.debug.ui, rcp/contexts/com.xored.q7.ctx.preferences.ui, \n"
						+ "q7.rcp size: 15, rcp/com.xored.q7.platform, rcp/com.xored.q7.launching.ext.ui, rcp/com.xored.q7.search, rcp/com.xored.q7, rcp/products/platform, rcp/products/repository, rcp/com.xored.q7.licensing.ui, rcp/com.xored.q7.help, rcp/com.xored.q7.ui, rcp/com.xored.q7.ui.report, rcp/com.xored.q7.dev.ui, rcp/com.xored.q7.junit, rcp/com.xored.q7.ui.activities, rcp/com.xored.q7.converter, rcp/com.xored.q7.platform-feature, \n"
						+ "q7.reporting size: 5, reporting/com.xored.q7.reporting.html.mustache, reporting/com.xored.q7.reporting-feature, mustache/com.xored.mustache.emf, mustache/com.xored.mustache, mustache/com.xored.mustache-feature, \n"
						+ "q7 size: 0, ", bld.toString());
		System.out.println("$");
	}

	private void fillPaths(Set<IPath> projects) {
		String paths[] = {
				"runtime/tesla/com.xored.tesla.jface.text",
				"runtime/contexts/com.xored.q7.ctx.preferences.aspects",
				"runtime/tesla/com.xored.tesla.jface.databinding.observable.aspects",
				"runtime/tesla/com.xored.tesla.testapp.feature",
				"modules/ecl-ide/plugins/com.xored.q7.launching.remote.ui",
				"reporting/com.xored.q7.reporting.html.mustache",
				"rcp/com.xored.q7.platform",
				"modules/nebula/plugins/com.xored.tesla.nebula",
				"runtime/tesla/com.xored.tesla.swt",
				"rcp/com.xored.q7.launching.ext.ui",
				"runtime/ecl/com.xored.tesla.ecl.impl",
				"runtime/iml/com.xored.iml.ocr.test",
				"runtime/tesla/com.xored.tesla.canvas",
				"core/com.xored.tesla.core.context",
				"runtime/tesla/com.xored.tesla.recording.canvas",
				"core/com.xored.q7.ecl.core",
				"modules/wst/features/com.xored.q7.module.wst",
				"runtime/tesla/com.xored.tesla.runtime-feature",
				"rcp/com.xored.q7.search",
				"runtime/tesla/com.xored.tesla.recording.aspects.gef",
				"modules/wst/plugins/com.xored.q7.module.wst.ctx.ui",
				"modules/wst/plugins/com.xored.q7.module.wst.updates",
				"runtime/tesla/com.xored.tesla.recording.swt.iml",
				"core/contexts/com.xored.q7.ctx.debug",
				"runtime/tesla/com.xored.tesla.workbench.texteditor.aspects",
				"runtime/iml/com.xored.iml.core",
				"launching/com.xored.q7.launching.injection",
				"core/com.xored.tesla.core",
				"x5/com.xored.q7.x5.runtime",
				"core/com.xored.q7.core",
				"watson/com.xored.watson-feature",
				"runtime/tesla/com.xored.tesla.recording.aspects.jface",
				"runtime/tesla/com.xored.tesla.jface.databinding.aspects",
				"q7tests/contexts",
				"modules/ecl-ide/features/com.xored.q7.module.ide-feature",
				"runtime/tesla/com.xored.tesla.jobs.aspects",
				"runtime/tesla/com.xored.tesla.recording.workbench.texteditor",
				"core/com.xored.tesla.recording.core.java",
				"dev/com.xored.q7.target-definition",
				"runtime/contexts/com.xored.q7.ctx.resources.impl",
				"core/com.xored.tesla.ecl",
				"runtime/updates/com.xored.q7.updates.runtime",
				"watson/com.xored.watson.aspects.jobs",
				"runtime/iml/com.xored.iml.ocr.win64",
				"mustache/com.xored.mustache.emf",
				"rcp/com.xored.q7.help",
				"runtime/tesla/com.xored.tesla.gef",
				"core/com.xored.q7.core.builder",
				"tests/com.xored.q7.core.tests",
				"modules/nebula/plugins/com.xored.tesla.recording.nebula",
				"modules/wst/plugins/com.xored.tesla.wst.sse.ui",
				"runtime/updates/com.xored.q7.updates.helios",
				"x5/com.xored.q7.sherlock.model",
				"mustache/com.xored.mustache",
				"runtime/tesla/com.xored.tesla.jface.text.aspects",
				"rcp/com.xored.q7.ui",
				"runtime/iml/com.xored.iml.ocr.linux.x86_64",
				"core/com.xored.q7.util.resources",
				"runtime/tesla/com.xored.tesla.junit",
				"rcp/com.xored.q7.dev.ui",
				"rcp/contexts/com.xored.q7.ctx.script.ui",
				"q7tests/platform_tests",
				"runtime/tesla/com.xored.tesla.recording.aspects.workbench.texteditor",
				"runtime/tesla/com.xored.tesla.swt.iml",
				"runtime/tesla/com.xored.tesla.recording.draw2d",
				"runtime/iml/com.xored.iml.recognition",
				"watson/com.xored.watson.jface",
				"runtime/tesla/com.xored.tesla.swt.fragment",
				"modules/imagerec/features/com.xored.q7.module.imagerec",
				"rcp/com.xored.q7.junit",
				"runtime/iml/com.xored.iml.orc.sources",
				"runtime/tesla/com.xored.tesla.workbench.texteditor",
				"runtime/tesla/com.xored.tesla.jface.fragment",
				"runtime/iml/com.xored.iml.fft",
				"core/com.xored.tesla-feature",
				"runtime/tesla/com.xored.tesla.swt.aspects",
				"runtime/tesla/com.xored.tesla.recording.aspects.swt",
				"x5/com.xored.q7.x5.report",
				"rcp/contexts/com.xored.q7.ctx.group.ui",
				"runtime/com.xored.q7.runtime-feature",
				"runtime/contexts/com.xored.q7.ctx.script.impl",
				"runtime/tesla/com.xored.tesla.recording.swt",
				"launching/com.xored.q7.launching",
				"core/contexts/com.xored.q7.ctx.group",
				"runtime/contexts/com.xored.q7.ctx.workbench.aspect",
				"core/contexts/com.xored.q7.ctx.resources",
				"runtime/iml/com.xored.iml.image",
				"runtime/tesla/com.xored.tesla.core.am",
				"watson/com.xored.watson.aspects.swt",
				"rcp/contexts/com.xored.q7.ctx.debug.ui",
				"runtime/ecl/com.xored.tesla.ecl.update-site",
				"runtime/tesla/com.xored.tesla.recording.gef",
				"runtime/contexts/com.xored.q7.ctx.group.impl",
				"runtime/updates/com.xored.q7.updates.ganymede",
				"watson/com.xored.watson.ui-feature",
				"runtime/tesla/com.xored.tesla.recording.jface.text",
				"x5/com.xored.q7.sherlock.sources",
				"modules/ecl-ide/plugins/com.xored.q7.module.ide",
				"x5/com.xored.q7.x5.agent",
				"core/com.xored.tesla.recording.core.ecl",
				"core/com.xored.q7.core.scenario",
				"runtime/iml/com.xored.iml.ocr",
				"watson/com.xored.watson.ui",
				"runtime/tesla/com.xored.tesla.gef.aspects",
				"runtime/iml/com.xored.iml-feature",
				"modules/nebula/plugins/com.xored.tesla.nebula.ecl",
				"runner/com.xored.q7.runner",
				"modules/wst/plugins/com.xored.q7.module.wst.ctx",
				"runtime/tesla/com.xored.tesla.gmf",
				"runtime/iml/com.xored.iml.ocr.linux.x86",
				"core/com.xored.q7.ecl.parser",
				"q7tests",
				"runtime/tesla/com.xored.tesla.gef.tests",
				"runtime/tesla/com.xored.tesla.recording.ui.dev",
				"modules/wst/plugins/com.xored.q7.module.wst.ctx.runtime",
				"runtime/ecl/com.xored.tesla.ecl.runtime-feature",
				"testing/com.xored.q7.testing.ecl",
				"modules/nebula/plugins/com.xored.q7.module.nebula.updates",
				"rcp/com.xored.q7",
				"mustache/com.xored.mustache-feature",
				"runtime/tesla/com.xored.tesla.recording.aspects.workbench",
				"core/com.xored.tesla.recording.core",
				"modules/nebula/plugins/com.xored.tesla.nebula.ecl.impl",
				"core/contexts/com.xored.q7.ctx.preferences",
				"runtime/tesla/com.xored.tesla.gmf.aspects",
				"core/com.xored.q7.licensing",
				"runtime/iml/com.xored.iml.ocr.win32",
				"runtime/tesla/com.xored.tesla.recording.core.java.tests",
				"runtime/tesla/com.xored.tesla.recording.aspects.gmf",
				"rcp/products/platform",
				"runtime/iml/com.xored.iml.ocr.macosx",
				"testing/com.xored.q7.testing-feature",
				"runtime/iml/com.xored.iml.imagesearch",
				"launching/com.xored.q7.launching.ext",
				"runtime/contexts/com.xored.q7.ctx.debug.impl",
				"modules/ecl-ide/plugins/com.xored.q7.launching.remote",
				"rcp/products/repository",
				"runtime/tesla/com.xored.tesla.recording.aspects.forms",
				"x5/com.xored.q7.x5.server-feature",
				"runtime/tesla/com.xored.tesla.jface.databinding",
				"runtime/updates/com.xored.q7.updates.indigo",
				"x5/com.xored.q7.x5.server",
				"x5/com.xored.q7.x5.startup",
				"runtime/updates/com.xored.q7.updates.galileo",
				"rcp/com.xored.q7.licensing.ui",
				"core/contexts/com.xored.q7.ctx.workbench",
				"runtime/tesla/com.xored.tesla.ui.tests",
				"modules/nebula/features/com.xored.q7.module.nebula",
				"runtime/tesla/com.xored.tesla.testapp",
				"watson/com.xored.watson.core",
				"runtime/tesla/com.xored.tesla.workbench.aspects",
				"runtime/tesla/com.xored.tesla.recording.aspects.draw2d",
				"core/com.xored.q7.reporting.html",
				"modules/nebula/features/com.xored.q7.module.nebula.runtime",
				"core/com.xored.tesla.ecl-feature",
				"runtime/tesla/com.xored.tesla.recording.gmf",
				"core/com.xored.q7.util",
				"runtime/tesla/com.xored.tesla.ui.ide",
				"runtime/tesla/com.xored.tesla.jface.aspects",
				"runtime/com.xored.q7.runtime.ui",
				"runtime/iml/com.xored.iml.array",
				"q7tests/ECL_IDE_module",
				"rcp/com.xored.q7.ui.report",
				"runtime/updates/com.xored.q7.updates-feature",
				"runtime/tesla/com.xored.tesla.jface.text.reconciler.aspects",
				"modules/wst/features/com.xored.q7.module.wst.runtime",
				"x5/com.xored.q7.x5.agent-feature",
				"launching/com.xored.q7.launching.configuration",
				"x5/com.xored.q7.x5-feature",
				"runtime/contexts/com.xored.q7.ctx.preferences.impl",
				"tests/com.xored.q7.core.tests/workspace/ModelMembers",
				"watson/com.xored.watson.jobs",
				"testing/com.xored.q7.testing-updatesite",
				"core/contexts/com.xored.q7.ctx.script",
				"rcp/contexts/com.xored.q7.ctx.workbench.ui",
				"rcp/com.xored.q7.ui.activities",
				"core/com.xored.peg",
				"runtime/tesla/com.xored.tesla.recording.aspects.jface.text",
				"reporting/com.xored.q7.reporting-feature",
				"runtime/com.xored.q7.runtime-updatesite",
				"runtime/contexts/com.xored.q7.ctx.workbench.impl",
				"modules/imagerec/plugins/com.xored.q7.module.imagerec.updates",
				"core/com.xored.q7.reporting",
				"rcp/contexts/com.xored.q7.ctx.resources.ui",
				"x5/com.xored.q7.x5.agent-site",
				"runner/com.xored.q7.runner-feature",
				"launching/com.xored.q7.reporting.util",
				"rcp/com.xored.q7.converter",
				"rcp/contexts/com.xored.q7.ctx.preferences.ui",
				"runtime/tesla/com.xored.tesla.gmf.tests",
				"rcp/com.xored.q7.platform-feature" };
		for (String p : paths) {
			projects.add(new Path(p));
		}
	}
}
