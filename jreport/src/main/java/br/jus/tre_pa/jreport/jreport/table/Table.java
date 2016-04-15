package br.jus.tre_pa.jreport.jreport.table;

import br.jus.tre_pa.jreport.jreport.helper.DocumentHelper;
import br.jus.tre_pa.jreport.jreport.style.DefaultTextTableHeaderStyleClass;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public class Table {

	private PdfPTable pdfPTable;

	private String[] headers;

	private TableHeader[] theaders;

	/**
	 * Cria uma tabela sem header
	 * 
	 * @param numColumns
	 */
	public Table(int numColumns) {
		super();
		this.pdfPTable = new PdfPTable(numColumns);
		this.pdfPTable.setSpacingBefore(4);
		pdfPTable.setWidthPercentage(100);
	}

	/**
	 * Cria uma tabela com headers
	 * 
	 * @param headers
	 */
	public Table(String... headers) {
		super();
		this.pdfPTable = new PdfPTable(headers.length);
		this.pdfPTable.setSpacingBefore(4);
		pdfPTable.setWidthPercentage(100);
		this.headers = headers;
		addHeaders();
	}
	
	public Table(TableHeader... headers) {
		super();
		this.pdfPTable = new PdfPTable(length(headers));
		this.pdfPTable.setSpacingBefore(4);
		pdfPTable.setWidthPercentage(100);
		this.theaders = headers;
		addTheaders();
	}
	
	public int length(TableHeader... headers){
		int length = 0;
		for (int i = 0; i < headers.length; i++) {
			length = length+ headers[i].getColspan();
		}
		return length;
	}

	
	private void addHeaders() {
		for (String header : headers) {
			Paragraph paragraph = DocumentHelper.createText(header, new DefaultTextTableHeaderStyleClass());
			pdfPTable.addCell(new PdfPCell(paragraph));
		}
	}
	
	private void addTheaders() {
		float[] columnWidths = new float[theaders.length];
		for (int i = 0; i < theaders.length; i++) {
			TableHeader header = theaders[i];
			Paragraph paragraph = DocumentHelper.createText(header.getNome(), new DefaultTextTableHeaderStyleClass());
			PdfPCell pdfpcell = new PdfPCell(paragraph);
			pdfpcell.setColspan(header.getColspan());
			pdfPTable.addCell(pdfpcell);
			columnWidths[i] = header.getWidth();
		}
		try {
			pdfPTable.setWidths(columnWidths);
		} catch(DocumentException e){}
	}

	public void addBody(TableBody tableBody) {
		tableBody.setPdfPTable(getPdfPTable());
		tableBody.body();
	}

	public PdfPTable getPdfPTable() {
		return pdfPTable;
	}

	public String[] getHeaders() {
		return headers;
	}

}
