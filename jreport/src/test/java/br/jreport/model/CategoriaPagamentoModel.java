package br.jreport.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.jreport.core.DataModelReport;

public class CategoriaPagamentoModel implements DataModelReport {

	private String categoria;

	private Map<String, BigDecimal> meses;

	private static Map<String, BigDecimal> totalMeses = new HashMap<String, BigDecimal>();

	public CategoriaPagamentoModel(String categoria, HashMap<String, BigDecimal> meses) {
		this.categoria = categoria;
		this.meses = meses;
		for (String key : meses.keySet()) {
			somarTotal(categoria, meses.get(key));
		}
	}

	public void somarTotal(String key, BigDecimal valor) {
		if (totalMeses.containsKey(key)) {
			totalMeses.put(key, totalMeses.get(key).add(valor));
		} else {
			totalMeses.put(key, valor);
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Map<String, BigDecimal> getMeses() {
		return meses;
	}

	public void setMeses(Map<String, BigDecimal> meses) {
		this.meses = meses;
	}

	public static Map<String, BigDecimal> getTotalMeses() {
		return totalMeses;
	}

	public static void setTotalMeses(Map<String, BigDecimal> totalMeses) {
		CategoriaPagamentoModel.totalMeses = totalMeses;
	}

}
