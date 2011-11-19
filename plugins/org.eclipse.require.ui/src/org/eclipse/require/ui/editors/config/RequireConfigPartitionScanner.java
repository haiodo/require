package org.eclipse.require.ui.editors.config;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class RequireConfigPartitionScanner extends RuleBasedPartitionScanner {
	public final static String REQUIRE_CONFIG_COMMENT = "__require_comment";

	public RequireConfigPartitionScanner() {

		IToken xmlComment = new Token(REQUIRE_CONFIG_COMMENT);

		IPredicateRule[] rules = new IPredicateRule[1];

		rules[0] = new EndOfLineRule("//", xmlComment);

		setPredicateRules(rules);
	}
}
