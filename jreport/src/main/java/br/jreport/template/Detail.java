package br.jreport.template;

import com.lowagie.text.Document;

public class Detail {

	private Document document;

	public Detail(Document document) {
		this.document = document;
	}

	public ColspanLine addColspanLine() {
		return new ColspanLine(this.document);
	}

	public DataTable addDataTable() {
		return new DataTable(this.document);
	}

	public Elemento addElemento() {
		return new Elemento(this.document);
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
		return new Chart(this.document);
	}

}
