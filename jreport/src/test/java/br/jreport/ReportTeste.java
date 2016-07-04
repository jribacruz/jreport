package br.jreport;

import br.jreport.template.Elemento;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class ReportTeste extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title().addBrasao().addTitle("Tribunal Regional Eleitoral do Pará").addTitle("Relatório de Nome e Sobrenomes"));
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addComponent(new Elemento().addText("Testando funcionalidade"));

	}

	@Override
	protected void pageFooter() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary() {
		// TODO Auto-generated method stub

	}

}
