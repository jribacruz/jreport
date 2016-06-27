package br.jreport.model;

import br.jreport.table.DataTableBodyModel;
import br.jreport.template.Component;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class Teste2 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
//		addTitle(new Title(getDocument()).T_addBrasao().T_addTitle("Texto").T_addTitle("teste").T_addTitle("teste2"));
//		addDataTable(new DataTable<ModelTest>(document).addDataTable(null, 0, new DataTableBody<ModelTest>() {
//			
//			@Override
//			public void body(ModelTest model) {
//				
//			}
//		}));
//		addDataTable(new DataTable<ModelTest>(getDocument()).addDataTable(null, 0, new DataTableBody<ModelTest>() {
//
//			@Override
//			public void body(ModelTest model) {
//				// TODO Auto-generated method stub
//				
//			}
//		}));
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail() {
		addComponent(new Component().C_addText("FUncionalidade"));
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
