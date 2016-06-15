package br.jreport.executaveis;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
 
public class BorderTest {
    public static final String DEST = "target/colored_border.pdf";
 
    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new BorderTest().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table;
        table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Cell 1"));
        cell.setUseVariableBorders(true);
        cell.setBorderColorTop(Color.RED);
        cell.setBorderColorBottom(Color.BLUE);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell 2"));
        cell.setBorderColorLeft(Color.GREEN);
        cell.setBorderColorTop(Color.YELLOW);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell 3"));
        cell.setUseVariableBorders(true);
        cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
        cell.setBorderColorLeft(Color.RED);
        cell.setBorderColorBottom(Color.BLUE);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell 4"));
        cell.setBorder(Rectangle.LEFT | Rectangle.TOP);
        cell.setBorderColorLeft(Color.GREEN);
        cell.setBorderColorTop(Color.YELLOW);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
 
}