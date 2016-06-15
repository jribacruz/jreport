package br.jreport;

import java.awt.Color;
import java.util.List;

import br.jreport.enums.BorderStyle;
import br.jreport.enums.ColorJReport;
import br.jreport.model.ModelTest;
import br.jreport.style.TableDataStyleClass;
import br.jreport.style.TableHeaderStyleClass;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableHeader;
import br.jreport.template.SimpleReport;

public class ReportList1 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "" };
//	public static final TableHeader[] headers2 = {
//			th("Nome", new TableDataStyleClass(1f, 2, ColorJReport.LIGHT_GRAY, ColorJReport.LIGHT_GRAY, 1)), th("Teste",1f, 3) };

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
		TableHeaderStyleClass td = new TableHeaderStyleClass(1f, 1, ColorJReport.LIGHT_GRAY, ColorJReport.LIGHT_GRAY, 1);
		td.setIndentationLeft(20f);
		TableHeaderStyleClass td2 = new TableHeaderStyleClass(1f, 1, ColorJReport.WHITE, ColorJReport.BLACK, 1);
		td.setBorder(BorderStyle.LEFT_TOP_BOTTOM);
		td2.setBorder(BorderStyle.RIGHT_TOP_BOTTOM);
		TableHeader[] headers2 = {
				th("Nome", td), th("Teste",td2) };
		
//		for (int i = 0; i < 3; i++) {
			addDataTable(modelList, headers2, new DataTableBody<ModelTest>() {

				@Override
				public void body(ModelTest model) {
					TableDataStyleClass a = new TableDataStyleClass();
					a.setBorderWidth(0);
					a.setIndentationLeft(50f);
					a.setBackgroundTableColor(ColorJReport.LIGHT_LIGHT_GRAY);
					addCell(model.getNome(), a);
				
					a.setBackgroundTableColor(ColorJReport.LIGHT_GRAY);
					addCell(model.getSobrenome(), a);
					
					TableDataStyleClass ssv = new TableDataStyleClass();
					ssv.setBorderWidth(0);
					ssv.setColspan(2);
					ssv.setBackgroundTableColor(ColorJReport.BLACK);
					ssv.setFontColor(Color.WHITE);
//					ssv.setFixedHeight(1f);
					addCell(model.getNome(), ssv);

					
					
					TableDataStyleClass v = new TableDataStyleClass();
					v.setBorderWidth(0);
					v.setColspan(2);
					addCell("",v);
					
					addCell(model.getNome());
					addCell(model.getSobrenome());
				}
			});
//		}

		// addText("Rodapé");
	}
}
