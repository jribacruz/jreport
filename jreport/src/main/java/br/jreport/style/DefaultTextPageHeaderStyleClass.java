package br.jreport.style;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;

public class DefaultTextPageHeaderStyleClass extends TextStyleClass {

	public DefaultTextPageHeaderStyleClass() {
		super();
		this.setFontStyle(FontStyle.NORMAL);
		this.setFontSize(10);
		this.setTextAlign(TextAlign.CENTER);
	}

}
