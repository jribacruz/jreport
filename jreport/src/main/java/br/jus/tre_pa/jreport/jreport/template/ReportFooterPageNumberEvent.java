package br.jus.tre_pa.jreport.jreport.template;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class ReportFooterPageNumberEvent extends PdfPageEventHelper {
	/** Current page number (will be reset for every chapter). */
	int pagenumber = 1;

	/**
	 * Increase the page number.
	 * 
	 * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(com.itextpdf.text.pdf.PdfWriter,
	 *      com.itextpdf.text.Document)
	 */
	public void onStartPage(PdfWriter writer, Document document) {
		pagenumber++;
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {

		Font font = new Font(Font.HELVETICA, 8f);
		font.setColor(Color.DARK_GRAY);
		float xRight = document.right();
		float xLeft = document.left() + document.leftMargin();
		float y = document.bottomMargin();
		String now = new SimpleDateFormat("dd/MM/yyyy HH:ss").format(new Date());
		
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format("%d", pagenumber), font),
				xRight, y, 0);
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format("Gerado em %s ", now), font),
				xLeft, y, 0);
	}
}
