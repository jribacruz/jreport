package br.jreport;

import java.awt.Color;

import br.jreport.enums.TextAlign;
import br.jreport.functions.Title;
import br.jreport.style.TextStyleClass;
import br.jreport.template.SimpleReport;

public class NovoRelatorioSimpleReport extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addTitle(new Title(getDocument()).T_addBrasao().T_addTitle("Poder Judiciário da União")
				.T_addTitle("Tribunal Regional Eleitoral do Pará")
				.T_addTitle("Relatório de Pontos de Transmissão e Locais de Votação 2016"));
	}

	@Override
	protected void detail() {
	}

	@Override
	protected void pageHeader() {
		// TODO Auto-generated method stub

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
