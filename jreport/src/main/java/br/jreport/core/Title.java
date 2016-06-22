package br.jreport.core;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextTitleStyleClass;

public class Title {

	private Document document;

	protected List<Element> elements = new ArrayList<Element>();

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	public Title(Document document) {
		this.document = document;
	}

	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods
	 * 
	 **/
	public Title TM_addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		DocumentHelper.add(document, brasao);
		return this;
	}

	public Title TM_addTitle(String text) {
		DocumentHelper.add(document, DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public Title TM_addTitle(String text, DefaultTextTitleStyleClass titleStyleClass) {
		DocumentHelper.add(document, DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public Title TM_newLine() {
		DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	public Title TM_addImage(String imageName) {
		DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	public Title TM_addSeparator() {
		DocumentHelper.add(document, DocumentHelper.createDefaultSeparator());
		return this;
	}

}
