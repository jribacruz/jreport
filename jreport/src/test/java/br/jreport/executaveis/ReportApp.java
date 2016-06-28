package br.jreport.executaveis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.jreport.model.Teste2;

public class ReportApp {

	public static void main(String[] args) throws IOException {
		Teste2 report1 = new Teste2();
		report1.generate(new FileOutputStream(new File("target/teste2.pdf")));
		

	}

}
