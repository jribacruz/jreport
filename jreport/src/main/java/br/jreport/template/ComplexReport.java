package br.jreport.template;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

import br.jreport.core.ComplexDataModelReport;
import br.jreport.core.ComplexModelFactory;
import br.jreport.core.DataModelReport;
import br.jreport.enums.PageOrientation;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class ComplexReport<T extends DataModelReport> extends SimpleReport {

	private List<ComplexReport<T>> pdfs = new ArrayList<ComplexReport<T>>();
	private String nomePdf = "defaultNameReport";
	private List<T> modelList;
	private PageOrientation pageOrientation;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Class<ComplexReport<T>> type;

	public ComplexReport() {

	}

	public void nomeRelatorio() {
		new Elemento(getDocument()).addText(getNomePdf());
	}

	public ComplexReport(List<List<T>> lista, String nomeRelatorio, Class<? extends ComplexReport<T>> classe) {
		Integer cont = 1;
		try {
			this.type = (Class<ComplexReport<T>>) classe;
			Constructor ctor = type.getDeclaredConstructor();
			ctor.setAccessible(true);

			ComplexModelFactory<T> factory = new ComplexModelFactory<T>();
			List<ComplexModelFactory<T>> complexModelTest = (List<ComplexModelFactory<T>>) factory.factory(lista);
			for (ComplexDataModelReport<T> list : complexModelTest) {
				ComplexReport<T> cr = (ComplexReport<T>) ctor.newInstance();
				cr.setNomePdf(cont + " º" + nomeRelatorio);
				cr.pageOrientation = PageOrientation.PORTRAIT;
				cr.setModelListComplex(list.getModelReport());
				pdfs.add(cr);
				cont++;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public ComplexReport(List<List<T>> lista, String nomeRelatorio, PageOrientation pageOrientation,
			Class<? extends ComplexReport<T>> classe) {
		Integer cont = 1;
		try {
			this.type = (Class<ComplexReport<T>>) classe;
			Constructor ctor = type.getDeclaredConstructor();
			ctor.setAccessible(true);

			ComplexModelFactory<T> factory = new ComplexModelFactory<T>();
			List<ComplexModelFactory<T>> complexModelTest = (List<ComplexModelFactory<T>>) factory.factory(lista);
			for (ComplexDataModelReport<T> list : complexModelTest) {
				ComplexReport<T> cr = (ComplexReport<T>) ctor.newInstance();
				cr.setNomePdf(cont + "º" + nomeRelatorio);
				cr.pageOrientation = pageOrientation;
				cr.setModelListComplex(list.getModelReport());
				pdfs.add(cr);
				cont++;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public ComplexReport(LinkedHashMap<String, List<T>> lista, Class<? extends ComplexReport<T>> classe) {
		Integer cont = 1;
		try {
			this.type = (Class<ComplexReport<T>>) classe;
			Constructor ctor = type.getDeclaredConstructor();
			ctor.setAccessible(true);

			ComplexModelFactory<T> factory = new ComplexModelFactory<T>();
			List<ComplexModelFactory<T>> complexModelTest = (List<ComplexModelFactory<T>>) factory.factory(lista);
			for (ComplexDataModelReport<T> complexReport : complexModelTest) {
				ComplexReport<T> cr = (ComplexReport<T>) ctor.newInstance();
				nomeiaRelatorio(cont, complexReport, cr);
				cr.pageOrientation = PageOrientation.PORTRAIT;
				cr.setModelListComplex(complexReport.getModelReport());
				pdfs.add(cr);
				cont++;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public ComplexReport(LinkedHashMap<String, List<T>> lista, PageOrientation pageOrientation, Class<? extends ComplexReport<T>> classe) {
		Integer cont = 1;
		try {
			this.type = (Class<ComplexReport<T>>) classe;
			Constructor ctor = type.getDeclaredConstructor();
			ctor.setAccessible(true);

			ComplexModelFactory<T> factory = new ComplexModelFactory<T>();
			List<ComplexModelFactory<T>> complexModelTest = (List<ComplexModelFactory<T>>) factory.factory(lista);
			for (ComplexDataModelReport<T> complexReport : complexModelTest) {
				ComplexReport<T> cr = (ComplexReport<T>) ctor.newInstance();
				nomeiaRelatorio(cont, complexReport, cr);
				cr.pageOrientation = pageOrientation;
				cr.setModelListComplex(complexReport.getModelReport());
				pdfs.add(cr);
				cont++;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param nomeRelatorio
	 * @param cont
	 * @param complexReport
	 * @param sr
	 */
	private void nomeiaRelatorio(Integer cont, ComplexDataModelReport<T> complexReport, ComplexReport<T> sr) {
		if (complexReport.getNomePdf().isEmpty()) {
			sr.setNomePdf(cont + "º " + sr.getNomePdf());
		} else {
			sr.setNomePdf(complexReport.getNomePdf());
		}
	}

	public void generateMultiplePdf_ZipFile(String diretorio) throws FileNotFoundException {
		ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(zipOutputStream);
		for (int i = 0; i < pdfs.size(); i++) {
			try {
				ComplexReport<T> complexReport = pdfs.get(i);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				complexReport.document = new Document(complexReport.pageOrientation.getValue());
				complexReport.pdfWriter = PdfWriter.getInstance(complexReport.document, outputStream);
				complexReport.document.open();
				complexReport.pdfWriter.setPageEvent(this);
				complexReport.title(new Title(getDocument()));
				new Elemento(getDocument()).addBlankLine();
				complexReport.detail(new Detail(getDocument()));
				complexReport.document.close();
				inserirNoZip(zos, outputStream, complexReport);
			} catch (DocumentException e) {
				// e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ByteArrayInputStream generateMultiplePdf_ZipFile() {
		ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(zipOutputStream);
		try {
			for (int i = 0; i < pdfs.size(); i++) {
				ComplexReport<T> complexReport = pdfs.get(i);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				complexReport.document = new Document(complexReport.pageOrientation.getValue());
				complexReport.pdfWriter = PdfWriter.getInstance(complexReport.document, outputStream);
				complexReport.document.open();
				complexReport.pdfWriter.setPageEvent(this);
				complexReport.title(new Title(getDocument()));
				new Elemento(getDocument()).addBlankLine();
				complexReport.detail(new Detail(getDocument()));
				complexReport.document.close();
				inserirNoZip(zos, outputStream, complexReport);
			}

			zos.closeEntry();
			zos.close();

		} catch (DocumentException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return new ByteArrayInputStream(zipOutputStream.toByteArray());
	}

	/**
	 * @param zos
	 * @param outputStream
	 * @param complexReport
	 * @throws IOException
	 */
	private void inserirNoZip(ZipOutputStream zos, ByteArrayOutputStream outputStream, ComplexReport<T> complexReport) throws IOException {
		byte[] buffer = new byte[1024];
		ByteArrayInputStream inStream = new ByteArrayInputStream(outputStream.toByteArray());
		ZipEntry ze = new ZipEntry(complexReport.getNomePdf());
		zos.putNextEntry(ze);
		int len;
		while ((len = inStream.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}
		inStream.close();
	}

	public void generate(String diretorio) {
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(diretorio));
			ComplexReport<T> complexReport = pdfs.get(0);
			ComplexReport<T> complexReportAux;
			complexReport.document = new Document(complexReport.pageOrientation.getValue());
			complexReport.pdfWriter = PdfWriter.getInstance(complexReport.document, outputStream);
			complexReport.document.open();
			complexReport.pdfWriter.setPageEvent(this);
			complexReport.title(new Title(getDocument()));
			new Elemento(getDocument()).addBlankLine();
			complexReport.detail(new Detail(getDocument()));
			if (pdfs.size() > 1) {
				for (int i = 1; i < pdfs.size(); i++) {
					complexReportAux = pdfs.get(i);
					complexReportAux.pdfWriter = complexReport.pdfWriter;
					complexReportAux.document = complexReport.document;
					complexReportAux.addNewPage();
					complexReportAux.detail(new Detail(getDocument()));
				}
			}
			complexReport.document.close();
		} catch (DocumentException e) {
			// e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public ByteArrayInputStream generate() {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ComplexReport<T> complexReport = pdfs.get(0);
			ComplexReport<T> complexReportAux;

			complexReport.document = new Document(complexReport.pageOrientation.getValue());
			complexReport.pdfWriter = PdfWriter.getInstance(complexReport.document, outputStream);
			complexReport.document.open();
			complexReport.pdfWriter.setPageEvent(this);
			complexReport.title(new Title(getDocument()));
			new Elemento(getDocument()).addBlankLine();
			complexReport.detail(new Detail(getDocument()));
			if (pdfs.size() > 1) {
				for (int i = 1; i < pdfs.size(); i++) {
					complexReportAux = pdfs.get(i);
					complexReportAux.pdfWriter = complexReport.pdfWriter;
					complexReportAux.document = complexReport.document;
					complexReportAux.addNewPage();
					complexReportAux.detail(new Detail(getDocument()));
				}
			}
			complexReport.document.close();
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	@Deprecated
	public void generate(OutputStream outputStream) {

	}

	protected List<ComplexReport<T>> getPdfs() {
		return pdfs;
	}

	protected void setPdfs(List<ComplexReport<T>> pdfs) {
		this.pdfs = pdfs;
	}

	public List<T> getModelList() {
		return modelList;
	}

	protected void setModelListComplex(List<T> modelList) {
		this.modelList = modelList;
	}

	public String getNomePdf() {
		return nomePdf;
	}

	public void setNomePdf(String nome) {
		this.nomePdf = nome;
	}

}
