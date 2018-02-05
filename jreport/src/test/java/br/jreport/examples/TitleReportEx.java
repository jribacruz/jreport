package br.jreport.examples;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.jreport.enums.TextAlign;
import br.jreport.style.defined.DefaultTextTitleStyleClass;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class TitleReportEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		TitleReportEx myModel = new TitleReportEx();
		myModel.generate(new FileOutputStream(new File("target/TitleReportEx.pdf")));
	}

	@Override
	protected void title(Title t) {
		t.addImage("brasao-republica").addTitle("TitleReport").addTitle("Será mostrado apenas na primeira página do relatório")
				.addTitle("O estilo padrão é centralizado").addTitle("com fonte Bold e tamanho 11").build();

		DefaultTextTitleStyleClass style = new DefaultTextTitleStyleClass();
		style.setColor(Color.RED);
		style.setFontSize(8);
		style.setTextAlign(TextAlign.RIGHT);
		t.addTitle("O estilo pode ser alterado passando por objeto", style).build();

		t.addTitle("O estilo pode ser alterado passando string pattern CSS, ver código", "color:red; text-align:right; font-size:8; font-weight:bold").build();

	}

	@Override
	protected void pageHeader(PageHeader ph) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail(Detail d) {
		// TODO Auto-generated method stub

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
