package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;
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
		return this;
	}

	public Elemento addText(String text, TextStyleClass styleClass) {
		elements.add(DocumentHelper.createText(text, styleClass));
		return this;
	}

	public Elemento addText(String text, String styleClass) {
		TextStyleClass style = new TextStyleClass(styleClass);
		elements.add(DocumentHelper.createText(text, style));
		return this;
	}

	public Elemento addBlankLine() {
		elements.add(DocumentHelper.newLine());
		return this;
	}

	public Elemento addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		return this;
	}

	public Elemento addImage(String imageName, ImageStyleClass style) {
		Image brasao = DocumentHelper.loadImage(imageName, style);
		elements.add(brasao);
		return this;
	}

	public Elemento addImage(String imageName, String style) {
		ImageStyleClass styleClass = new ImageStyleClass(style);
		Image brasao = DocumentHelper.loadImage(imageName, styleClass);
		elements.add(brasao);
		return this;
	}

	public Elemento addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
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
