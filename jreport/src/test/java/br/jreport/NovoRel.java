package br.jreport;

import java.util.Arrays;
import java.util.List;

import br.jreport.core.DataModelChartBar;
import br.jreport.table.TableHeader;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class NovoRel extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6085323579521777031L;

	public static final TableHeader[] headers = { th("Nome"), th("Sobrenome", "width:5f"), th("s") };

	@Override
	protected void title(Title t) {
		t.addImage("brasao-republica").addTitle("aaaaaaa").build();
	}

	@Override
	protected void pageHeader(PageHeader ph) {
		// ph.addPageHeader("texto").addPageHeader("texto2").build();
	}

	@Override
	protected void detail(Detail d) {
		// d.addDataTable().addHeader(headers).addCell("texto").addCell("texto").addCell("texto").addLine(0.1F).addCell("texto")
		// .addCell("texto").addCell("saaaaaaaaaaaaaa").build();
		d.addChart().addChartBar().addLabel("teste", "eixox", "eixoY");
		for (int i = 0; i < 4; i++) {
			d.addChart().addChartBar().addDataSet(i, "serie "+i, "su3");
		}
		d.addChart().addChartBar().addSize(200, 200).addOrientacaoHorizontal().build();
		
		DataModelChartBar a = new DataModelChartBar(10D, "a", "1");
		DataModelChartBar b = new DataModelChartBar(15D, "b", "1");
		DataModelChartBar c = new DataModelChartBar(30D, "c", "1");
		
		List<DataModelChartBar> list = Arrays.asList(a, b, c);
		d.addChart().addChartBar().addLabel("teste", "eixox", "eixoY").addDataSet(list).build();;
//		d.addChart().addChartPie().addTitle("teste").addDataSet(list).build();;
//		d.addChart().addChartLine().addFields("teste", "eixox", "eixoY").addDataSet(list).build();;
//		d.addChart().addChartLine().addFields("teste", "eixox", "eixoY").addDataSet(1, "serie 1", "su3").addDataSet(2, "serie 1", "su4")
//				.addDataSet(3, "serie 1", "su5").addDataSet(5, "serie 1", "su1").addSize(500, 200).build();
//		d.addChart().addChartPie().addTitle("pizza").addDataSet("aaa", 50).addDataSet("bb", 100).addDataSet("ddd", 150).build();

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
