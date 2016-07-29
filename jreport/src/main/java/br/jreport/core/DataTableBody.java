package br.jreport.core;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TableDataStyleClass;
import br.jreport.table.DataTableBodyModel;
import br.jreport.table.TableHeader;
import br.jreport.template.DataTable;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DataTableBody {

	private List<PdfPCell> cells = new ArrayList<PdfPCell>();

	// TODO ajustar esses header para ser adicionado assim como células são
	// adicionadas numa lista, possibilitando adicionar um de cada vez;
	private String[] headersString;

	private TableHeader[] headersObject;

	private Integer headersColspan;

	private List modelList;

	// private DataTableBodyModel dtbody;

	private DataTable parent;

	public DataTableBody(String[] headersString, DataTable parent) {
		this.parent = parent;
		this.headersString = headersString;
	}

	public DataTableBody(TableHeader[] headersObject, DataTable parent) {
		this.parent = parent;
		this.headersObject = headersObject;
	}

	public DataTableBody(Integer headersColspan, DataTable parent) {
		this.parent = parent;
		this.headersColspan = headersColspan;
	}

	public DataTableBody addCell(String text) {
		TableDataStyleClass style = new TableDataStyleClass();
		Paragraph paragraph = DocumentHelper.createText(text, style);
		addCellToTable(paragraph, style);
		return this;
	}

	public DataTableBody addCell(String text, TableDataStyleClass style) {
		Paragraph paragraph = DocumentHelper.createText(text, style);
		addCellToTable(paragraph, style);
		return this;
	}

	public DataTableBody addCell(String text, String style) {
		TableDataStyleClass dataStyle = new TableDataStyleClass(style);
		Paragraph paragraph = DocumentHelper.createText(text, dataStyle);
		addCellToTable(paragraph, dataStyle);
		return this;
	}

	public DataTableBody addLine(float height) {
		try {
			TableDataStyleClass v = new TableDataStyleClass();

			if (headersString != null) {
				v.setColspan(headersString.length);
			} else if (headersObject != null) {
				v.setColspan(length(headersObject));
			} else if (headersColspan != null) {
				v.setColspan(headersColspan);
			} else {
				throw new Exception("Defina o Header");
			}

			v.setHeight(height);
			v.setBorderWidth(0);
			Paragraph paragraph = DocumentHelper.createText("", v);
			addCellToTable(paragraph, v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public int length(TableHeader... headers) {
		int length = 0;
		for (int i = 0; i < headers.length; i++) {
			length = length + headers[i].getStyle().getColspan();
		}
		return length;
	}

	public DataTableBody addDataTableBody(List modelList, DataTableBodyModel dtbody) {
		this.modelList = modelList;
		for (int i = 0; i < modelList.size(); i++) {
			dtbody.body(modelList.get(i));
		}
		cells.addAll(dtbody.getCells());
		return this;
	}

	private void addCellToTable(Paragraph p, TableDataStyleClass styleClass) {
		cells.add(DocumentHelper.createPdfPCell(p, styleClass));
	}

	public void build() {
		parent.build();
	}

	public List<PdfPCell> getCells() {
		return cells;
	}

	public void setCells(List<PdfPCell> cells) {
		this.cells = cells;
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

	public Integer getHeadersColspan() {
		return headersColspan;
	}

	public void setHeadersColspan(Integer headersColspan) {
		this.headersColspan = headersColspan;
	}

	public List getModelList() {
		return modelList;
	}

	public void setModelList(List modelList) {
		this.modelList = modelList;
	}

}
