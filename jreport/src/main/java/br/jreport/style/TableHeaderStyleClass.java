package br.jreport.style;

import java.util.Map;

import com.google.common.base.Splitter;

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
		setBackgroundCellColor(backgroundTableColor);
		setBorderColor(borderColor);
	}

	public TableHeaderStyleClass(String style) {
		super(style);
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setTableHeaderSpacer(map.get("table-header-spacer"));
				setWidthHeaderTable(map.get("width-header-table"));
			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setWidthHeaderTable(String widthHeaderTable) {
		if (widthHeaderTable != null) {
			try {
				this.widthHeaderTable = Float.valueOf(widthHeaderTable.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para width-header-table, valor: " + widthHeaderTable);
			}
		}
	}

	public void setTableHeaderSpacer(String tableHeaderSpacer) {
		if (tableHeaderSpacer != null) {
			try {
				this.tableHeaderSpacer = Float.valueOf(tableHeaderSpacer.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para table-header-spacer, valor: " + tableHeaderSpacer);
			}
		}
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
