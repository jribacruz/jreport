package br.jreport.model;

import br.jreport.table.DataTableBodyModel;
import br.jreport.template.ChartPie;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class ModelExempleOne extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title(Title t) {
		t.addBrasao().addTitle("Title Of Report").build();

	}

	@Override
	protected void pageHeader(PageHeader ph) {
		ph.addPageHeader("Resumo por Zona").build();

	}

	@Override
	protected void detail(Detail d) {
		d.addChart().addChartBar().addLabel("Título do Gráfico", "Texto no Eixo x", "Texto no Eixo y")
				.addDataSet(3L, "2021", "Animais")
				.addDataSet(3L, "2021", "Frutas")
				.addDataSet(3L, "2022", "Animais")
				.addDataSet(4L, "2022", "Frutas").build();
		
		
		
		d.addChart().addChartLine().addLabel("Título do Gráfico", "Texto no Eixo x", "Texto no Eixo y").build();
		d.addChart().addChartPie().addLabel("Título do Gráfico").addDataSet("Label1", 3L).addDataSet("Label2", 4L)
				.build();

		/*
		 * for (int i = 0; i < 5; i++) { d.addChart().addChartPie().addDataSet(
		 * "qualquer texto" +i , i); } d.addChart().addChartPie().build();
		 */

	}

	@Override
	protected void pageFooter(PageFooter pf) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary(Summary s) {
		// TODO Auto-generated method stub

	}

}
