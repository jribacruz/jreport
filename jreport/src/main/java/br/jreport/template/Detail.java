package br.jreport.template;

import com.lowagie.text.Document;

public class Detail {

	private Document document;

	private Elemento elemento;

	private DataTable datatable;

	public Detail(Document document) {
		this.document = document;
		elemento = new Elemento(this.document);
		datatable = new DataTable(this.document);
	}

	public DataTable addDataTable() {
		return datatable;
	}
	
	public Elemento addElemento() {
		return elemento;
	}
}
