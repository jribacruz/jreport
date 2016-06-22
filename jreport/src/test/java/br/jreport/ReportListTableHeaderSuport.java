package br.jreport;

import java.util.List;

import br.jreport.model.ModelTest;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableHeader;
import br.jreport.template.SimpleReport;

public class ReportListTableHeaderSuport extends SimpleReport {

	@Override
	protected void title() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void detail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pageFooter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void summary() {
		// TODO Auto-generated method stub
		
	}
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public static final TableHeader[] headers = { th("Nome"), th("Sobrenome", 1, 2) ,th("s") };
//
//	private List<ModelTest> modelList;
//
//	public ReportListTableHeaderSuport(List<ModelTest> modelList) {
//		super();
//		this.modelList = modelList;
//	}
//
//	@Override
//	protected void title() {
//		T_addBrasao();
//		T_addTitle("Tribunal Regional Eleitoral do Pará");
//		T_addTitle("Relatório de Nome e Sobrenomes");
//	}
//
//	@Override
//	protected void detail() {
//		T_addTitle("Lista de Nomes");
//		addDataTable(modelList, headers, new DataTableBody<ModelTest>() {
//			@Override
//			public void body(ModelTest model) {
//				addCell(model.getNome());
//				addCell(model.getSobrenome());
//				addCell(model.getNome());
//				addCell(model.getSobrenome());
//			}
//		});
//		T_addTitle("Rodapé");
//	}
}
