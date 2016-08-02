package br.jreport.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.jreport.enums.PageOrientation;
import br.jreport.model.CategoriaPagamentoModel;
import br.jreport.table.DataTableBodyModel;
import br.jreport.table.TableHeader;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class RelatorioExample extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CategoriaPagamentoModel> model;
	private Map<String, BigDecimal> total6Meses = new HashMap<String, BigDecimal>();
	
	static Random random = new Random();
	

	public static void main(String[] args) throws FileNotFoundException {
		// INICIO CRIANDO MODEL, Normalmente é feito na consulta SQL
		List<CategoriaPagamentoModel> model = new ArrayList<CategoriaPagamentoModel>();

		CategoriaPagamentoModel model1 = new CategoriaPagamentoModel("ACP - Anuidade", criaMap());
		CategoriaPagamentoModel model2 = new CategoriaPagamentoModel("ACP MEMBRO - ANUIDADE", criaMap());
		CategoriaPagamentoModel model3 = new CategoriaPagamentoModel("ALUGUÉIS DE SALAS E AUDITÓRIOS P/EVENTOS",
				criaMap());
		CategoriaPagamentoModel model4 = new CategoriaPagamentoModel("CANCELADOS", criaMap());
		CategoriaPagamentoModel model5 = new CategoriaPagamentoModel("COMISSÃO BOA VISTA", criaMap());
		CategoriaPagamentoModel model6 = new CategoriaPagamentoModel("CONTRIBUIÇÃO/DOAÇÃO", criaMap());
		CategoriaPagamentoModel model7 = new CategoriaPagamentoModel("CURSO ACP", criaMap());
		CategoriaPagamentoModel model8 = new CategoriaPagamentoModel("DEPÓSITO NÃO IDENTIFICADO", criaMap());
		CategoriaPagamentoModel model9 = new CategoriaPagamentoModel("MENSALIDADE ACP", criaMap());
		CategoriaPagamentoModel model10 = new CategoriaPagamentoModel("OUTRAS RECEITAS", criaMap());
		CategoriaPagamentoModel model11 = new CategoriaPagamentoModel("PATROCÍNIOS DIVERSOS", criaMap());
		CategoriaPagamentoModel model12 = new CategoriaPagamentoModel("PROPAGANDA E PUBLICIDADE REVISTA", criaMap());
		CategoriaPagamentoModel model13 = new CategoriaPagamentoModel("RECUPERAÇÃO DE DESPESAS - ACP", criaMap());
		CategoriaPagamentoModel model14 = new CategoriaPagamentoModel("RENDIMENTO APLICAÇÃO", criaMap());
		CategoriaPagamentoModel model15 = new CategoriaPagamentoModel("SÓCIO ESPECIAL", criaMap());
		CategoriaPagamentoModel model16 = new CategoriaPagamentoModel("SÓCIO INSTITUCIONAL", criaMap());
		model.add(model1);
		model.add(model2);
		model.add(model3);
		model.add(model4);
		model.add(model5);
		model.add(model6);
		model.add(model7);
		model.add(model8);
		model.add(model9);
		model.add(model10);
		model.add(model11);
		model.add(model12);
		model.add(model13);
		model.add(model14);
		model.add(model15);
		model.add(model16);

		RelatorioExample myModel = new RelatorioExample(PageOrientation.LANDSCAPE, model);
		myModel.generate(new FileOutputStream(new File("target/RelatorioExample.pdf")));
	}

	private static HashMap<String, BigDecimal> criaMap() {
		long LOWER_RANGE = 0; //assign lower range value
		 long UPPER_RANGE = 1000000; //assign upper range value
		 
		HashMap<String, BigDecimal> totalMeses = new HashMap<String, BigDecimal>();
		totalMeses.put("JAN", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("FEV", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("MAR", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("ABR", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("MAI", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("JUN", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("JUL", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("AGO", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("SET", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("OUT", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("NOV", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("DEZ", BigDecimal.valueOf(LOWER_RANGE + (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE)), 2));
		return totalMeses;
	}
	// FIM - CRIANDO MODEL, Normalmente é feito na consulta SQL

	public RelatorioExample(PageOrientation pageorient, List<CategoriaPagamentoModel> model) {
		super(pageorient);
		this.model = model;
	}

	@Override
	protected void title(Title t) {
		t.addTitle("Centro de custo : ACP").build();

	}

	@Override
	protected void pageHeader(PageHeader ph) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detail(Detail d) {
		TableHeader[] headerJanJun = {
				th("Categoria de Pagamento",
						"colspan:3; font-weight: bold; border-top-width:0; border-left-width:0; text-align: center;"),
				th("JAN", "text-align: center; background-color:#8FBFD3"),
				th("FEV", "text-align: center; background-color:#8FBFD3"),
				th("MAR", "text-align: center; background-color:#8FBFD3"),
				th("ABR", "text-align: center; background-color:#8FBFD3"),
				th("MAI", "text-align: center; background-color:#8FBFD3"),
				th("JUN", "text-align: center; background-color:#8FBFD3") };
		d.addDataTable().addHeader(headerJanJun)
				.addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {

					@Override
					public void body(CategoriaPagamentoModel model) {
						addCell(model.getCategoria(), "colspan:3;background-color:#8FBFD3; text-align:center");
						addCell("R$ " + model.getMeses().get("JAN"));
						addCell("R$ " + model.getMeses().get("FEV"));
						addCell("R$ " + model.getMeses().get("MAR"));
						addCell("R$ " + model.getMeses().get("ABR"));
						addCell("R$ " + model.getMeses().get("MAI"));
						addCell("R$ " + model.getMeses().get("JUN"));
						somarTotal("JAN",  model.getMeses().get("JAN"));
						somarTotal("FEV",  model.getMeses().get("FEV"));
						somarTotal("MAR",  model.getMeses().get("MAR"));
						somarTotal("ABR",  model.getMeses().get("ABR"));
						somarTotal("MAI",  model.getMeses().get("MAI"));
						somarTotal("JUN",  model.getMeses().get("JUN"));

					}
				}).addCell("TOTAL", "colspan:3;background-color:#849BC3; text-align:center")
				.addCell("RS "+total6Meses.get("JAN").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("FEV").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("MAR").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("ABR").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("MAI").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("JUN").toString(), "background-color:#849BC3")
				.build();

		TableHeader[] headerJulDez = {
				th("Categoria de Pagamento",
						"colspan:3; font-weight: bold; border-top-width:0; border-left-width:0; text-align: center;"),
				th("JUL", "text-align: center; background-color:#8FBFD3"),
				th("AGO", "text-align: center; background-color:#8FBFD3"),
				th("SET", "text-align: center; background-color:#8FBFD3"),
				th("OUT", "text-align: center; background-color:#8FBFD3"),
				th("NOV", "text-align: center; background-color:#8FBFD3"),
				th("DEZ", "text-align: center; background-color:#8FBFD3") };
		total6Meses = new HashMap<String, BigDecimal>();
		d.addDataTable().addHeader(headerJulDez)
				.addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {

					@Override
					public void body(CategoriaPagamentoModel model) {
						addCell(model.getCategoria(), "colspan:3;background-color:#8FBFD3; text-align:center");
						addCell("R$ " + model.getMeses().get("JUL"));
						addCell("R$ " + model.getMeses().get("AGO"));
						addCell("R$ " + model.getMeses().get("SET"));
						addCell("R$ " + model.getMeses().get("OUT"));
						addCell("R$ " + model.getMeses().get("NOV"));
						addCell("R$ " + model.getMeses().get("DEZ"));
						somarTotal("JUL",  model.getMeses().get("JUL"));
						somarTotal("AGO",  model.getMeses().get("AGO"));
						somarTotal("SET",  model.getMeses().get("SET"));
						somarTotal("OUT",  model.getMeses().get("OUT"));
						somarTotal("NOV",  model.getMeses().get("NOV"));
						somarTotal("DEZ",  model.getMeses().get("DEZ"));

					}
				}).addCell("TOTAL", "colspan:3;background-color:#849BC3; text-align:center")
				.addCell("RS "+total6Meses.get("JUL").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("AGO").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("SET").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("OUT").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("NOV").toString(), "background-color:#849BC3")
				.addCell("RS "+total6Meses.get("DEZ").toString(), "background-color:#849BC3")
				.build();
		
		TableHeader[] totalMes = {
				th("Categoria de Pagamento",
						"colspan:3; font-weight: bold; border-top-width:0; border-left-width:0; text-align: center;"),
				th("Total Mes", "text-align: center; background-color:#8FBFD3"),
				th("", "border-width: 0; colspan:5")};
		d.addDataTable().addHeader(totalMes)
		.addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {
			
			@Override
			public void body(CategoriaPagamentoModel model) {
				addCell(model.getCategoria(), "colspan:3;background-color:#8FBFD3; text-align:center");
				addCell("R$ " + model.getTotalMeses().get(model.getCategoria()), "background-color:#849BC3");
				addCell("", "border-width: 0; colspan:5");
			}
		}).build();
	}
	
	public void somarTotal(String key, BigDecimal valor) {
		if (total6Meses.containsKey(key)) {
			total6Meses.put(key, total6Meses.get(key).add(valor));
		} else {
			total6Meses.put(key, valor);
		}
	}

	@Override
	protected void pageFooter(PageFooter pf) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void summary(Summary s) {
		// TODO Auto-generated method stub

	}

}
