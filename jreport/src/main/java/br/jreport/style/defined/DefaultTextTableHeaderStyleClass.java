package br.jreport.style.defined;

import br.jreport.enums.FontStyle;
import br.jreport.style.TextStyleClass;

public class DefaultTextTableHeaderStyleClass extends TextStyleClass {

	public DefaultTextTableHeaderStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(9);
	}

}
