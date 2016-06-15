package br.jreport.template;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import br.jreport.core.ComplexDataModelReport;
import br.jreport.core.DataModelReport;

public class ComplexModelFactory<T extends DataModelReport> extends ComplexDataModelReport<T> {
	
	
	@Override
	public List<T> getModelReport() {
		return (List<T>) modelReport;
	}
	
	@Override
	public String getNomePdf() {
		return nomePdf;
	}

	public List<ComplexModelFactory<T>> factory(List<List<T>> lista){
		List<ComplexModelFactory<T>> complexModelTest = new ArrayList<ComplexModelFactory<T>>();
		for (List<T> complexModelTemplate : lista) {
			ComplexModelFactory<T> cModelTemplate = new ComplexModelFactory<T>();
			cModelTemplate.getModelReport().addAll(complexModelTemplate);
			complexModelTest.add(cModelTemplate);
		}
		return complexModelTest;
	}
	
	public List<ComplexModelFactory<T>> factory(LinkedHashMap<String, List<T>> lista){
		List<ComplexModelFactory<T>> complexModelTest = new ArrayList<ComplexModelFactory<T>>();
		for (String nomePdf : lista.keySet()) {
			ComplexModelFactory<T> cModelTemplate = new ComplexModelFactory<T>();
			cModelTemplate.getModelReport().addAll(lista.get(nomePdf));
			cModelTemplate.nomePdf = nomePdf;
			complexModelTest.add(cModelTemplate);
		}
		return complexModelTest;
	}





}
