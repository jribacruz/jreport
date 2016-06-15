package br.jreport.core;

import java.util.ArrayList;
import java.util.List;


public abstract class ComplexDataModelReport<T extends DataModelReport> {

	public List<T> modelReport = new ArrayList<T>();
	
	public String nomePdf = "";
	
	public abstract List<T> getModelReport();
	
	public abstract String getNomePdf();
	
	
}
