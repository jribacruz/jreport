package br.jus.tre_pa.jreport.jreport;

import java.util.LinkedHashMap;
import java.util.List;

import br.jus.tre_pa.jreport.jreport.enums.PageOrientation;
import br.jus.tre_pa.jreport.jreport.model.ModelTest;
import br.jus.tre_pa.jreport.jreport.table.DataTableBody;
import br.jus.tre_pa.jreport.jreport.table.TableHeader;
import br.jus.tre_pa.jreport.jreport.template.ComplexReport;

public class ComplexReportListTableHeaderSuport extends ComplexReport<ModelTest> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final TableHeader[] headers = { th("Nome"), th("Sobrenome", 1, 2) ,th("s") };

	
	public ComplexReportListTableHeaderSuport() {
	}
	/**
	 * Quatro construtores possíveis de se chamar
	 * **/
	
	public ComplexReportListTableHeaderSuport(List<List<ModelTest>> lista, String nomeRelatorio) {
		super(lista, nomeRelatorio, ComplexReportListTableHeaderSuport.class);
	}
	
	public ComplexReportListTableHeaderSuport(List<List<ModelTest>> lista,String nomeRelatorio, PageOrientation pageOrientation) {
		super(lista, nomeRelatorio, pageOrientation, ComplexReportListTableHeaderSuport.class);
	}
	
	public ComplexReportListTableHeaderSuport(LinkedHashMap<String, List<ModelTest>> linkedHashMap){
		super(linkedHashMap, ComplexReportListTableHeaderSuport.class);
	}
	
	public ComplexReportListTableHeaderSuport(LinkedHashMap<String, List<ModelTest>> linkedHashMap, PageOrientation pageOrientation) {
		super(linkedHashMap, pageOrientation, ComplexReportListTableHeaderSuport.class);
	}
	

	@Override
	protected void title() {
		addBrasao();
		addTitle("Tribunal Regional Eleitoral do Pará");
		addTitle("Relatório de Nome e Sobrenomes");
	}

	@Override
	protected void detail() {
		nomeRelatorio();
		addDataTable(getModelListComplex(), headers, new DataTableBody<ModelTest>() {
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
