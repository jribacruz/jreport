package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.defined.DefaultTextTitleStyleClass;

public class Title {

	private List<Element> elements = new ArrayList<Element>();

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	/**
	 * Adiciona o Brasão da República
	 * <br>
	 * Não é necessário passar o caminho do arquivo que contém o Brasão.
	 * <br>
	 * O arquivo do brasão já esta definido em /src/main/resources do
	 * próprio Jreport
	 * <br>
	 * <b>
	 * Exemplo:
	 * <pre>
	 *  addTitle(new Title().T_addBrasao());
	 * </pre>
	 * </b>
	 **/
	public Title T_addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		// DocumentHelper.add(document, brasao);
		elements.add(brasao);
		return this;
	}

	/**
	 * Adiciona um Título <br>
	 * <b>
	 * Exemplo:
	 * <pre>
	 *  addTitle(new Title().T_addTitle("Relatório Geral");
	 * </pre>
	 * </b>
	 **/
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

	/**
	 * Adiciona uma linha em branco
	 * 
	 */
	public Title T_newLine() {
		elements.add(DocumentHelper.newLine());
		// DocumentHelper.add(document, DocumentHelper.newLine());
		return this;
	}

	/**
	 * Adiciona uma imagem
	 * Deve-se passar o caminho do arquivo que contém a imagem
	 * 
	 * @param imageName:caminho da imagem a ser adicionada
	 * 
	 */
	public Title T_addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		// DocumentHelper.add(document, DocumentHelper.loadImage(imageName));
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 */
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
