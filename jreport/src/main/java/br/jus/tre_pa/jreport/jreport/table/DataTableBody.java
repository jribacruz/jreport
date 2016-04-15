package br.jus.tre_pa.jreport.jreport.table;

import com.lowagie.text.pdf.PdfPTable;

public abstract class DataTableBody<T> extends TableBody {

	private int index;

	private boolean first;

	private boolean middle;

	private boolean last;

	private boolean even;

	private boolean odd;

	public DataTableBody() {
		super();
	}

	public abstract void body(T model);

	public PdfPTable getPdfPTable() {
		return pdfPTable;
	}

	public void setPdfPTable(PdfPTable pdfPTable) {
		this.pdfPTable = pdfPTable;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isMiddle() {
		return middle;
	}

	public void setMiddle(boolean middle) {
		this.middle = middle;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public boolean isEven() {
		return even;
	}

	public void setEven(boolean even) {
		this.even = even;
	}

	public boolean isOdd() {
		return odd;
	}

	public void setOdd(boolean odd) {
		this.odd = odd;
	}

	@Override
	protected void body() {

	}

}
