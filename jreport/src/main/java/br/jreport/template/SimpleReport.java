package br.jreport.template;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import br.jreport.enums.PageOrientation;
import br.jreport.helper.DocumentHelper;
import br.jreport.style.DefaultTextTitleStyleClass;
import br.jreport.style.TableHeaderStyleClass;
import br.jreport.table.TableHeader;

public abstract class SimpleReport extends PdfPageEventHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Document document;

	protected PdfWriter pdfWriter;

	protected final DefaultTextTitleStyleClass titleStyleClass = new DefaultTextTitleStyleClass();

	private int pagenumber = 1;

	public SimpleReport() {
		super();
		this.document = new Document(PageOrientation.PORTRAIT.getValue());
	}

	public SimpleReport(PageOrientation pageOrientation) {
		super();
		this.document = new Document(pageOrientation.getValue());
	}

	/**
	 *
	 * Será mostrado apenas na primeira página do relatório <br>
	 * <b>Exemplo:
	 * 
	 * <pre>
	 *  addTitle(new Title().T_addTitle("Relatório Geral");
	 * </pre>
	 * 
	 * </b>
	 */
	protected abstract void title();

	/**
	 * Será mostrado apenas a partir da segunda página do relatório <br>
	 * <b>Exemplo:
	 * 
	 * <pre>
	 * addPageHeader(new PageHeader().H_addTitle("Título Mostrado a partir da 2º Página"));
	 * </pre>
	 * 
	 * </b>
	 */
	protected abstract void pageHeader();

	/**
	 * This section is repeated for each line of data supplied by the report's
	 * data source. The detail section can be made of multiple bands.
	 */
	protected abstract void detail();

	/**
	 * This section appears at the bottom of each page.
	 */
	protected abstract void pageFooter();

	/**
	 * This section appears only once at the end of the report.
	 */
	protected abstract void summary();

	public void generate(OutputStream outputStream) {
		try {
			this.pdfWriter = PdfWriter.getInstance(document, outputStream);
			document.open();
			pdfWriter.setPageEvent(this);
			this.title();
			addNewLine();
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
			addNewLine();
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

	protected void addNewPage() {
		DocumentHelper.newPage(document);
	}

	protected void addNewLine() {
		DocumentHelper.add(document, DocumentHelper.newLine());
	}

	protected void addTitle(Title title) {
		for (Element element : title.getElements()) {
			DocumentHelper.add(document, element);
		}
	}

	protected void addPageHeader(PageHeader pageHeader) {
		for (Element element : pageHeader.getElements()) {
			DocumentHelper.add(document, element);
		}
	}

	protected void addComponent(Component componente) {
		for (Element element : componente.getElements()) {
			DocumentHelper.add(document, element);
		}
	}

	protected void addDataTable(DataTable dataTable) {
		if (dataTable.getHeadersObject() != null) {
			DocumentHelper.add(document, DocumentHelper.createDataTable(dataTable.getHeadersObject(), dataTable.getCells()).getPdfPTable());
		} else if (dataTable.getHeadersString() != null) {
			DocumentHelper.add(document, DocumentHelper.createDataTable(dataTable.getHeadersString(), dataTable.getCells()).getPdfPTable());
		} else if (dataTable.getHeadersColspan() != null) {
			DocumentHelper.add(document,
					DocumentHelper.createDataTable(dataTable.getHeadersColspan(), dataTable.getCells()).getPdfPTable());
		}
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
	 *            Estilo para o datatable
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
	protected static TableHeader th(String nome, float width, int colspan, Color backgroundTableColor) {
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
	protected static TableHeader th(String nome, float width, int colspan, Color backgroundTableColor, Color borderTableColor) {
		return new TableHeader(nome, width, colspan, backgroundTableColor, borderTableColor);
	}

}
