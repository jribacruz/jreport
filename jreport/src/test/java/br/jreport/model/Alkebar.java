package br.jreport.model;

import br.jreport.template.Component;
import br.jreport.template.Foo;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class Alkebar extends SimpleReport {

	@Override
	protected void title() {
	addTitle(new Title().T_addBrasao().T_addTitle("Tribunal Regional Eleitoral do Pará2").T_addSeparator());

	}

	@Override
	protected void pageHeader() {
	
	addPageHeader(new PageHeader().H_addTitle("teste de segunda"));
	
	addPageHeader(new PageHeader().H_addBrasao());
	
	addPageHeader(new PageHeader().H_addTitle("Título Mostrado a partir da segunda página"));
	
		
		
	}

	@Override
	protected void detail() {
		// TODO Auto-generated method stub
		addNewPage();
		addNewPage();
	}

	@Override
	protected void pageFooter() {


		
	}

	@Override
	protected void summary() {
	
		
	}
	


}
