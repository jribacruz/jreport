package br.jreport.examples;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.jreport.enums.TextDecoration;
import br.jreport.style.TextStyleClass;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class DetailEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		DetailEx myModel = new DetailEx();
		myModel.generate(new FileOutputStream(new File("target/DetailEx.pdf")));
	}

	@Override
	protected void title(Title t) {
		t.addImage("brasao-republica").addTitle("Titulo").build();
	}

	@Override
	protected void pageHeader(PageHeader ph) {

	}

	@Override
	protected void detail(Detail d) {

		d.addElemento().addText("O estilo padrão é texto justificado com fonte Normal, tamanho 9, cor preta, ").build();

		d.addElemento().addText("Posso separar o texto com uma linha em branco").addBlankLine().addText("ou posso separar com uma linha")
				.addSeparator().addBlankLine().build();

		d.addElemento().addText("Adiciono um texto com estilo via pattern CSS", "font-size: 15; text-decoration: underline; color:#005000")
				.build();

		TextStyleClass style = new TextStyleClass();
		style.setFontSize(15);
		style.setTextDecoration(TextDecoration.UNDERLINE);
		style.setColor(Color.decode("#005000"));
		d.addElemento().addText("Posso passar um objeto como estilo, ver código", style).build();

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
