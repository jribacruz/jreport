package br.jreport.core;

import java.util.List;

import com.lowagie.text.Document;

import br.jreport.helper.DocumentHelper;
import br.jreport.table.DataTableBody;
import br.jreport.table.TableBody;
import br.jreport.table.TableHeader;

public class DataTable <T extends DataModelReport> {
	
	private Document document;
	
	public DataTable(Document document) {
		this.document = document;
	}

	public DataTable<T> addDataTable(List<T> modelList, TableHeader[] headers, DataTableBody<T> tableBody) {
		DocumentHelper.add(document, DocumentHelper.createDataTable(modelList, headers, tableBody).getPdfPTable());
		return this;
	}

	public DataTable<T> addDataTable(List<T> modelList, String[] headers, DataTableBody<T> tableBody) {
		DocumentHelper.add(document, DocumentHelper.createDataTable(modelList, headers, tableBody).getPdfPTable());
		return this;
	}

	public DataTable<T> addDataTable(List<T> modelList, int numColumns, DataTableBody<T> tableBody) {
		DocumentHelper.add(document, DocumentHelper.createDataTable(modelList, numColumns, tableBody).getPdfPTable());
		return this;
	}

	public DataTable<T> addTable(String[] headers, TableBody tableBody) {
		DocumentHelper.add(document, DocumentHelper.createTable(headers, tableBody).getPdfPTable());
		return this;
	}

	public DataTable<T> addTable(int numColumns, TableBody tableBody) {
		DocumentHelper.add(document, DocumentHelper.createTable(numColumns, tableBody).getPdfPTable());
		return this;
	}

}
