package br.jreport;

import br.jreport.core.Detail;
import br.jreport.core.Title;
import br.jreport.template.SimpleReport;

public class ReportTeste extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title(getDocument()).T_addBrasao().T_addTitle("Teste").T_addTitle("teste2"));

	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addDetail(new Detail(getDocument()).D_addText("Testando funcionalidade"));

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
