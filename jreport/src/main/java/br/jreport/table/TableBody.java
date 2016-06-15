package br.jreport.table;

import java.math.BigDecimal;
import java.util.Date;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TableDataStyleClass;

public abstract class TableBody {

	protected PdfPTable pdfPTable;

	protected abstract void body();

	/*
	 * CELL
	 */
	protected void addCell(PdfPCell cell) {
		pdfPTable.addCell(cell);
	}

	/*
	 * STRING
	 */
	protected void addCell(String text) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(text, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	/*
	 * BIGDECIMAL
	 */
	protected void addCell(BigDecimal number) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(number, styleClass);
		addCellToTable(paragraph, styleClass);

	}

	/*
	 * INTEGER
	 */
	protected void addCell(Integer number) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(number, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	/*
	 * LONG
	 */
	protected void addCell(Long number) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(number, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	/*
	 * Boolean
	 */
	protected void addCell(Boolean bool) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(bool, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addCell(Boolean bool, String trueExp, String falseExp) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(bool, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	/*
	 * DATE
	 */
	protected void addCell(Date date) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(date, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addCell(Date date, String pattern) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(date, pattern, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addCell(String text, TableDataStyleClass styleClass) {
		Paragraph paragraph = DocumentHelper.createText(text, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addColspan(String text, int colspan) {
		Paragraph p = DocumentHelper.createText(text, new TableDataStyleClass());
		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(colspan);
		pdfPTable.addCell(cell);
	}

	protected void addColspan(int colspan) {
		Paragraph p = new Paragraph(" ");
		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(colspan);
		pdfPTable.addCell(cell);
	}

	protected void addRowspan(String text, int rowspan) {
		Paragraph p = DocumentHelper.createText(text, new TableDataStyleClass());
		PdfPCell cell = new PdfPCell(p);
		cell.setRowspan(rowspan);
		pdfPTable.addCell(cell);
	}

	protected void addRowspan(int rowspan) {
		Paragraph p = new Paragraph(" ");
		PdfPCell cell = new PdfPCell(p);
		cell.setRowspan(rowspan);
		pdfPTable.addCell(cell);
	}

	protected void addRowSeparator(float height, int colspan) {
		TableDataStyleClass v = new TableDataStyleClass();
		v.setFixedHeight(height);
		v.setColspan(colspan);
		addCell("", v);
	}

	private void addCellToTable(Paragraph p, TableDataStyleClass styleClass) {
		DocumentHelper.createPdfPCell(p, styleClass, pdfPTable);
	}

	public PdfPTable getPdfPTable() {
		return pdfPTable;
	}

	public void setPdfPTable(PdfPTable pdfPTable) {
		this.pdfPTable = pdfPTable;
	}

}
