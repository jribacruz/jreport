package br.jreport;

import br.jreport.template.Component;
import br.jreport.template.SimpleReport;
import br.jreport.template.Title;

public class NovoRelatorioSimpleReport extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title().T_addBrasao().T_addTitle("Poder Judiciário da União")
				.T_addTitle("Tribunal Regional Eleitoral do Pará")
				.T_addTitle("Relatório de Pontos de Transmissão e Locais de Votação 2016"));
	}

	@Override
	protected void detail() {
		addComponent(new Component().C_addText("novo texto"));
		addNewPage();
		addComponent(new Component().C_addText("novo texto").C_addBlankLine().C_addSeparator().C_addText("outro texto"));
	}

	@Override
	protected void pageHeader() {
		

	}

	@Override
	protected void pageFooter() {
		addComponent(new Component().C_addText("novo texto").C_addBlankLine().C_addSeparator().C_addText("outro texto"));

	}

	@Override
	protected void summary() {
		// TODO Auto-generated method stub

	}

}
