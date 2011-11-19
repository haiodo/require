package org.eclipse.require.ui.editors.config;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class RequireConfigCodeScanner extends RuleBasedScanner {

	public RequireConfigCodeScanner(ColorManager manager) {
		IToken keyword = new Token(new TextAttribute(
				manager.getColor(IRequireConfigColorConstants.KEYWORD)));
		IToken str = new Token(new TextAttribute(
				manager.getColor(IRequireConfigColorConstants.STRING)));
		IToken other = new Token(new TextAttribute(
				manager.getColor(IRequireConfigColorConstants.DEFAULT)));

		WordRule keywordsRule = new WordRule(new KeywordWordDetector(), other);
		keywordsRule.addWord("component", keyword);
		keywordsRule.addWord("plugins", keyword);

		List<IRule> rules = new ArrayList<IRule>();
		// Add rule for processing instructions
		rules.add(new SingleLineRule("\"", "\"", str));
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new RequireConfigWhitespaceDetector()));
		rules.add(keywordsRule);

		setDefaultReturnToken(other);
		setRules(rules.toArray(new IRule[rules.size()]));
	}
}
