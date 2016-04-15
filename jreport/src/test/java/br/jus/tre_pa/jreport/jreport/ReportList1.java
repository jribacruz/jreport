package br.jus.tre_pa.jreport.jreport;

import java.util.List;

import br.jus.tre_pa.jreport.jreport.model.ModelTest;
import br.jus.tre_pa.jreport.jreport.table.DataTableBody;
import br.jus.tre_pa.jreport.jreport.template.SimpleReport;

public class ReportList1 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "Nome", "Sobrenome" };

	private List<ModelTest> modelList;

	public ReportList1(List<ModelTest> modelList) {
		super();
		this.modelList = modelList;
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
		addDataTable(modelList, headers, new DataTableBody<ModelTest>() {
			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());
			}
		});
		addText("Rodapé");
	}
}
