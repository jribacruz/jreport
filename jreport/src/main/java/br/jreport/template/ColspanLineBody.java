package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPCell;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.defined.DetaultColspanLineStyleClass;

public class ColspanLineBody extends JReportElement {

	private List<PdfPCell> cells = new ArrayList<PdfPCell>();

	private Integer headersColspan;

	private ColspanLine parent;

	public ColspanLineBody(Integer headersColspan, ColspanLine parent) {
		this.parent = parent;
		this.headersColspan = headersColspan;
	}

	public <T extends JReportElement> ColspanLineBody addElement(T element) {
		DetaultColspanLineStyleClass styleClass = new DetaultColspanLineStyleClass();
		addElementToTable(element.buildElement(), styleClass);
		return this;
	}
	
	public <T extends JReportElement> ColspanLineBody addElement(T element, DetaultColspanLineStyleClass styleClass) {
		addElementToTable(element.buildElement(), styleClass);
		return this;
	}
	
	public <T extends JReportElement> ColspanLineBody addElement(T element, String style) {
		DetaultColspanLineStyleClass styleClass = new DetaultColspanLineStyleClass(style);
		addElementToTable(element.buildElement(), styleClass);
		return this;
	}

	public ColspanLineBody addEmptyCol() {
		cells.add(DocumentHelper.addElementCellToTable(DocumentHelper.createText("")));
		return this;
	}

	private void addElementToTable(Element p, DetaultColspanLineStyleClass style) {
		cells.add(DocumentHelper.addElementCellToTable(p, style));
	}
	

	public void build() {
		parent.build();
	}

	protected Element buildElement() {
		return parent.buildElement();
	}

	public List<PdfPCell> getCells() {
		return cells;
	}

	public void setCells(List<PdfPCell> cells) {
		this.cells = cells;
	}

	public Integer getHeadersColspan() {
		return headersColspan;
	}

	public void setHeadersColspan(Integer headersColspan) {
		this.headersColspan = headersColspan;
	}

}
