package br.jreport.executaveis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import br.jreport.model.ModelExempleOne;

public class ExempleOneApp {

	public static void main(String[] args) throws FileNotFoundException {
	
		ModelExempleOne	myModel = new ModelExempleOne();
		myModel.generate(new FileOutputStream(new File("target/ExemploOneReport.pdf")));
		
		
	}

}
