package br.jreport.examples;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.jreport.enums.TextAlign;
import br.jreport.style.defined.DefaultTextPageHeaderStyleClass;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class PageHeaderEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		PageHeaderEx myModel = new PageHeaderEx();
		myModel.generate(new FileOutputStream(new File("target/PageHeaderEx.pdf")));
	}

	@Override
	protected void title(Title t) {
		t.addImage("brasao-republica").addTitle("Titulo").build();
	}

	@Override
	protected void pageHeader(PageHeader ph) {
		ph.addPageHeader("PageHeader").addPageHeader("Será mostrado apenas a partir da segunda página do relatório")
		.addPageHeader("O estilo padrão é alinhado a direita com fonte Normal, tamanho 9 e cor cinza").build();
		DefaultTextPageHeaderStyleClass style = new DefaultTextPageHeaderStyleClass();
		style.setColor(Color.BLUE);
		style.setFontSize(14);
		style.setTextAlign(TextAlign.LEFT);
		ph.addPageHeader("O estilo pode ser alterado passando por objeto", style).build();
		
		ph.addPageHeader("O estilo pode ser alterado passando string pattern CSS, ver código", "color:blue; font-size:14; text-align:left").build();
	}

	@Override
	protected void detail(Detail d) {
		addNewPage();
	}

	@Override
	protected void pageFooter(PageFooter pf) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary(Summary s) {
		// TODO Auto-generated method stub

	}

}
