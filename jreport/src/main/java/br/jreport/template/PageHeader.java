package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextPageHeaderStyleClass;
import br.jreport.style.DefaultTextTitleStyleClass;

public class PageHeader {

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
	 *  addPageHeader(new PageHeader().H_addBrasao());
	 * </pre>
	 * </b>
	 **/
	public PageHeader H_addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		elements.add(brasao);
		return this;
	}


	public PageHeader H_addTitle(String text) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));

		return this;
	}

	public PageHeader H_addTitle(String text, DefaultTextPageHeaderStyleClass titleStyleClass) {
		elements.add(DocumentHelper.createText(text, titleStyleClass));
		return this;
	}

	/**
	 * Adiciona uma linha em branco
	 * 
	 */
	public PageHeader H_newLine() {
		elements.add(DocumentHelper.newLine());

		return this;
	}

	/**
	 * Adiciona uma imagem
	 * Deve-se passar o caminho do arquivo que contém a imagem
	 * 
	 * @param imageName:caminho da imagem a ser adicionada
	 * 
	 */
	public PageHeader H_addImage(String imageName) {
		elements.add(DocumentHelper.loadImage(imageName));
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * 
	 */
	public PageHeader H_addSeparator() {
		elements.add(DocumentHelper.createDefaultSeparator());
		return this;
	}

	protected List<Element> getElements() {
		return elements;
	}






	
	

}
