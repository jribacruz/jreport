package br.jreport.model;

import br.jreport.core.Detail;
import br.jreport.core.Title;
import br.jreport.template.SimpleReport;

public class Teste2 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title(getDocument()).T_addBrasao().T_addTitle("Texto").T_addTitle("teste").T_addTitle("teste2"));

	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addDetail(new Detail(getDocument()).D_addText("FUncionalidade"));
addDataTable(modelList, headers, tableBody);

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
