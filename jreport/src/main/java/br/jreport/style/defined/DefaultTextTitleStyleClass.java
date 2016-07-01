package br.jreport.style.defined;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;
import br.jreport.style.TextStyleClass;

public class DefaultTextTitleStyleClass extends TextStyleClass {

	public DefaultTextTitleStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(11);
		this.setTextAlign(TextAlign.CENTER);
	}

}
