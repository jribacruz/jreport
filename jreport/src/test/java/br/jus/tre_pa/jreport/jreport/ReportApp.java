package br.jus.tre_pa.jreport.jreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.jus.tre_pa.jreport.jreport.model.ModelTest;

public class ReportApp {

	public static void main(String[] args) throws IOException {
		ModelTest modelTest = new ModelTest();
		modelTest.setNome("Maria");
		modelTest.setSobrenome("José");

		Report1 report1 = new Report1(modelTest);
		report1.generate(new FileOutputStream(new File("target/report1.pdf")));
	}

}
