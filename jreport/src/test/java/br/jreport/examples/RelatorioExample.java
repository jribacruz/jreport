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
	String style1 = "text-align: center; background-color:#8FBFD3";
	String style2 = "background-color:#849BC3";
	String style3 = "colspan:3;background-color:#8FBFD3; text-align:center";
	String style4 = "colspan:3; font-weight: bold; border-top-width:0; border-left-width:0; text-align: center;";
	String style5 = "colspan:3;background-color:#849BC3; text-align:center";

	TableHeader[] headerJanJun = { th("Categoria de Pagamento", style4), th("JAN", style1), th("FEV", style1), th("MAR", style1),
			th("ABR", style1), th("MAI", style1), th("JUN", style1) };
	TableHeader[] headerJulDez = { th("Categoria de Pagamento", style4), th("JUL", style1), th("AGO", style1), th("SET", style1),
			th("OUT", style1), th("NOV", style1), th("DEZ", style1) };
	TableHeader[] totalMes = { th("Categoria de Pagamento", style4), th("Total Mes", style1), th("", "border-width: 0; colspan:5") };

	public static void main(String[] args) throws FileNotFoundException {
		// INICIO CRIANDO MODEL, Normalmente é feito na consulta SQL
		List<CategoriaPagamentoModel> model = new ArrayList<CategoriaPagamentoModel>();

		CategoriaPagamentoModel model1 = new CategoriaPagamentoModel("ANUIDADE1", criaMap());
		CategoriaPagamentoModel model2 = new CategoriaPagamentoModel("ANUIDADE2", criaMap());
		CategoriaPagamentoModel model3 = new CategoriaPagamentoModel("ALUGUÉIS SALAS E AUDITÓRIOS P/EVENTOS", criaMap());
		CategoriaPagamentoModel model4 = new CategoriaPagamentoModel("CANCELADOS", criaMap());
		CategoriaPagamentoModel model5 = new CategoriaPagamentoModel("COMISSÃO", criaMap());
		CategoriaPagamentoModel model6 = new CategoriaPagamentoModel("DOAÇÃO", criaMap());
		CategoriaPagamentoModel model7 = new CategoriaPagamentoModel("CURSOS", criaMap());
		CategoriaPagamentoModel model8 = new CategoriaPagamentoModel("DEPÓSITOS", criaMap());
		CategoriaPagamentoModel model9 = new CategoriaPagamentoModel("MENSALIDADE", criaMap());
		CategoriaPagamentoModel model10 = new CategoriaPagamentoModel("OUTRAS RECEITAS", criaMap());
		CategoriaPagamentoModel model11 = new CategoriaPagamentoModel("DIVERSOS", criaMap());
		CategoriaPagamentoModel model12 = new CategoriaPagamentoModel("PROPAGANDA", criaMap());
		CategoriaPagamentoModel model13 = new CategoriaPagamentoModel("RECUPERAÇÃO DE DESPESAS", criaMap());
		CategoriaPagamentoModel model14 = new CategoriaPagamentoModel("RENDIMENTO APLICAÇÃO", criaMap());
		CategoriaPagamentoModel model15 = new CategoriaPagamentoModel("SÓCIO1", criaMap());
		CategoriaPagamentoModel model16 = new CategoriaPagamentoModel("SÓCIO2", criaMap());
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
		long LOWER_RANGE = 0; // assign lower range value
		long UPPER_RANGE = 1000000; // assign upper range value

		HashMap<String, BigDecimal> totalMeses = new HashMap<String, BigDecimal>();
		totalMeses.put("JAN", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("FEV", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("MAR", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("ABR", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("MAI", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("JUN", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("JUL", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("AGO", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("SET", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("OUT", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("NOV", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
		totalMeses.put("DEZ", BigDecimal.valueOf(LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)), 2));
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
		d.addDataTable().addHeader(headerJanJun).addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {
			@Override
			public void body(CategoriaPagamentoModel model) {
				addCell(model.getCategoria(), style3);
				addCell("R$ " + somarTotal("JAN", model.getMeses().get("JAN")));
				addCell("R$ " + somarTotal("FEV", model.getMeses().get("FEV")));
				addCell("R$ " + somarTotal("MAR", model.getMeses().get("MAR")));
				addCell("R$ " + somarTotal("ABR", model.getMeses().get("ABR")));
				addCell("R$ " + somarTotal("MAI", model.getMeses().get("MAI")));
				addCell("R$ " + somarTotal("JUN", model.getMeses().get("JUN")));
			}
		}).addCell("TOTAL", style5).addCell("RS " + total6Meses.get("JAN").toString(), style2)
				.addCell("RS " + total6Meses.get("FEV").toString(), style2).addCell("RS " + total6Meses.get("MAR").toString(), style2)
				.addCell("RS " + total6Meses.get("ABR").toString(), style2).addCell("RS " + total6Meses.get("MAI").toString(), style2)
				.addCell("RS " + total6Meses.get("JUN").toString(), style2).build();

		total6Meses = new HashMap<String, BigDecimal>();
		d.addDataTable().addHeader(headerJulDez).addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {
			@Override
			public void body(CategoriaPagamentoModel model) {
				addCell(model.getCategoria(), style3);
				addCell("R$ " + somarTotal("JUL", model.getMeses().get("JUL")));
				addCell("R$ " + somarTotal("AGO", model.getMeses().get("AGO")));
				addCell("R$ " + somarTotal("SET", model.getMeses().get("SET")));
				addCell("R$ " + somarTotal("OUT", model.getMeses().get("OUT")));
				addCell("R$ " + somarTotal("NOV", model.getMeses().get("NOV")));
				addCell("R$ " + somarTotal("DEZ", model.getMeses().get("DEZ")));
			}
		}).addCell("TOTAL", style5).addCell("RS " + total6Meses.get("JUL").toString(), style2)
				.addCell("RS " + total6Meses.get("AGO").toString(), style2).addCell("RS " + total6Meses.get("SET").toString(), style2)
				.addCell("RS " + total6Meses.get("OUT").toString(), style2).addCell("RS " + total6Meses.get("NOV").toString(), style2)
				.addCell("RS " + total6Meses.get("DEZ").toString(), style2).build();

		d.addDataTable().addHeader(totalMes).addDataTableBody(model, new DataTableBodyModel<CategoriaPagamentoModel>() {
			@Override
			public void body(CategoriaPagamentoModel model) {
				addCell(model.getCategoria(), style3);
				addCell("R$ " + model.getTotalMeses().get(model.getCategoria()), style2);
				addCell("", "border-width: 0; colspan:5");
			}
		}).build();
	}

	public BigDecimal somarTotal(String key, BigDecimal valor) {
		if (total6Meses.containsKey(key)) {
			total6Meses.put(key, total6Meses.get(key).add(valor));
		} else {
			total6Meses.put(key, valor);
		}
		return valor;
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
