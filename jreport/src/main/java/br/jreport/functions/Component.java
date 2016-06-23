package br.jreport.functions;

import com.lowagie.text.Document;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TextStyleClass;

public class Component {

	private Document document;

	public Component(Document document) {
		this.document = document;
	}

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Component C_addText(String text) {
		DocumentHelper.add(document, DocumentHelper.createText(text));
		return this;
	}

	public Component C_addText(String text, TextStyleClass styleClass) {
		DocumentHelper.add(document, DocumentHelper.createText(text, styleClass));
		return this;
	}

	public Component C_addBlankLine() {
		DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Component C_addImage(String imageName) {
		DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Component C_addSeparator() {
		DocumentHelper.add(document, DocumentHelper.createDefaultSeparator());
		return this;
	}

}
