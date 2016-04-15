package br.jus.tre_pa.jreport.jreport;

import java.awt.Color;

import br.jus.tre_pa.jreport.jreport.core.TextStyleClass;
import br.jus.tre_pa.jreport.jreport.enums.TextAlign;
import br.jus.tre_pa.jreport.jreport.model.ModelTest;
import br.jus.tre_pa.jreport.jreport.table.TableBody;
import br.jus.tre_pa.jreport.jreport.template.SimpleReport;

public class Report2 extends SimpleReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String[] headers = { "Nome", "Sobrenome" };

	private ModelTest modelTest;

	public Report2(ModelTest modelTest) {
		super();
		this.modelTest = modelTest;
	}

	@Override
	protected void pageHeader() {
		TextStyleClass style = new TextStyleClass();
		style.setTextAlign(TextAlign.RIGHT);
		addText("Aelis 2016 - Page Header", style);
	}

	@Override
	protected void title() {
		addBrasao();
		addTitle("Tribunal Regional Eleitoral do Pará");
		addTitle("Relatório de Nome e Sobrenomes");
	}

	@Override
	protected void detail() {
		addText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas accumsan augue at interdum luctus."
				+ " Etiam convallis quam a sapien malesuada, id cursus lacus congue. Sed purus sem, bibendum eu tellus a, rhoncus vehicula massa. "
				+ "Mauris nisi ipsum, pellentesque vel mollis vel, varius sed nisl. Suspendisse feugiat enim non metus aliquam molestie. "
				+ "Nulla mattis porttitor nisl ut fringilla. Proin sed quam sed ligula gravida porttitor. Nam faucibus est massa, quis sodales dui malesuada nec. "
				+ "Vivamus sit amet neque justo. Phasellus vitae nulla eu ipsum vulputate cursus sed eu leo. "
				+ "Duis commodo mauris eget sapien pulvinar, mollis eleifend dui congue. In porta id erat id interdum. ");
	}
}
