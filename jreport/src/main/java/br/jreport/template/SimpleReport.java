package br.jreport.template;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import br.jreport.core.DataModelReport;
import br.jreport.core.DocumentTitle;
import br.jreport.core.TextStyleClass;
import br.jreport.enums.ColorJReport;
import br.jreport.enums.PageOrientation;
import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextTitleStyleClass;
import br.jreport.style.TableHeaderStyleClass;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableBody;
import br.jreport.table.TableHeader;

public class SimpleReport extends PdfPageEventHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Document document;
	
	protected DocumentTitle title;

	protected PdfWriter pdfWriter;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	private int pagenumber = 1;

	public SimpleReport() {
		super();
		this.document = new Document(PageOrientation.PORTRAIT.getValue());
		this.title = new DocumentTitle(document);
	}

	public SimpleReport(PageOrientation pageOrientation) {
		super();
		this.document = new Document(pageOrientation.getValue());
		this.title = new DocumentTitle(document);
	}

	/**
	 * This section appears only once at the beginning of the report.
	 */
	protected void title() {

	}

	/**
	 * This section appears at the beginning of each page in the generated
	 * document.
	 */
	protected void pageHeader() {

	}

	/**
	 * This section is repeated for each line of data supplied by the report's
	 * data source. The detail section can be made of multiple bands.
	 */
	protected void detail() {

	}

	/**
	 * This section appears at the bottom of each page.
	 */
	protected void pageFooter() {

	}

	/**
	 * This section appears only once at the end of the report.
	 */
	protected void summary() {

	}

	public void generate(OutputStream outputStream) {
		try {
			this.pdfWriter = PdfWriter.getInstance(document, outputStream);
			document.open();
			pdfWriter.setPageEvent(this);
			this.title();
			newLine();
			this.detail();
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public ByteArrayInputStream generate() {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			this.pdfWriter = PdfWriter.getInstance(document, outputStream);
			document.open();
			pdfWriter.setPageEvent(this);
			this.title();
			newLine();
			this.detail();
			document.close();
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Document getDocument() {
		return document;
	}

	protected void addBrasao() {
		Image brasao = DocumentHelper.loadImage("brasao.png");
		brasao.setAlignment(Image.ALIGN_CENTER);
		brasao.scaleAbsolute(40f, 40f);
		try {
			document.add(brasao);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	protected <T extends DataModelReport> void addTitle(DocumentTitle tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createDataTable(modelList, headers, tableBody).getPdfPTable());
	}
	

	protected void newLine() {
		DocumentHelper.add(getDocument(), DocumentHelper.newLine());
	}

	protected void newPage() {
		DocumentHelper.newPage(getDocument());
	}

	protected void addText(String text) {
		DocumentHelper.add(getDocument(), DocumentHelper.createText(text));
	}

	protected void addText(String text, TextStyleClass styleClass) {
		DocumentHelper.add(getDocument(), DocumentHelper.createText(text, styleClass));
	}

	protected void addTitle(String text) {
		DocumentHelper.add(getDocument(), DocumentHelper.createText(text, titleStyleClass));
	}

	protected void addImage(String imageName) {
		DocumentHelper.add(getDocument(), DocumentHelper.loadImage(imageName));
	}

	protected void addSeparator() {
		DocumentHelper.add(getDocument(), DocumentHelper.createDefaultSeparator());
	}

	protected <T extends DataModelReport> void addDataTable(List<T> modelList, TableHeader[] headers, DataTableBody<T> tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createDataTable(modelList, headers, tableBody).getPdfPTable());
	}

	protected <T extends DataModelReport> void addDataTable(List<T> modelList, String[] headers, DataTableBody<T> tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createDataTable(modelList, headers, tableBody).getPdfPTable());
	}

	protected <T extends DataModelReport> void addDataTable(List<T> modelList, int numColumns, DataTableBody<T> tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createDataTable(modelList, numColumns, tableBody).getPdfPTable());
	}

	protected void addTable(String[] headers, TableBody tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createTable(headers, tableBody).getPdfPTable());
	}

	protected void addTable(int numColumns, TableBody tableBody) {
		DocumentHelper.add(getDocument(), DocumentHelper.createTable(numColumns, tableBody).getPdfPTable());
	}

	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		pagenumber++;
		if (this.document.isOpen()) {
			pageHeader();
		}
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		this.document = document;
		pageFooter();
		Font font = new Font(Font.HELVETICA, 8f);
		font.setColor(Color.DARK_GRAY);
		float xRight = document.right();
		float xLeft = document.left() + document.leftMargin();
		float y = document.bottom();
		String now = new SimpleDateFormat("dd/MM/yyyy HH:ss").format(new Date());

		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format("%d", pagenumber), font),
				xRight, y, 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format("Gerado em %s ", now), font),
				xLeft, y, 0);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * 
	 **/
	protected static TableHeader th(String nome) {
		return new TableHeader(nome);
	}
	
	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param nome: 
	 * 			  Estilo para o datatable
	 * 
	 **/
	protected static TableHeader th(String nome, TableHeaderStyleClass style) {
		return new TableHeader(nome, style);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * 
	 **/
	@Deprecated
	protected static TableHeader th(String nome, float width) {
		return new TableHeader(nome, width);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * 
	 **/
	@Deprecated
	protected static TableHeader th(String nome, float width, int colspan) {
		return new TableHeader(nome, width, colspan);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * @param backgroundTableColor
	 * 
	 **/
	@Deprecated
	protected static TableHeader th(String nome, float width, int colspan, ColorJReport backgroundTableColor) {
		return new TableHeader(nome, width, colspan, backgroundTableColor);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * @param backgroundTableColor
	 * @param borderTableColor
	 * 
	 **/
	@Deprecated
	protected static TableHeader th(String nome, float width, int colspan, ColorJReport backgroundTableColor,
			ColorJReport borderTableColor) {
		return new TableHeader(nome, width, colspan, backgroundTableColor, borderTableColor);
	}

}
