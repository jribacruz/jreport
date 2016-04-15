package br.jus.tre_pa.jreport.jreport.style;

import br.jus.tre_pa.jreport.jreport.core.TextStyleClass;
import br.jus.tre_pa.jreport.jreport.enums.FontStyle;

public class DefaultTextTableHeaderStyleClass extends TextStyleClass {

	public DefaultTextTableHeaderStyleClass() {
		super();
		this.setFontStyle(FontStyle.BOLD);
		this.setFontSize(9);
	}

}
