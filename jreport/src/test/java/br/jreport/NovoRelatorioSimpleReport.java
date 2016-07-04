package br.jreport;

import br.jreport.style.TextStyleClass;
import br.jreport.template.Elemento;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class NovoRelatorioSimpleReport extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title().addBrasao().addTitle("Poder Judiciário da União")
				.addTitle("Tribunal Regional Eleitoral do Pará")
				.addTitle("Relatório de Pontos de Transmissão e Locais de Votação 2016"));
	}

	@Override
	protected void detail() {
		addComponent(new Elemento().addText("novo texto"));
		addNewPage();
		addComponent(new Elemento().addText("novo texto").addBlankLine().addSeparator().addText("outro texto"));
	}

	@Override
	protected void pageHeader() {
		

	}

	@Override
	protected void pageFooter() {
		addComponent(new Elemento().addText("novo texto").addBlankLine().addSeparator().addText("outro texto"));

	}

	@Override
	protected void summary() {
		// TODO Auto-generated method stub

	}

}
