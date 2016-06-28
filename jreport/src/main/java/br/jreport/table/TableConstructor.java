package br.jreport.table;

import java.util.List;

import com.lowagie.text.pdf.PdfPCell;

import br.jreport.core.DataModelReport;

public class TableConstructor<T extends DataModelReport> extends Table {

	public TableConstructor(int numColumns) {
		super(numColumns);
	}

	public TableConstructor(String[] headers) {
		super(headers);
	}

	public TableConstructor(TableHeader[] headers) {
		super(headers);
	}

	public void addBody(List<PdfPCell> cells) {
		for (PdfPCell cell : cells) {
			getPdfPTable().addCell(cell);
		}
		getPdfPTable().completeRow();
	}
}
