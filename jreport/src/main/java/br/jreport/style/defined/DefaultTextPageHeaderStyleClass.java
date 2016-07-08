package br.jreport.style.defined;

import java.awt.Color;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;
import br.jreport.style.TextStyleClass;

public class DefaultTextPageHeaderStyleClass extends TextStyleClass {

	public DefaultTextPageHeaderStyleClass() {
		super();
		this.setFontStyle(FontStyle.NORMAL);
		this.setFontSize(9);
		this.setTextAlign(TextAlign.RIGHT);
		this.setFontColor(Color.GRAY);
	}

}
