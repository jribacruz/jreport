package br.jus.tre_pa.jreport.jreport.style;

import com.lowagie.text.Element;

import br.jus.tre_pa.jreport.jreport.core.TextStyleClass;
import br.jus.tre_pa.jreport.jreport.enums.FontStyle;

public class TableDataStyleClass extends TextStyleClass {

	private Float fixedHeight;

	private int horizontalAlignment;

	private int verticalAlignment;

	public TableDataStyleClass() {
		super();
		this.setFontStyle(FontStyle.NORMAL);
		this.setFontSize(9);
		this.horizontalAlignment = Element.ALIGN_LEFT;
		this.verticalAlignment = Element.ALIGN_TOP;
	}

	public Float getFixedHeight() {
		return fixedHeight;
	}

	public void setFixedHeight(Float fixedHeight) {
		this.fixedHeight = fixedHeight;
	}

	public int getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public void setHorizontalAlignment(int horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

}
