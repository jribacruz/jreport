package br.jus.tre_pa.jreport.jreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.jus.tre_pa.jreport.jreport.model.ModelTest;

public class MainReportListApp {

	public static void main(String[] args) throws IOException {

		ModelTest modelTest1 = new ModelTest("Maria", "José");
		ModelTest modelTest2 = new ModelTest("Lúcia", "Fátima");
		ModelTest modelTest3 = new ModelTest("Leonardo", "Ramos");
		ModelTest modelTest4 = new ModelTest("Manoel", "Silva");
		List<ModelTest> list = Arrays.asList(modelTest1, modelTest2, modelTest3, modelTest4);
		
		
		ReportList1 report1 = new ReportList1(list);
		report1.generate(new FileOutputStream(new File("target/report1.pdf")));

		ReportListTableHeaderSuport report2 = new ReportListTableHeaderSuport(list);
		report2.generate(new FileOutputStream(new File("target/report2.pdf")));
		
	}
}
