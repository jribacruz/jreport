package br.jreport.core;

public abstract class DataModelChart {

	private Double value;

	private String categoria;

	public DataModelChart(Double value, String categoria) {
		super();
		this.value = value;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
