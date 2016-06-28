package br.jreport.style;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;

public class DefaultTextTitleStyleClass extends TextStyleClass {

	public DefaultTextTitleStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(11);
		this.setTextAlign(TextAlign.CENTER);
	}

}
