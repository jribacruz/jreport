package br.jreport.table;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TableDataStyleClass;

public class DataTableBody {
	
	protected PdfPTable pdfPTable;

	private List<PdfPCell> cells = new ArrayList<PdfPCell>();

	/*
	 * STRING
	 */
	protected void addCell(String text) {
		TableDataStyleClass styleClass = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(text, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addCell(String text, TableDataStyleClass styleClass) {
		Paragraph paragraph = DocumentHelper.createText(text, styleClass);
		addCellToTable(paragraph, styleClass);
	}
	
	protected void addCell(String text, String style) {
		TableDataStyleClass styleClass = new TableDataStyleClass(style);
		Paragraph paragraph = DocumentHelper.createText(text, styleClass);
		addCellToTable(paragraph, styleClass);
	}

	protected void addLine(float height, int colspan) {
		TableDataStyleClass v = new TableDataStyleClass();
		v.setHeight(height);
		v.setColspan(colspan);
		Paragraph paragraph = DocumentHelper.createText("", v);
		addCellToTable(paragraph, v);
	}

	private void addCellToTable(Paragraph p, TableDataStyleClass styleClass) {
		cells.add(DocumentHelper.createPdfPCell(p, styleClass));
	}

	public List<PdfPCell> getCells() {
		return cells;
	}

	public void setCells(List<PdfPCell> cells) {
		this.cells = cells;
	}

}
