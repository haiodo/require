package org.eclipse.require.ui.editors.config;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class RequireConfigConfiguration extends SourceViewerConfiguration {
	private RequireConfigDoubleClickStrategy doubleClickStrategy;
	private RequireConfigCodeScanner scanner;
	private ColorManager colorManager;

	public RequireConfigConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				RequireConfigPartitionScanner.REQUIRE_CONFIG_COMMENT };
	}

	public ITextDoubleClickStrategy getDoubleClickStrategy(
			ISourceViewer sourceViewer, String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new RequireConfigDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected RequireConfigCodeScanner getRequireConfigScanner() {
		if (scanner == null) {
			scanner = new RequireConfigCodeScanner(colorManager);
			scanner.setDefaultReturnToken(new Token(
					new TextAttribute(colorManager
							.getColor(IRequireConfigColorConstants.DEFAULT))));
		}
		return scanner;
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getRequireConfigScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(
				new TextAttribute(colorManager
						.getColor(IRequireConfigColorConstants.COMMENT)));
		reconciler.setDamager(ndr,
				RequireConfigPartitionScanner.REQUIRE_CONFIG_COMMENT);
		reconciler.setRepairer(ndr,
				RequireConfigPartitionScanner.REQUIRE_CONFIG_COMMENT);

		return reconciler;
	}

}