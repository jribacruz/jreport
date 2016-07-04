package br.jreport.style.defined;

import br.jreport.enums.FontStyle;
import br.jreport.style.TableDataStyleClass;

public class DetaultTableHeaderStyleClass extends TableDataStyleClass {
	/** Tamanho do espaço entre uma célula e outra, da table **/

	public DetaultTableHeaderStyleClass() {
		super();
		setWidth(1f);
		this.setFontStyle(FontStyle.BOLD);
	}

	public DetaultTableHeaderStyleClass(String style) {
		super(style);
	}

}
