package br.jreport.model;

import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class Alkebar extends SimpleReport {

	@Override
	protected void title() {
	addTitle(new Title().addBrasao().addTitle("Tribunal Regional Eleitoral do Pará2").addSeparator());

	}
	
	

	
	@Override
	protected void pageHeader() {
	
	addPageHeader(new PageHeader().addTitle("teste de segunda"));
	
	addPageHeader(new PageHeader().addBrasao());
	
	addPageHeader(new PageHeader().addTitle("Título Mostrado a partir da segunda página"));
	
		
		
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
