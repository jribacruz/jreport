package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.defined.DefaultTextPageHeaderStyleClass;
import br.jreport.style.defined.DefaultTextTitleStyleClass;

public class PageHeader {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	public PageHeader(Document document) {
		this.document = document;
	}

	/**
	 * Adiciona o Brasão da República <br>
	 * Não é necessário passar o caminho do arquivo que contém o Brasão. <br>
	 * O arquivo do brasão já esta definido em /src/main/resources do próprio
	 * Jreport <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * addPageHeader(new PageHeader().H_addBrasao());
	 * </pre>
	 * 
	 * </b>
	 **/
	public PageHeader addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		elements.add(brasao);
		return this;
	}

	public PageHeader addTitle(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public PageHeader addTitle(String text, DefaultTextPageHeaderStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 */
	public PageHeader newLine() {
		elements.add(DocumentHelper.newLine());
		return this;
	}

	/**
	 * Adiciona uma imagem Deve-se passar o caminho do arquivo que contém a
	 * imagem
	 * 
	 * @param imageName:caminho
	 *            da imagem a ser adicionada
	 * 
	 */
	public PageHeader addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 */
	public PageHeader addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		return this;
	}

	public void build() {
		for (Element element : getElements()) {
			DocumentHelper.add(document, element);
		}
	}

	protected List<Element> getElements() {
		return elements;
	}

}
