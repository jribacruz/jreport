package br.jreport.tablenew;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TableDataStyleClass;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableHeader;

public class DataTableMethods {

	private String[] headersString;

	private TableHeader[] headersObject;

	private List<PdfPCell> cells = new ArrayList<PdfPCell>();

	public DataTableMethods addHeader(String[] headers) {
		this.headersString = headers;
		return this;
	}

	public DataTableMethods addHeader(TableHeader[] headers) {
		this.headersObject = headers;
		return this;
	}

	public DataTableMethods addCell(String text) {

		return this;
	}

	public DataTableMethods addCell(String text, TableDataStyleClass style) {
		Paragraph paragraph = DocumentHelper.createText(text, style);
		addCellToTable(paragraph, style);
		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataTableMethods addDataTableBody(List modelList, DataTableBody dtbody) {
		for (int i = 0; i < modelList.size(); i++) {
			dtbody.body(modelList.get(i));
		}
		cells.addAll(dtbody.getCells());
		return this;
	}

	private void addCellToTable(Paragraph p, TableDataStyleClass styleClass) {
		cells.add(DocumentHelper.createPdfPCell(p, styleClass));
	}

	public String[] getHeadersString() {
		return headersString;
	}

	public void setHeadersString(String[] headersString) {
		this.headersString = headersString;
	}

	public TableHeader[] getHeadersObject() {
		return headersObject;
	}

	public void setHeadersObject(TableHeader[] headersObject) {
		this.headersObject = headersObject;
	}

	public List<PdfPCell> getCells() {
		return cells;
	}

	public void setCells(List<PdfPCell> cells) {
		this.cells = cells;
	}

}
