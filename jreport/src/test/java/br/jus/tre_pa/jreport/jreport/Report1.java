package br.jus.tre_pa.jreport.jreport;

import br.jus.tre_pa.jreport.jreport.model.ModelTest;
import br.jus.tre_pa.jreport.jreport.table.TableBody;
import br.jus.tre_pa.jreport.jreport.template.SimpleReport;

public class Report1 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "Nome", "Sobrenome" };

	private ModelTest modelTest;

	public Report1(ModelTest modelTest) {
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
		addText("Lista de Nomes");
		addTable(headers, new TableBody() {
			@Override
			public void body() {
				addCell(modelTest.getNome());
				addCell(modelTest.getSobrenome());
			}
		});
	}
}
