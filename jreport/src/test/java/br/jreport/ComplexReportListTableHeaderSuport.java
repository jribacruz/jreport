package br.jreport;

import java.util.LinkedHashMap;
import java.util.List;

import br.jreport.enums.PageOrientation;
import br.jreport.model.ModelTest;
import br.jreport.template.ComplexReport;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class ComplexReportListTableHeaderSuport extends ComplexReport<ModelTest> {

	/**
	 * 
	 */

	public ComplexReportListTableHeaderSuport() {
	}

	/**
	 * Quatro construtores possíveis de se chamar
	 **/

	public ComplexReportListTableHeaderSuport(List<List<ModelTest>> lista, String nomeRelatorio) {
		super(lista, nomeRelatorio, ComplexReportListTableHeaderSuport.class);
	}

	public ComplexReportListTableHeaderSuport(List<List<ModelTest>> lista, String nomeRelatorio, PageOrientation pageOrientation) {
		super(lista, nomeRelatorio, pageOrientation, ComplexReportListTableHeaderSuport.class);
	}

	public ComplexReportListTableHeaderSuport(LinkedHashMap<String, List<ModelTest>> linkedHashMap) {
		super(linkedHashMap, ComplexReportListTableHeaderSuport.class);
	}

//	public ComplexReportListTableHeaderSuport(LinkedHashMap<String, List<ModelTest>> linkedHashMap, PageOrientation pageOrientation) {
//		super(linkedHashMap, pageOrientation, ComplexReportListTableHeaderSuport.class);
//	}
//
//	@Override
//	protected void title() {
//		// addBrasao();
//		// addTitle("Tribunal Regional Eleitoral do Pará");
//		// addTitle("Relatório de Nome e Sobrenomes");
//	}
//
//	@Override
//	protected void detail() {
//		nomeRelatorio();
////		addDataTable(new DataTable<ModelTest>(document).addDataTable(getModelList(), headers, new DataTableBody<ModelTest>() {
////			@Override
////			public void body(ModelTest model) {
////				addCell(model.getNome());
////				addCell(model.getSobrenome());
////				addCell(model.getNome());
////				addCell(model.getSobrenome());
////			}
////		}));
//		// TM_addTitle("Rodapé");
//	}
//
//	@Override
//	protected void pageHeader() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void pageFooter() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void summary() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void title(Title t) {
//		// TODO Auto-generated method stub
//		
//	}

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

	@Override
	protected void title(Title t) {
		// TODO Auto-generated method stub
		
	}

}
