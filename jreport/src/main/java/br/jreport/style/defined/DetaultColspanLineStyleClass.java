package br.jreport.style.defined;

import br.jreport.style.TableDataStyleClass;

public class DetaultColspanLineStyleClass extends TableDataStyleClass {
	/** Tamanho do espaço entre uma célula e outra, da table **/

	public DetaultColspanLineStyleClass() {
		super();
		setBorderBottomWidth(0);
		setBorderLeftWidth(0);
		setBorderRightWidth(0);
		setBorderTopWidth(0);
	}

	public DetaultColspanLineStyleClass(String style) {
		super(style);
		setBorderBottomWidth(0);
		setBorderLeftWidth(0);
		setBorderRightWidth(0);
		setBorderTopWidth(0);
	}

}
