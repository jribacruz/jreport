package br.jreport.executaveis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.jreport.ReportTeste;

public class ReportTesteExec {

	public static void main(String[] args) throws IOException {
		ReportTeste rep = new ReportTeste();
		rep.generate(new FileOutputStream(new File("target/testeLeo.pdf")));
		
	}

}
