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

	
	/**
	 * Adiciona um Gráfico no detail<br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * d.addChart().addChartBar().addLabel("Título do Gráfico", "Texto no Eixo x", "Texto no Eixo y").build();
	 * d.addChart().addChartLine().addLabel("Título do Gráfico", "Texto no Eixo x", "Texto no Eixo y").build();
	 * d.addChart().addChartPie().addLabel("Título do Gráfico").addDataSet("Label1", 3L).addDataSet("Label2", 4L).build();
	 * </pre>
	 * 
	 * </b>
	 **/
	public Chart addChart() {
		return chart;
	}

}
