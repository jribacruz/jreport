package br.jreport.core;

public class DataModelChartLine extends DataModelChart {

	private String serie;
	
	public DataModelChartLine(Double value, String categoria, String serie) {
		super(value, categoria);
		this.serie = serie;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
}
