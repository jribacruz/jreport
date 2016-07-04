package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.TextStyleClass;
import br.jreport.style.defined.DefaultTextTitleStyleClass;

public class Title {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	public Title(Document document) {
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
	 * addTitle(new Title().T_addBrasao());
	 * </pre>
	 * 
	 * </b>
	 **/
	public Title addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		// DocumentHelper.add(document, brasao);
		elements.add(brasao);
		return this;
	}

	/**
	 * Adiciona um Título <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 *  addTitle(new Title().T_addTitle("Relatório Geral");
	 * </pre>
	 * 
	 * </b>
	 **/
	public Title addTitle(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// titleStyleClass));
		return this;
	}

	public Title addTitle(String text, DefaultTextTitleStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// titleStyleClass));
		return this;
	}
	
	public Title addTitle(String text, String titleStyleClass) {
		TextStyleClass style = new TextStyleClass(titleStyleClass);
		elements.add(DocumentHelper.createText(text, style));
		// DocumentHelper.add(document, DocumentHelper.createText(text,
		// titleStyleClass));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 */
	public Title newLine() {
		elements.add(DocumentHelper.newLine());
		// DocumentHelper.add(document, DocumentHelper.newLine());
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
	public Title addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		// DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 */
	public Title addSeparator() {
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
