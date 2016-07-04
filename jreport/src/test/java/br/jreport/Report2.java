package br.jreport;

import br.jreport.enums.TextAlign;
import br.jreport.model.ModelTest;
import br.jreport.style.TextStyleClass;
import br.jreport.template.Detail;
import br.jreport.template.PageFooter;
import br.jreport.template.PageHeader;
import br.jreport.template.SimpleReport;
import br.jreport.template.Summary;
import br.jreport.template.Title;

public class Report2 extends SimpleReport {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public static final String[] headers = { "Nome", "Sobrenome" };
//
//	private ModelTest modelTest;
//
//	public Report2(ModelTest modelTest) {
//		super();
//		this.modelTest = modelTest;
//	}
//
//	@Override
//	protected void pageHeader() {
//		TextStyleClass style = new TextStyleClass();
//		style.setTextAlign(TextAlign.RIGHT);
//		T_addTitle("Aelis 2016 - Page Header", style);
//	}
//
//	@Override
//	protected void title() {
//		T_addBrasao();
//		T_addTitle("Tribunal Regional Eleitoral do Pará");
//		T_addTitle("Relatório de Nome e Sobrenomes");
//	}
//
//	@Override
//	protected void detail() {
//		T_addTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas accumsan augue at interdum luctus."
//				+ " Etiam convallis quam a sapien malesuada, id cursus lacus congue. Sed purus sem, bibendum eu tellus a, rhoncus vehicula massa. "
//				+ "Mauris nisi ipsum, pellentesque vel mollis vel, varius sed nisl. Suspendisse feugiat enim non metus aliquam molestie. "
//				+ "Nulla mattis porttitor nisl ut fringilla. Proin sed quam sed ligula gravida porttitor. Nam faucibus est massa, quis sodales dui malesuada nec. "
//				+ "Vivamus sit amet neque justo. Phasellus vitae nulla eu ipsum vulputate cursus sed eu leo. "
//				+ "Duis commodo mauris eget sapien pulvinar, mollis eleifend dui congue. In porta id erat id interdum. ");
//	}


	@Override
	protected void title(Title t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pageHeader(PageHeader ph) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void detail(Detail d) {
		// TODO Auto-generated method stub
		
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
