package br.jreport;

import java.util.List;

import br.jreport.model.ModelTest;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableHeader;
import br.jreport.template.SimpleReport;

public class ReportListTableHeaderSuport extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final TableHeader[] headers = { th("Nome"), th("Sobrenome", 1, 2) ,th("s") };

	private List<ModelTest> modelList;

	public ReportListTableHeaderSuport(List<ModelTest> modelList) {
		super();
		this.modelList = modelList;
	}

	@Override
	protected void title() {
		addBrasao();
		addText("Tribunal Regional Eleitoral do Pará");
		addText("Relatório de Nome e Sobrenomes");
	}

	@Override
	protected void detail() {
		addText("Lista de Nomes");
		addDataTable(modelList, headers, new DataTableBody<ModelTest>() {
			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());
				addCell(model.getNome());
				addCell(model.getSobrenome());
			}
		});
		addText("Rodapé");
	}
}
