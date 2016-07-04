package br.jreport;

import java.util.List;

import br.jreport.model.ModelTest;
import br.jreport.table.DataTableBodyModel;
import br.jreport.table.TableHeader;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class ReportListTableHeaderSuport extends SimpleReport {

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
