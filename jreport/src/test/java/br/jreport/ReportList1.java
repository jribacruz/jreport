package br.jreport;

import java.util.List;

import br.jreport.enums.FontStyle;
import br.jreport.model.ModelTest;
import br.jreport.style.TableDataStyleClass;
import br.jreport.table.DataTableBodyModel;
import br.jreport.template.DataTable;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class ReportList1 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "aaa", "aaa", "aaa", "ddd" };
	// public static final TableHeader[] headers2 = {
	// th("Nome", new TableDataStyleClass(1f, 2, ColorJReport.LIGHT_GRAY,
	// ColorJReport.LIGHT_GRAY, 1)), th("Teste",1f, 3) };

	private List<ModelTest> modelList;

	public ReportList1(List<ModelTest> modelList) {
		super();
		this.modelList = modelList;
	}

	protected void title(Title t) {

		t.addBrasao().addTitle("Relatorio xxxxxxx");

		// Title titulo = new Title();
		// titulo.addBrasao();
		// titulo.addTitle("teste");
		// addTitle(titulo);
	}

	@Override
	protected void detail(Detail d) {
		d.addDataTable().addCell("").build();
		d.addElemento().addText("Texto").build();
		// addComponent(new Component().);
		// addComponent(new Component(getDocument()).C_addText("a"));
		// addDataTableNew(new
		// DataTableMethods().addHeader(headers).addDataTableBody(modelList, new
		// DataTableBody<ModelTest>() {
		//
		// @Override
		// public void body(ModelTest model) {
		// // TODO Auto-generated method stub
		//
		// }
		// }));
		//@formatter:off
		
//		TextStyleClass a = new TextStyleClass();
//		a.setFontSize(5);
//		addComponent(new Component().C_addText("teste",a));
//		addDataTable(new DataTable().addHeader(headers).addLine(1, 4).addCell("Teste","font-size:9; height: 50").addCell("aaaaaaaaaaaaaa").addCell("aaaaaaaaaaaaaa").addCell("aaaaaaaaaaaaaa"));
//		TableDataStyleClass a = new TableDataStyleClass();
//		a.setFontStyle(FontStyle.BOLD);
//		addDataTable(new DataTable().addHeader(4)
//				.addCell("Assunto:", a).addCell("PRESTAÇÃO DE CONTAS DE SUPRIMENTO", "colspan:3; border:RIGHT_TOP_BOTTOM")
//				
//				.addCell("Suprido", "font-style:bold; border:LEFT_TOP_BOTTOM").addCell("Erica...", "border:TOP_BOTTOM")
//				.addCell("LOTACAO", "font-style:bold; border:TOP_BOTTOM").addCell("106ª ZE Parauapebas", "border:RIGHT_TOP_BOTTOM")
//				
//				.addCell("Portaria(s)", "font-style:bold; border:LEFT_TOP; colspan: 4")
//				
//				.addCell("Concessão", "border:LEFT").addCell("15.992/2016 - DG", "border: NONE; colspan: 3")
////				.addCell("LOTACAO", "font-style:bold; border:TOP_BOTTOM").addCell("106ª ZE Parauapebas", "border:RIGHT_TOP_BOTTOM")
////				
//				);
//		addNewLine();
//		addDataTable(new DataTable().addHeader(headers)
//				.addCell("Assunto:", "font-style:bold; border:LEFT_TOP_BOTTOM").addCell("PRESTAÇÃO DE CONTAS DE SUPRIMENTO", "colspan:3; border:RIGHT_TOP_BOTTOM")
//				
//				.addCell("Suprido", "font-style:bold; border:LEFT_TOP_BOTTOM").addCell("Erica...", "border:TOP_BOTTOM")
//				.addCell("LOTACAO", "font-style:bold; border:TOP_BOTTOM").addCell("106ª ZE Parauapebas", "border:RIGHT_TOP_BOTTOM")
//				
//				.addCell("Portaria(s)", "font-style:bold; border:LEFT_TOP; colspan: 4")
//				
//				.addCell("Concessão", "border:LEFT").addCell("15.992/2016 - DG", "border: NONE; colspan: 3")
////				.addCell("LOTACAO", "font-style:bold; border:TOP_BOTTOM").addCell("106ª ZE Parauapebas", "border:RIGHT_TOP_BOTTOM")
////				
//				);
		//@formatter:on

		// TableHeaderStyleClass td = new TableHeaderStyleClass(1f, 1,
		// ColorJReport.LIGHT_GRAY, ColorJReport.LIGHT_GRAY, 1);
		// td.setIndentationLeft(20f);
		// TableHeaderStyleClass td2 = new TableHeaderStyleClass(1f, 1,
		// ColorJReport.WHITE, ColorJReport.BLACK, 1);
		// td.setBorder(BorderStyle.LEFT_TOP_BOTTOM);
		// td2.setBorder(BorderStyle.RIGHT_TOP_BOTTOM);
		// TableHeader[] headers2 = { th("Nome", td), th("Teste", td2) };

		d.addDataTable().addHeader(2).addDataTableBody(modelList, new DataTableBodyModel<ModelTest>() {

			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());
			}
		}).build();
		//
		// // for (int i = 0; i < 3; i++) {
		// addDataTable(new
		// DataTable<ModelTest>(getDocument()).addDataTable(modelListp,
		// headers2,
		// new DataTableBody<ModelTest>() {
		//
		// @Override
		// public void body(ModelTest model) {
		//
		// TableDataStyleClass a = new TableDataStyleClass();
		// a.setBorderWidth(0);
		// a.setIndentationLeft(50f);
		// a.setBackgroundTableColor(ColorJReport.LIGHT_LIGHT_GRAY);
		// addCell(model.getNome(), a);
		//
		// a.setBackgroundTableColor(ColorJReport.LIGHT_GRAY);
		// addCell(model.getSobrenome(), a);
		//
		// TableDataStyleClass ssv = new TableDataStyleClass();
		// ssv.setBorderWidth(0);
		// ssv.setColspan(2);
		// ssv.setBackgroundTableColor(ColorJReport.BLACK);
		// ssv.setFontColor(Color.WHITE);
		// // ssv.setFixedHeight(1f);
		// addCell(model.getNome(), ssv);
		//
		// TableDataStyleClass v = new TableDataStyleClass();
		// v.setBorderWidth(0);
		// v.setColspan(2);
		// addCell("", v);
		//
		// addCell(model.getNome());
		// addCell(model.getSobrenome());
		// }
		// }));

		// }

		// addText("Rodapé");
	}

	@Override
	protected void pageHeader(PageHeader ph) {
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
}
