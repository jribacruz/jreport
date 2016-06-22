package br.jreport.model;

import br.jreport.core.Component;
import br.jreport.core.DataTable;
import br.jreport.core.Title;
import br.jreport.table.DataTableBody;
import br.jreport.template.SimpleReport;

public class Teste2 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title(getDocument()).T_addBrasao().T_addTitle("Texto").T_addTitle("teste").T_addTitle("teste2"));
		addDataTable(new DataTable<ModelTest>(document).addDataTable(null, 0, new DataTableBody<ModelTest>() {
			
			@Override
			public void body(ModelTest model) {
				
			}
		}));
		addDataTable(new DataTable<ModelTest>(getDocument()).addDataTable(null, 0, new DataTableBody<ModelTest>() {

			@Override
			public void body(ModelTest model) {
				// TODO Auto-generated method stub
				
			}
		}));
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addComponent(new Component(getDocument()).C_addText("FUncionalidade"));
	}

	@Override
	protected void pageFooter() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary() {
		// TODO Auto-generated method stub

	}

}
