package br.jus.tre_pa.jreport.jreport.table;

import java.util.List;

import br.jus.tre_pa.jreport.jreport.core.DataModelReport;

public class DataTable<T extends DataModelReport> extends Table {

	public DataTable(int numColumns) {
		super(numColumns);
	}

	public DataTable(String[] headers) {
		super(headers);
	}
	
	public DataTable(TableHeader[] headers) {
		super(headers);
	}

	public void addBody(List<T> modelList, DataTableBody<T> dataTableBody) {
		dataTableBody.setPdfPTable(getPdfPTable());
		int listSize = modelList.size();
		for (int i = 0; i < listSize; i++) {
			dataTableBody.setIndex(i);
			dataTableBody.setFirst(i == 0);
			dataTableBody.setMiddle(i == listSize / 2);
			dataTableBody.setLast(i == listSize - 1);
			dataTableBody.setEven(i % 2 == 0);
			dataTableBody.setOdd(i % 2 == 1);
			dataTableBody.body(modelList.get(i));
		}
	}
}
