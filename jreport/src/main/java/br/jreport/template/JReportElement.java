package br.jreport.template;

import com.lowagie.text.Element;

public abstract class JReportElement {
	
	protected abstract Element buildElement();
	
	public abstract void build();

}
