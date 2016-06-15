package br.jreport.style;

import br.jreport.enums.ColorJReport;
import br.jreport.enums.FontStyle;

public class TableHeaderStyleClass extends TableDataStyleClass {

	/** Tamanho do espaço entre uma célula e outra, da table **/

	private float tableHeaderSpacer = 0;

	/** Width header **/
	private float widthHeaderTable = 1f;

	public TableHeaderStyleClass() {
		super();
		this.widthHeaderTable = 1f;
		this.tableHeaderSpacer = 0;
		this.setFontStyle(FontStyle.BOLD);
	}

	public TableHeaderStyleClass(float width, int colspan, ColorJReport backgroundTableColor, ColorJReport borderColor,
			float tableHeaderSpacer) {
		super();
		this.widthHeaderTable = width;
		this.tableHeaderSpacer = tableHeaderSpacer;
		setColspan(colspan);
		setBackgroundTableColor(backgroundTableColor);
		setBorderColor(borderColor);
	}

	public float getWidthHeaderTable() {
		return widthHeaderTable;
	}

	public void setWidthHeaderTable(float width) {
		this.widthHeaderTable = width;
	}

	public float getTableHeaderSpacer() {
		return tableHeaderSpacer;
	}

	public void setTableHeaderSpacer(float tableHeaderSpacer) {
		this.tableHeaderSpacer = tableHeaderSpacer;
	}

}
