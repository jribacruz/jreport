package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;
import br.jreport.style.TextStyleClass;
import br.jreport.style.defined.DefaultTextTitleStyleClass;

public class Title {

	private List<Element> elements = new ArrayList<Element>();

	private Document document;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	public Title(Document document) {
		this.document = document;
	}

//	/**
//	 * Adiciona o Brasão da República <br>
//	 * Não é necessário passar o caminho do arquivo que contém o Brasão. <br>
//	 * O arquivo do brasão já esta definido em /src/main/resources do próprio
//	 * Jreport <br>
//	 * <b> Exemplo:
//	 * 
//	 * <pre>
//	 * t.addBrasao().build();
//	 * </pre>
//	 * 
//	 * </b>
//	 **/
//	public Title addBrasao() {
//		Image brasao = DocumentHelper.loadImage("brasao.png");
//		brasao.setAlignment(Image.ALIGN_CENTER);
//		brasao.scaleAbsolute(40f, 40f);
//		elements.add(brasao);
//		return this;
//	}

	/**
	 * Adiciona um Título <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * t.addBrasao().addTitle("Relatório de Pontos").build();
	 * </pre>
	 * 
	 * </b>
	 **/
	public Title addTitle(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public Title addTitle(String text, DefaultTextTitleStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	public Title addTitle(String text, String titleStyleClass) {
		TextStyleClass style = new TextStyleClass(titleStyleClass);
		elements.add(DocumentHelper.createText(text, style));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 * <pre>
	 * t.addNewLine().build();
	 * </pre>
	 */
	public Title addNewLine() {
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
	 * t.addImage("ok.jpg").build();
	 * </pre>
	 * 
	 * Obs: Para adiciona o Brasão da República, passar string "brasao-republica" <br>
	 * 
	 */
	public Title addImage(String imageName) {
		if (imageName.trim().toLowerCase().startsWith("brasao-republica")) {
			Image brasao = DocumentHelper.loadImage("brasao-republica.png");
			brasao.setAlignment(Image.ALIGN_CENTER);
			brasao.scaleAbsolute(40f, 40f);
			elements.add(brasao);
		} else {
			Image brasao = DocumentHelper.loadImage(imageName);
			brasao.setAlignment(Image.ALIGN_CENTER);
			elements.add(brasao);
		}
		return this;
	}

	public Title addImage(String imageName, ImageStyleClass style) {
		Image brasao = DocumentHelper.loadImage(imageName, style);
		elements.add(brasao);
		return this;
	}

	public Title addImage(String imageName, String style) {
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
	public Title addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		return this;
	}

	/**
	 * O método build é o responsável por ler os elementos do <b>Title</b> e
	 * acrescentá-los ao documento <br>
	 * <br>
	 * O padrão Builder é muito útil quando lidamos com a construção de objetos
	 * complexos, com construtores que requerem muitos parâmetros ou com
	 * múltiplos construtores.
	 * 
	 * <pre>
	 * t.addBrasao().addTitle("Relatório de Pontos").build();
	 * </pre>
	 * 
	 */
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
