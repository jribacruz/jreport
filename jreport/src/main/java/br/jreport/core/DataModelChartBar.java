package br.jreport.core;

public class DataModelChartBar extends DataModelChart {

	public DataModelChartBar(Double value, String categoria, String serie) {
		super(value, categoria);
		this.serie = serie;
	}

	private String serie;

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}
