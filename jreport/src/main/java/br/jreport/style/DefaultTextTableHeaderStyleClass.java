package br.jreport.style;

import br.jreport.core.TextStyleClass;
import br.jreport.enums.FontStyle;

public class DefaultTextTableHeaderStyleClass extends TextStyleClass {

	public DefaultTextTableHeaderStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(9);
	}

}
