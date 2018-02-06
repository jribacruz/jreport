package br.jreport.template;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.core.DataModelChartPie;
import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;

public class ChartPie extends JReportElement {

	private DefaultPieDataset dataset = new DefaultPieDataset();

	private String title = "";

	private int width = 300;

	private int height = 300;

	private Document document;

	public ChartPie(Document document) {
		this.document = document;
	}

	// Criar lógica para retornar elemento a fim de setar dentro de o outro
	// componente. Ex.: DataTable
	protected Element buildElement() {
		JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
		configStyleChart(chart);
		Image image = null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ChartUtilities.writeChartAsJPEG(outputStream, chart, width, height);
			image = Image.getInstance(outputStream.toByteArray());
			ImageStyleClass style = new ImageStyleClass();
			image.setAlignment(style.getAlign().getValue());
		} catch (IOException e) {
			System.err.println("Error criando grafico.");
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear();
		return image;
	}

	public void build() {
		JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
		configStyleChart(chart);
		Image image = null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ChartUtilities.writeChartAsJPEG(outputStream, chart, width, height);
			image = Image.getInstance(outputStream.toByteArray());
			ImageStyleClass style = new ImageStyleClass();
			image.setAlignment(style.getAlign().getValue());
		} catch (IOException e) {
			System.err.println("Error criando grafico.");
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DocumentHelper.add(document, image);
		clear();
	}

	/**
	 * @param chart
	 * @return
	 */
	private void configStyleChart(JFreeChart chart) {
		chart.setBackgroundPaint(Color.white);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionOutlinesVisible(false);
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("No data available");
		plot.setCircular(true);
		plot.setLabelGap(0.02);
		plot.setShadowXOffset(0);
		plot.setShadowYOffset(0);
		plot.setInteriorGap(0.02);
		plot.setMaximumLabelWidth(0.20);
		plot.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1} ({2})"));
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
		plot.setIgnoreZeroValues(true);
		plot.setOutlinePaint(null);
		plot.setLabelOutlinePaint(null);
		plot.setLabelShadowPaint(null);
		plot.setLabelBackgroundPaint(Color.WHITE);
		plot.setBackgroundPaint(Color.white);
	}

	public ChartPie addDataSet(String texto, double valor) {
		dataset.setValue(texto, valor);
		return this;
	}
	
	public ChartPie addDataSet(List<? extends DataModelChartPie> list) {
		for (DataModelChartPie dataModelChartBar : list) {
			dataset.setValue(dataModelChartBar.getCategoria(), dataModelChartBar.getValue());
		}
		return this;
	}

	public ChartPie addLabel(String title) {
		this.title = title;
		return this;
	}

	public ChartPie addSize(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}

	/**
	 * 
	 */
	private void clear() {
		title = "";
		dataset = new DefaultPieDataset();
		width = 300;
		height = 300;
	}

}
