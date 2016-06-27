package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Element;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TextStyleClass;

public class Component {

	private List<Element> elements = new ArrayList<Element>();

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Component C_addText(String text) {
		elements.add(DocumentHelper.createText(text));
		// DocumentHelper.add(document, DocumentHelper.createText(text));
		return this;
	}

	public Component C_addText(String text, TextStyleClass styleClass) {
		elements.add(DocumentHelper.createText(text, styleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// styleClass));
		return this;
	}

	public Component C_addBlankLine() {
		elements.add(DocumentHelper.newLine());
		// DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Component C_addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		// DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Component C_addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		// DocumentHelper.add(document,
		// DocumentHelper.createDefaultSeparator());
		return this;
	}

	protected List<Element> getElements() {
		return elements;
	}

}
