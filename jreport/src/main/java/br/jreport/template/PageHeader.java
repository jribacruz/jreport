package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;
import br.jreport.style.TextStyleClass;
import br.jreport.style.defined.DefaultTextPageHeaderStyleClass;

public class PageHeader extends JReportElement {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	protected final DefaultTextPageHeaderStyleClass titleStyleClass = new DefaultTextPageHeaderStyleClass();

	public PageHeader(Document document) {
		this.document = document;
	}

	public ColspanLine addColspanLine() {
		return new ColspanLine(document);
	}

	/**
	 * Adiciona um Título <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * ph.addPageHeader("Resumo por Zona").build();
	 * </pre>
	 * 
	 * </b>
	 **/
	public PageHeader addPageHeader(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public PageHeader addPageHeader(String text, DefaultTextPageHeaderStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public PageHeader addPageHeader(String text, String titleStyleClass) {
		TextStyleClass style = new TextStyleClass(titleStyleClass);
		elements.add(DocumentHelper.createText(text, style));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 * <pre>
	 * ph.addNewLine().build();
	 * </pre>
	 */
	public PageHeader addNewLine() {
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
	 * ph.addImage("ok.jpg").build();
	 * </pre>
	 * 
	 */
	public PageHeader addImage(String imageName) {
		Image brasao = DocumentHelper.loadImage(imageName);
		brasao.setAlignment(Image.ALIGN_CENTER);
		elements.add(brasao);
		return this;
	}

	public PageHeader addImage(String imageName, ImageStyleClass style) {
		Image brasao = DocumentHelper.loadImage(imageName, style);
		elements.add(brasao);
		return this;
	}

	public PageHeader addImage(String imageName, String style) {
		ImageStyleClass styleClass = new ImageStyleClass(style);
		Image brasao = DocumentHelper.loadImage(imageName, styleClass);
		elements.add(brasao);
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 * <pre>
	 * ph.addSeparator().build();
	 * </pre>
	 * 
	 */
	public PageHeader addSeparator() {
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
