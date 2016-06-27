package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextTitleStyleClass;

public class Title {

	private List<Element> elements = new ArrayList<Element>();

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Title T_addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		// DocumentHelper.add(document, brasao);
		elements.add(brasao);
		return this;
	}

	public Title T_addTitle(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// titleStyleClass));
		return this;
	}

	public Title T_addTitle(String text, DefaultTextTitleStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// titleStyleClass));
		return this;
	}

	public Title T_newLine() {
		elements.add(DocumentHelper.newLine());
		// DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Title T_addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		// DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Title T_addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		// DocumentHelper.add(document,
		// DocumentHelper.createDefaultSeparator());
		return this;
	}

	protected List<Element> getElements() {
		return elements;
	}

}
