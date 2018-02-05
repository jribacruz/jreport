package br.jreport.template;

import java.util.ArrayList;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;

public class ColspanLine extends JReportElement {

	private Document document;

	private ColspanLineBody child;

	public ColspanLine(Document document) {
		this.document = document;
	}

	public ColspanLineBody addCols(Integer headers) {
		child = new ColspanLineBody(headers, this);
		return child;
	}

	@Override
	protected Element buildElement() {
		Element elemento = DocumentHelper.createDataTable(child.getHeadersColspan(), child.getCells()).getPdfPTable();
		clear();
		return elemento;
	}

	public void build() {
		try {
			DocumentHelper.add(document, DocumentHelper.createDataTable(child.getHeadersColspan(), child.getCells()).getPdfPTable());
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
		child.setHeadersColspan(null);
	}

}
