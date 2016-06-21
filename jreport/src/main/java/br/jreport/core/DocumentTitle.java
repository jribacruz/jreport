package br.jreport.core;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextTitleStyleClass;

public abstract class DocumentTitle {

	protected Document document;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();
	
	protected abstract void body(DocumentTitle title);

	public DocumentTitle(Document document) {
		this.document = document;

	}
	
	/**
	 * 
	 * @return This Builder object to allow for chaining of calls to set methods 
	 * 
	 * **/
	public DocumentTitle DT_addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		try {
			document.add(brasao);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DocumentTitle DT_addTitle(String text) {
		DocumentHelper.add(document, DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

}
