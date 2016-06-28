package br.jreport.model;

import java.util.ArrayList;
import java.util.List;

import br.jreport.table.DataTableBodyModel;
import br.jreport.template.DataTable;
import br.jreport.template.SimpleReport;

public class Teste2 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
	}

	@Override
	protected void pageHeader() {

	}

	@Override
	protected void detail() {
		List<ModelTest> list = new ArrayList<ModelTest>();
		ModelTest test = new ModelTest();
		test.setNome("teste1");
		test.setSobrenome("sobrenome1");
		ModelTest test2 = new ModelTest();
		test2.setNome("teste2");
		test2.setSobrenome("sobrenome2");
		list.add(test);
		list.add(test2);
		addDataTable(new DataTable().addCell("teste1").addCell("sobrenome1").addCell("teste2").addCell("sobrenome2"));
		
		addDataTable(new DataTable().addDataTableBody(list, new DataTableBodyModel<ModelTest>() {

			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());
				
			}
		}).addCell(""));
	}

	@Override
	protected void pageFooter() {

	}

	@Override
	protected void summary() {

	}

}
