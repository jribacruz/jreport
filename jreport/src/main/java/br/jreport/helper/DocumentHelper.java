package br.jreport.helper;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.draw.LineSeparator;

import br.jreport.core.DataModelReport;
import br.jreport.enums.TextDecoration;
import br.jreport.style.ImageStyleClass;
import br.jreport.style.TableDataStyleClass;
import br.jreport.style.TextStyleClass;
import br.jreport.style.defined.DefaultTextStyleClass;
import br.jreport.table.TableConstructor;
import br.jreport.table.TableHeader;

public class DocumentHelper {

	/**
	 * 
	 * @return
	 */
	public static Chunk newLine() {
		return Chunk.NEWLINE;
	}

	public static void newPage(Document document) {
		document.newPage();
	}

	private static Paragraph setupText(String text, TextStyleClass styleClass) {
		text = text == null || text.isEmpty() ? " " : text;

		Font f = new Font(Font.HELVETICA);
		f.setSize(styleClass.getFontSize());
		f.setStyle(styleClass.getFontStyle().getValue());
		f.setColor(styleClass.getFontColor());

		Chunk chunk = new Chunk(text, f);
		if (styleClass.getTextDecoration() != TextDecoration.NONE) {
			chunk.setUnderline(styleClass.getTextDecoration().getThick(), styleClass.getTextDecoration().getY());
		}
//@formatter:off
//		if (styleClass.getBackgroudColor() != null) {
//		chunk.setBackground(styleClass.getBackgroudColor());
// (TODO implementação para background color de texto deve passar também o tamanho do retangulo 
//		para não ficar estranho, como atualmente fica) 
//		chunk.setBackground(color, extraLeft, extraBottom, extraRight, extraTop)
//		}@
//formatter:on
		Paragraph p = new Paragraph(chunk);
		p.setFirstLineIndent(styleClass.getTextIndent());
		p.setIndentationLeft(styleClass.getMarginLeft());
		p.setAlignment(styleClass.getTextAlign().getValue());

		return p;
	}

	public static void createPdfPCell(Paragraph p, TableDataStyleClass styleClass, PdfPTable pdfPTable) {
		PdfPCell cell = new PdfPCell();
		cell.addElement(p);
		if (styleClass.getHeight() !=null) {
			cell.setFixedHeight(styleClass.getHeight());
		}
		cell.setHorizontalAlignment(styleClass.getHorizontalAlignment());
		cell.setVerticalAlignment(styleClass.getVerticalAlignment());
		cell.setBorderColor(styleClass.getBorderColor());
		cell.setColspan(styleClass.getColspan());
		cell.setBackgroundColor(styleClass.getBackgroundCellColor());

		pdfPTable.addCell(cell);

	}

	public static PdfPCell createPdfPCell(Paragraph p, TableDataStyleClass styleClass) {
		PdfPCell cell = new PdfPCell();
		cell.addElement(p);
		if (styleClass.getHeight() !=null) {
			cell.setFixedHeight(styleClass.getHeight());
		}
		cell.setHorizontalAlignment(styleClass.getHorizontalAlignment());
		cell.setVerticalAlignment(styleClass.getVerticalAlignment());
		cell.setBorderWidth(styleClass.getBorderWidth());
		cell.setBorderColor(styleClass.getBorderColor());
		cell.setColspan(styleClass.getColspan());
		cell.setBackgroundColor(styleClass.getBackgroundCellColor());
		return cell;
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public static Paragraph createText(String text) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		return setupText(text, styleClass);
	}

	public static Paragraph createText(String text, TextStyleClass styleClass) {
		return setupText(text, styleClass);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static Paragraph createText(BigDecimal number) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(BigDecimal number, TextStyleClass styleClass) {
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static Paragraph createText(Long number) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Long number, TextStyleClass styleClass) {
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static Paragraph createText(Integer number) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Integer number, TextStyleClass styleClass) {
		String text = String.valueOf(number);
		return setupText(text, styleClass);
	}

	/**
	 * 
	 * @param bool
	 * @return
	 */
	public static Paragraph createText(Boolean bool) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = String.valueOf(bool);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Boolean bool, TextStyleClass styleClass) {
		String text = String.valueOf(bool);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Boolean bool, String expTrue, String expFalse) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = bool ? expTrue : expFalse;
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Boolean bool, String expTrue, String expFalse, TextStyleClass styleClass) {
		String text = bool ? expTrue : expFalse;
		return setupText(text, styleClass);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Paragraph createText(Date date) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = new SimpleDateFormat("dd/MM/yyyy").format(date);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Date date, TextStyleClass styleClass) {
		String text = new SimpleDateFormat("dd/MM/yyyy").format(date);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Date date, String pattern) {
		DefaultTextStyleClass styleClass = new DefaultTextStyleClass();
		String text = new SimpleDateFormat(pattern).format(date);
		return setupText(text, styleClass);
	}

	public static Paragraph createText(Date date, String pattern, TextStyleClass styleClass) {
		String text = new SimpleDateFormat(pattern).format(date);
		return setupText(text, styleClass);
	}

	public static Image loadImage(Image image) {
		ImageStyleClass style = new ImageStyleClass();
		image.setAlignment(style.getAlign().getValue());
		return null;
	}
	
	public static Image loadImage(String imageName) {
		try {
			URL imageURL = DocumentHelper.class.getClassLoader().getResource(imageName);
			Image image = Image.getInstance(imageURL);
			ImageStyleClass style = new ImageStyleClass();
			image.setAlignment(style.getAlign().getValue());
			return image;
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Image loadImage(String imageName, ImageStyleClass style) {
		try {
			URL imageURL = DocumentHelper.class.getClassLoader().getResource(imageName);
			Image image = Image.getInstance(imageURL);
			
			image.setAlignment(style.getAlign().getValue());
			if (style.getHeight() != null) {
				image.scaleAbsoluteHeight(style.getHeight());
			}
			if (style.getWidth() != null) {
				image.scaleAbsoluteWidth(style.getWidth());
			}
			
			return image;
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Chunk createDefaultSeparator() {
		LineSeparator separator = new LineSeparator();
		separator.setLineWidth(0.1f);
		Chunk linebreak = new Chunk(separator);
		return linebreak;
	}

	public static <T extends DataModelReport> TableConstructor<T> createDataTable(TableHeader[] headers, List<PdfPCell> cells) {
		TableConstructor<T> table = new TableConstructor<T>(headers);
		table.addBody(cells);
		return table;
	}

	public static <T extends DataModelReport> TableConstructor<T> createDataTable(String[] headers, List<PdfPCell> cells) {
		TableConstructor<T> table = new TableConstructor<T>(headers);
		table.addBody(cells);
		return table;
	}

	public static <T extends DataModelReport> TableConstructor<T> createDataTable(int headers, List<PdfPCell> cells) {
		TableConstructor<T> table = new TableConstructor<T>(headers);
		table.addBody(cells);
		return table;
	}

	public static void add(Document document, Element element) {
		try {
			document.add(element);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
