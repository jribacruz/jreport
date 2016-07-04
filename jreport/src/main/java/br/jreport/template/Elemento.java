package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TextStyleClass;

public class Elemento {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	public Elemento(Document document) {
		this.document = document;
	}

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Elemento addText(String text) {
		elements.add(DocumentHelper.createText(text));
		// DocumentHelper.add(document, DocumentHelper.createText(text));
		return this;
	}

	public Elemento addText(String text, TextStyleClass styleClass) {
		elements.add(DocumentHelper.createText(text, styleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// styleClass));
		return this;
	}

	public Elemento addBlankLine() {
		elements.add(DocumentHelper.newLine());
		// DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Elemento addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		// DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Elemento addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		// DocumentHelper.add(document,
		// DocumentHelper.createDefaultSeparator());
		return this;
	}

	public void build() {
		for (Element element : getElements()) {
			DocumentHelper.add(document, element);
		}
		elements = new ArrayList<Element>();
	}

	protected List<Element> getElements() {
		return elements;
	}

}
