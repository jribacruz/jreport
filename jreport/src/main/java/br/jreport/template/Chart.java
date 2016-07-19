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
