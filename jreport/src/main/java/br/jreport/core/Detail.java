package br.jreport.core;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;

import br.jreport.helper.DocumentHelper;

public class Detail {

	private Document document;

	protected List<Element> elements = new ArrayList<Element>();

	public Detail(Document document) {
		this.document = document;
	}

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Detail D_addText(String text) {
		DocumentHelper.add(document, DocumentHelper.createText(text));
		return this;
	}

	public Detail D_addText(String text, TextStyleClass styleClass) {
		DocumentHelper.add(document, DocumentHelper.createText(text, styleClass));
		return this;
	}

	public Detail D_addBlankLine() {
		DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Detail D_addImage(String imageName) {
		DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Detail D_addSeparator() {
		DocumentHelper.add(document, DocumentHelper.createDefaultSeparator());
		return this;
	}

}
