package br.jreport.template;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.helper.DocumentHelper;
import br.jreport.style.defined.DefaultTextPageHeaderStyleClass;
import br.jreport.style.defined.DefaultTextTitleStyleClass;

/**
 * 
 * @author amarques
 *
 */
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
	 * ph.addBrasao().build();
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

	/**
	 * Adiciona um Título <br>
	 * <b> Exemplo:
	 * 
	 * <pre>
	 * ph.addTitle("Resumo por Zona").build();
	 * </pre>
	 * 
	 * </b>
	 **/
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
		elements.add(DocumentHelper.loadImage(imageName));
		return this;
	}

	/**
	 * Adiciona uma barra horrizontal
	 * <pre>
	 *     ph.addSeparator().build();
	 * </pre>
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
