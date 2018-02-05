package br.jreport.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class DetailImagesEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		DetailImagesEx myModel = new DetailImagesEx();
		myModel.generate(new FileOutputStream(new File("target/DetailImagesEx.pdf")));
	}

	@Override
	protected void title(Title t) {
		t.addImage("tux.png", "width: 20; height:25; align: right").addImage("tux.png", "width: 20; height:25; align: left").addTitle("Titulo").build();
	}

	@Override
	protected void pageHeader(PageHeader ph) {

	}

	@Override
	protected void detail(Detail d) {
		addNewLine();
		d.addElemento().addImage("tux.png", "width: 100; height:120")
				.addText("As imagens por padrão ficam centralizadas", "text-align:center").build();
		
		d.addElemento().addImage("tux.png", "width: 20; height:25; align: left")
		.addText("Posso definir a posição e redimensionar o tamanho via objeto ou pattern CSS, ver código", "text-align:left").build();
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
