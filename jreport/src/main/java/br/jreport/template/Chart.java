package br.jreport.template;

import com.lowagie.text.Document;

public class Chart {

	private ChartBar chartBar;

	private ChartPie chartPie;

	private ChartLine chartLine;

	public Chart(Document document) {
		chartBar = new ChartBar(document);
		chartPie = new ChartPie(document);
		chartLine = new ChartLine(document);
	}

	/**
	 * Adiciona um Gráfico Tipo Barra no detail<br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * d.addChart().addChartBar().addLabel("Título do Gráfico", "Texto no Eixo x", "Texto no Eixo y").build();
	 * </pre>
	 * 
	 * </b>
	 **/
	public ChartBar addChartBar() {
		return chartBar;
	}

	public ChartPie addChartPie() {
		return chartPie;
	}

	public ChartLine addChartLine() {
		return chartLine;
	}
}
