package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;
import br.jreport.style.TextStyleClass;
import br.jreport.style.defined.DefaultTextPageFooterStyleClass;

public class PageFooter extends JReportElement {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	protected final DefaultTextPageFooterStyleClass footerStyleClass = new DefaultTextPageFooterStyleClass();

	public PageFooter(Document document) {
		this.document = document;
	}

	public ColspanLine addColspanLine() {
		return new ColspanLine(document);
	}

	/**
	 * Adiciona um Footer <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * pf.addFooter("Rodapé pagina").build();
	 * </pre>
	 * 
	 * </b>
	 **/
	public PageFooter addFooter(String text) {
		elements.add(DocumentHelper.createText(text, footerStyleClass));
		return this;
	}

	public PageFooter addFooter(String text, DefaultTextPageFooterStyleClass footerStyleClass) {
		elements.add(DocumentHelper.createText(text, footerStyleClass));
		return this;
	}

	public PageFooter addFooter(String text, String footerStyleClass) {
		TextStyleClass style = new TextStyleClass(footerStyleClass);
		elements.add(DocumentHelper.createText(text, style));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 * <pre>
	 * pf.addNewLine().build();
	 * </pre>
	 */
	public PageFooter newLine() {
		elements.add(DocumentHelper.newLine());
		return this;
	}

	/**
	 * Adiciona uma imagem <br>
	 * Deve-se passar o caminho do arquivo que contém a imagem <br>
	 * <br>
	 * AO arquivo da imagem deve estar em src/main/resources
	 * 
	 * <pre>
	 * pf.addImage("ok.jpg").build();
	 * </pre>
	 * 
	 */
	public PageFooter addImage(String imageName) {
		Image brasao = DocumentHelper.loadImage(imageName);
		brasao.setAlignment(Image.ALIGN_CENTER);
		elements.add(brasao);
		return this;
	}

	public PageFooter addImage(String imageName, ImageStyleClass style) {
		Image brasao = DocumentHelper.loadImage(imageName, style);
		elements.add(brasao);
		return this;
	}

	public PageFooter addImage(String imageName, String style) {
		ImageStyleClass styleClass = new ImageStyleClass(style);
		Image brasao = DocumentHelper.loadImage(imageName, styleClass);
		elements.add(brasao);
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 * <pre>
	 * pf.addSeparator().build();
	 * </pre>
	 * 
	 */
	public PageFooter addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		return this;
	}

	protected Element buildElement() {
		Element retorno = getElements().get(0);
		elements = new ArrayList<Element>();
		return retorno;
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
