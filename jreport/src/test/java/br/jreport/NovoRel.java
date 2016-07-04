package br.jreport;

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
//		 addTitle(new Title().T_addTitle("Relatório Geral");
		t.addTitle("Relatorio Geral").addBrasao().addTitle("aaaaaaa").build();
	}

	@Override
	protected void pageHeader(PageHeader ph) {
		ph.addTitle("texto").addTitle("texto2").build();
	}

	@Override
	protected void detail(Detail d) {
		d.addDataTable().addHeader(headers).addCell("texto").addCell("texto").addCell("texto").addLine(0.1F).addCell("texto")
				.addCell("texto").addCell("saaaaaaaaaaaaaa").build();

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
