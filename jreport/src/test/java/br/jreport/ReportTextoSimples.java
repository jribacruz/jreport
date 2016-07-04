package br.jreport;

import br.jreport.model.ModelTest;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class ReportTextoSimples extends SimpleReport {

	@Override
	protected void title(Title t) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void pageHeader(PageHeader ph) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail(Detail d) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void pageFooter(PageFooter pf) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary(Summary s) {
		// TODO Auto-generated method stub

	}

	//
	// /**
	// *
	// */
	// private static final long serialVersionUID = 1L;
	//
	// public static final String[] headers = { "Nome", "Sobrenome" };
	//
	// private ModelTest modelTest;
	//
	// public ReportTextoSimples(ModelTest modelTest) {
	// super();
	// this.modelTest = modelTest;
	// }
	//
	// @Override
	// protected void detail() {
	// T_addTitle("Lista de Nomes");
	// }
}
