package br.jreport;

import java.awt.Color;

import br.jreport.core.TextStyleClass;
import br.jreport.enums.TextAlign;
import br.jreport.template.SimpleReport;

public class NovoRelatorioSimpleReport extends SimpleReport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void title() {
		addBrasao();
		addTitle("Poder Judiciário da União");
		addTitle("Tribunal Regional Eleitoral do Pará");
		addTitle("Relatório de Pontos de Transmissão e Locais de Votação 2016");
	}
	
	@Override
	protected void detail() {
		TextStyleClass style = new TextStyleClass();
		style.setTextAlign(TextAlign.RIGHT);
		style.setFontColor(Color.RED);
		style.setFontSize(10L);
		
		addText("Aelis 2016 - \n Módulo rotas", style);
		addText("Aelis 2016 - Módulo rotas");
	}

}
