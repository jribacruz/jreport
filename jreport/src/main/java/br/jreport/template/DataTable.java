package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TableDataStyleClass;
import br.jreport.table.DataTableBodyModel;
import br.jreport.table.TableHeader;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DataTable {

	private String[] headersString;

	private TableHeader[] headersObject;

	private Integer headersColspan;

	private List<PdfPCell> cells = new ArrayList<PdfPCell>();

	private List modelList;

	private DataTableBodyModel dtbody;

	public DataTable addHeader(Integer headersColspan) {
		this.headersColspan = headersColspan;
		return this;
	}

	public DataTable addHeader(String[] headers) {
		this.headersString = headers;
		return this;
	}

	public DataTable addHeader(TableHeader[] headers) {
		this.headersObject = headers;
		return this;
	}

	public DataTable addCell(String text) {
		TableDataStyleClass style = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(text, style);
		addCellToTable(paragraph, style);
		return this;
	}

	public DataTable addCell(String text, TableDataStyleClass style) {
		Paragraph paragraph = DocumentHelper.createText(text, style);
		addCellToTable(paragraph, style);
		return this;
	}

	public DataTable addCell(String text, String style) {
		TableDataStyleClass dataStyle = new TableDataStyleClass(style);
		Paragraph paragraph = DocumentHelper.createText(text, dataStyle);
		addCellToTable(paragraph, dataStyle);
		return this;
	}
	
	public DataTable addLine(float height, int colspan) {
		TableDataStyleClass v = new TableDataStyleClass();
		v.setHeight(height);
		v.setColspan(colspan);
		v.setBorderWidth(0);
		Paragraph paragraph = DocumentHelper.createText("", v);
		addCellToTable(paragraph, v);
		return this;
	}

	public DataTable addDataTableBody(List modelList, DataTableBodyModel dtbody) {
		this.modelList = modelList;
		this.dtbody = dtbody;
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

	protected List<PdfPCell> getCells() {
		return cells;
	}

	public List getModelList() {
		return modelList;
	}

	public void setModelList(List modelList) {
		this.modelList = modelList;
	}

	public DataTableBodyModel getDtbody() {
		return dtbody;
	}

	public void setDtbody(DataTableBodyModel dtbody) {
		this.dtbody = dtbody;
	}

	public Integer getHeadersColspan() {
		return headersColspan;
	}

	public void setHeadersColspan(Integer headersColspan) {
		this.headersColspan = headersColspan;
	}

}
