package br.jreport;

import br.jreport.model.ModelTest;
import br.jreport.template.SimpleReport;

public class ReportTextoSimples extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "Nome", "Sobrenome" };

	private ModelTest modelTest;

	public ReportTextoSimples(ModelTest modelTest) {
		super();
		this.modelTest = modelTest;
	}

	@Override
	protected void detail() {
		TM_addTitle("Lista de Nomes");
	}
}
