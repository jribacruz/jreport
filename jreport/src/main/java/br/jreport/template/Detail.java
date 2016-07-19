package br.jreport.template;

import com.lowagie.text.Document;

public class Detail {

	private Document document;

	private Elemento elemento;

	private DataTable datatable;

	private Chart chart;

	public Detail(Document document) {
		this.document = document;
		elemento = new Elemento(this.document);
		datatable = new DataTable(this.document);
		chart = new Chart(this.document);
	}

	public DataTable addDataTable() {
		return datatable;
	}

	public Elemento addElemento() {
		return elemento;
	}

	public Chart addChart() {
		return chart;
	}

}
