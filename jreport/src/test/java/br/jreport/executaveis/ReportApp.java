package br.jreport.executaveis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.jreport.NovoRelatorioSimpleReport;
import br.jreport.ReportSecoes;
import br.jreport.ReportTextoSimples;
import br.jreport.model.ModelTest;

public class ReportApp {

	public static void main(String[] args) throws IOException {
		NovoRelatorioSimpleReport report1 = new NovoRelatorioSimpleReport();
		report1.generate(new FileOutputStream(new File("target/NovoRelatorioSimpleReport.pdf")));
		
	}

}
