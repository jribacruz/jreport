package br.jus.tre_pa.jreport.jreport.table;

import java.math.BigDecimal;
import java.util.Date;

import br.jus.tre_pa.jreport.jreport.helper.DocumentHelper;
import br.jus.tre_pa.jreport.jreport.style.TableDataStyleClass;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

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

	private void addCellToTable(Paragraph p, TableDataStyleClass styleClass) {
		PdfPCell cell = new PdfPCell(p);
		if (styleClass.getFixedHeight() != null) {
			cell.setFixedHeight(styleClass.getFixedHeight().floatValue());
		}
		cell.setHorizontalAlignment(styleClass.getHorizontalAlignment());
		cell.setVerticalAlignment(styleClass.getVerticalAlignment());
		pdfPTable.addCell(cell);
	}

	public PdfPTable getPdfPTable() {
		return pdfPTable;
	}

	public void setPdfPTable(PdfPTable pdfPTable) {
		this.pdfPTable = pdfPTable;
	}

}
