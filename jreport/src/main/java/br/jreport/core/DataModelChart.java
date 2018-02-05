package br.jreport.core;

import java.awt.Color;

public abstract class DataModelChart {

	private Double value;

	private String categoria;

	private Color color;

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
