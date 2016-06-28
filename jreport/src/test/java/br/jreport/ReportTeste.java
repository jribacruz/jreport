package br.jreport;

import br.jreport.template.Component;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class ReportTeste extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title().T_addBrasao().T_addTitle("Tribunal Regional Eleitoral do Pará").T_addTitle("Relatório de Nome e Sobrenomes"));
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addComponent(new Component().C_addText("Testando funcionalidade"));

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
