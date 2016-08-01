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

public class ColspanLineEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		ColspanLineEx myModel = new ColspanLineEx();
		myModel.generate(new FileOutputStream(new File("target/ColspanLineEx.pdf")));
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
		//@formatter:off
		d.addColspanLine().addCols(3)
				.addElement(d.addElemento().addText("Para adicionar mais de um elemento em uma linha deve-se usar addColspanLine"))
				.addElement(d.addElemento().addImage("tux.png", "width: 20; height:25; align: right"), "border-width:2")
				.addElement(d.addElemento().addImage("tux.png", "width: 20; height:25; align: right"))
			.build();
		espacoExemplo();

		d.addColspanLine().addCols(4)
				.addElement(d.addElemento().addText("Para preencher celulas não utilizadas, deve-se usar addEmptyCellToTable"))
				.addElement(d.addElemento().addImage("tux.png", "width: 20; height:25; align: right"))
				.addEmptyCol()
				.addElement(d.addElemento().addImage("tux.png", "width: 20; height:25; align: right"))
			.build();
		//@formatter:on
	}

	/**
	 * 
	 */
	private void espacoExemplo() {
		addNewLine();
		addNewLine();
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
