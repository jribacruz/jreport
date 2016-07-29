package br.jreport.examples;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import br.jreport.enums.TextDecoration;
import br.jreport.model.ModelTest;
import br.jreport.style.TextStyleClass;
import br.jreport.table.DataTableBodyModel;
import br.jreport.table.TableHeader;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class DetailDataTableEx extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException {
		DetailDataTableEx myModel = new DetailDataTableEx();
		myModel.generate(new FileOutputStream(new File("target/DetailDataTableEx.pdf")));
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
		String[] header = { "Primeira coluna", "Segunda coluna", "Terceira coluna" };
		d.addDataTable().addHeader(header).addCell("Primeira cell").addCell("Segunda cell").addCell("Terceira cell").build();
		espacoExemplo();
		
		TableHeader[] headerTb1 = { th("Posso usar o table header para passar estilo", "colspan:3; color:white; background-color: gray") };
		d.addDataTable().addHeader(headerTb1).addLine(1).addCell("Primeira cell").addCell("Segunda cell").addCell("Terceira cell").build();
		espacoExemplo();
		
		TableHeader[] headerTb2 = { th("Table header, usando lista de model", "colspan:3;") };
		List<ModelTest> listaModel = Arrays.asList(new ModelTest("Manoel", "Silva"), new ModelTest("Perreira", "Ramos"));
		d.addDataTable().addHeader(headerTb2).addDataTableBody(listaModel, new DataTableBodyModel<ModelTest>() {
			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());

			}
		}).build();
		espacoExemplo();
		
		TableHeader[] headerTb3 = { th("Editando estilo de célula para ocultar borda", "colspan:3; border-right-width:0"), th("Segundo header", "border-left-width:0") };
		List<ModelTest> listaModel2 = Arrays.asList(new ModelTest("Manoel", "Silva"), new ModelTest("Perreira", "Ramos"));
		d.addDataTable().addHeader(headerTb3).addDataTableBody(listaModel2, new DataTableBodyModel<ModelTest>() {
			@Override
			public void body(ModelTest model) {
				addCell(model.getNome());
				addCell(model.getSobrenome());

			}
		}).build();
		
		

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
