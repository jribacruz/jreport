package br.jreport;

import java.awt.Color;

import br.jreport.core.TextStyleClass;
import br.jreport.core.Title;
import br.jreport.enums.TextAlign;
import br.jreport.template.SimpleReport;

public class NovoRelatorioSimpleReport extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		
		addTitle(new Title(getDocument()).TM_addBrasao().TM_addTitle("Poder Judiciário da União")
				.TM_addTitle("Tribunal Regional Eleitoral do Pará")
				.TM_addTitle("Relatório de Pontos de Transmissão e Locais de Votação 2016"));
	}

	@Override
	protected void detail() {
		TextStyleClass style = new TextStyleClass();
		style.setTextAlign(TextAlign.RIGHT);
		style.setFontColor(Color.RED);
		style.setFontSize(10L);

		TM_addTitle("Aelis 2016 - \n Módulo rotas", style);
		TM_addTitle("Aelis 2016 - Módulo rotas");
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
