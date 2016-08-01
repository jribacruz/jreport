package br.jreport.template;

import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;
import br.jreport.table.TableHeader;

public class DataTable extends JReportElement {

	private Document document;

	private DataTableBody child;

	public DataTable(Document document) {
		this.document = document;
	}

	public DataTableBody addHeader(Integer headers) {
		child = new DataTableBody(headers, this);
		return child;
	}

	public DataTableBody addHeader(String[] headers) {
		child = new DataTableBody(headers, this);
		return child;
	}

	public DataTableBody addHeader(TableHeader[] headers) {
		child = new DataTableBody(headers, this);
		return child;
	}
	
	@Override
	protected Element buildElement() {
		Element elemento = null;
		try {
			if (child.getHeadersObject() != null) {
				elemento = DocumentHelper.createDataTable(child.getHeadersObject(), child.getCells()).getPdfPTable();
			} else if (child.getHeadersString() != null) {
				elemento = DocumentHelper.createDataTable(child.getHeadersString(), child.getCells()).getPdfPTable();
			} else if (child.getHeadersColspan() != null) {
				elemento = DocumentHelper.createDataTable(child.getHeadersColspan(), child.getCells()).getPdfPTable();
			} else {
				throw new Exception("Defina o Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		clear();
		return elemento;
	}

	public void build() {
		try {
			if (child.getHeadersObject() != null) {
				DocumentHelper.add(document, DocumentHelper.createDataTable(child.getHeadersObject(), child.getCells()).getPdfPTable());
			} else if (child.getHeadersString() != null) {
				DocumentHelper.add(document, DocumentHelper.createDataTable(child.getHeadersString(), child.getCells()).getPdfPTable());
			} else if (child.getHeadersColspan() != null) {
				DocumentHelper.add(document, DocumentHelper.createDataTable(child.getHeadersColspan(), child.getCells()).getPdfPTable());
			} else {
				throw new Exception("Defina o Header");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		clear();
	}

	/**
	 * 
	 */
	private void clear() {
		child.setCells(new ArrayList<PdfPCell>());
		child.setHeadersString(null);
		child.setHeadersObject(null);
		child.setHeadersColspan(null);
		child.setModelList(null);
	}

}
