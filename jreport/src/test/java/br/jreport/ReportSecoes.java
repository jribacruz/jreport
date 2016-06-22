package br.jreport;

import br.jreport.model.ModelTest;
import br.jreport.template.SimpleReport;

public class ReportSecoes extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "Nome", "Sobrenome" };

	private ModelTest modelTest;

	public ReportSecoes(ModelTest modelTest) {
		super();
		this.modelTest = modelTest;
	}

	@Override
	protected void title() {
		addBrasao();
		addTitle("Tribunal Regional Eleitoral do Pará");
		addTitle("Relatório de Nome e Sobrenomes");
	}

	@Override
	protected void detail() {
		TM_addTitle("Lista de Nomes");
//		addTable(headers, new TableBody() {
//			@Override
//			public void body() {
//				addCell(modelTest.getNome());
//				addCell(modelTest.getSobrenome());
//			}
//		});
	}
}
