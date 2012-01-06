package org.eclipse.require.core;

import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.require.core.configuration.Configuration;
import org.eclipse.require.core.parser.RequireConfigLexer;
import org.eclipse.require.core.parser.RequireConfigParser;

public class RequireCore {
	public static Configuration parseConfiguration(String content) {
		try {
			ANTLRStringStream input = new ANTLRStringStream(content);
			RequireConfigLexer lexer = new RequireConfigLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			RequireConfigParser parser = new RequireConfigParser(tokens);
			return parser.configuration();
		} catch (RecognitionException e) {
			RequireCorePlugin.log(e);
		}
		return null;
	}

	public static Configuration loadConfiguration(IFile file) {
		InputStream contents = null;
		try {
			contents = file.getContents();
			return loadConfiguration(contents);
		} catch (Throwable e) {
			RequireCorePlugin.log(e);
		}
		return null;
	}

	public static Configuration loadConfiguration(InputStream contents) {
		try {
			ANTLRInputStream input = new ANTLRInputStream(contents);
			RequireConfigLexer lexer = new RequireConfigLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			RequireConfigParser parser = new RequireConfigParser(tokens);
			return parser.configuration();
		} catch (Throwable e) {
			RequireCorePlugin.log(e);
			return null;
		} finally {
			if (contents != null) {
				try {
					contents.close();
				} catch (Throwable e) {
					// ignore
				}
			}
		}
	}
}
