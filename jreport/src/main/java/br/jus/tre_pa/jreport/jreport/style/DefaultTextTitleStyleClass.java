package br.jus.tre_pa.jreport.jreport.style;

import br.jus.tre_pa.jreport.jreport.core.TextStyleClass;
import br.jus.tre_pa.jreport.jreport.enums.FontStyle;
import br.jus.tre_pa.jreport.jreport.enums.TextAlign;

public class DefaultTextTitleStyleClass extends TextStyleClass {

	public DefaultTextTitleStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(11);
		this.setTextAlign(TextAlign.CENTER);
	}

}
