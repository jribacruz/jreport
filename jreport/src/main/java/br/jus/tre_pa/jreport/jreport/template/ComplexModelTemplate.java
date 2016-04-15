package br.jus.tre_pa.jreport.jreport.template;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import br.jus.tre_pa.jreport.jreport.core.ComplexDataModelReport;
import br.jus.tre_pa.jreport.jreport.core.DataModelReport;

public class ComplexModelTemplate<T extends DataModelReport> extends ComplexDataModelReport<T> {
	
	
	@Override
	public List<T> getModelReport() {
		return (List<T>) modelReport;
	}
	
	@Override
	public String getNomePdf() {
		return nomePdf;
	}

	public List<ComplexModelTemplate<T>> factory(List<List<T>> lista){
		List<ComplexModelTemplate<T>> complexModelTest = new ArrayList<ComplexModelTemplate<T>>();
		for (List<T> complexModelTemplate : lista) {
			ComplexModelTemplate<T> cModelTemplate = new ComplexModelTemplate<T>();
			cModelTemplate.getModelReport().addAll(complexModelTemplate);
			complexModelTest.add(cModelTemplate);
		}
		return complexModelTest;
	}
	
	public List<ComplexModelTemplate<T>> factory(LinkedHashMap<String, List<T>> lista){
		List<ComplexModelTemplate<T>> complexModelTest = new ArrayList<ComplexModelTemplate<T>>();
		for (String key : lista.keySet()) {
			ComplexModelTemplate<T> cModelTemplate = new ComplexModelTemplate<T>();
			cModelTemplate.getModelReport().addAll(lista.get(key));
			cModelTemplate.nomePdf = key;
			complexModelTest.add(cModelTemplate);
		}
		return complexModelTest;
	}





}
