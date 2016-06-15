package br.jreport.executaveis;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import br.jreport.ComplexReportListTableHeaderSuport;
import br.jreport.model.ModelTest;

public class MainReportListAppComplex {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		//Utilizando Lista.
		ModelTest modelTest1 = new ModelTest("Maria", "José");
		ModelTest modelTest2 = new ModelTest("Lúcia", "Fátima");
		ModelTest modelTest3 = new ModelTest("Leonardo", "Ramos");
		ModelTest modelTest4 = new ModelTest("Manoel", "Silva");
		ModelTest modelTest5 = new ModelTest("teste", "teste");
		ModelTest modelTest6 = new ModelTest("teste", "aaa");
		ModelTest modelTest7 = new ModelTest("vvv", "ssss");
		ModelTest modelTest8 = new ModelTest("aaaqwewqe", "gfdhgfhfghf");
		
		List<ModelTest> list = Arrays.asList(modelTest1, modelTest2, modelTest3, modelTest4);
		List<ModelTest> list2 = Arrays.asList(modelTest3, modelTest4, modelTest5, modelTest6);
		List<ModelTest> list3 = Arrays.asList(modelTest5, modelTest6, modelTest7, modelTest8);
		
		List<List<ModelTest>> lista = new ArrayList<List<ModelTest>>();
		lista.addAll(Arrays.asList(list, list2, list3));
		
		ComplexReportListTableHeaderSuport report = new ComplexReportListTableHeaderSuport(lista, "RelatorioComplexoZip");
		report.generateMultiplePdf_ZipFile("target/");
		report.generate("target/");
		
		ByteArrayInputStream byteArrayzip = report.generateMultiplePdf_ZipFile();
		FileUtils.writeByteArrayToFile(new File("target/relatorioCompletoZip.zip"), IOUtils.toByteArray(byteArrayzip),true);
		
		
		//Utilizando LinkedHashMap. a key é usada para dar nomes aos relatorios caso seja gerado o arquivo zip
		LinkedHashMap<String, List<ModelTest>> linkedhashmap = new LinkedHashMap<String, List<ModelTest>>();
		linkedhashmap.put("Nome Relatorio um", list);
		linkedhashmap.put("Nome Relatorio teste", list2);
		linkedhashmap.put("Nome Relatorio", list3);
		
		ComplexReportListTableHeaderSuport report2 = new ComplexReportListTableHeaderSuport(linkedhashmap);
		ByteArrayInputStream b = report2.generateMultiplePdf_ZipFile();
		FileUtils.writeByteArrayToFile(new File("target/relatoriocompletoLinked.zip"), IOUtils.toByteArray(b),true);
		report2.generateMultiplePdf_ZipFile("target/");
		report2.generate("target/relatoriocompleto.pdf");
		
		
		
	}
}
