package br.jreport.template;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;

import br.jreport.core.DataModelChartLine;
import br.jreport.helper.DocumentHelper;
import br.jreport.style.ImageStyleClass;

public class ChartLine extends JReportElement {

	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	private String title = "";

	private String eixoX = "";

	private String eixoY = "";

	private int width = 300;

	private int height = 300;

	private Document document;

	private PlotOrientation orientacao = PlotOrientation.VERTICAL;

	private String[] colors;

	public ChartLine(Document document) {
		this.document = document;
	}

	// Criar lógica para retornar elemento a fim de setar dentro de o outro
	// componente. Ex.: DataTable
	protected Element buildElement() {
		JFreeChart chart = ChartFactory.createLineChart(title, eixoX, eixoY, dataset, orientacao, false, true, false);
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
		JFreeChart chart = ChartFactory.createLineChart(title, eixoX, eixoY, dataset, orientacao, false, true, false);
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
		DocumentHelper.add(document, image);
	}

	/**
	 * @param chart
	 * @return
	 */
	private void configStyleChart(JFreeChart chart) {
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.black);
		plot.setDomainGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.black);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		if (colors != null) {
			for (int i = 0; i < colors.length; i++) {
				GradientPaint gradient = new GradientPaint(1.0f, 1.0f, pickColor(colors[i]), 1.0f, 1.0f, pickColor(colors[i]));
				renderer.setSeriesPaint(i, gradient);
			}
		}
	}

	private Color pickColor(String color) {
		if (color.trim().startsWith("#")) {
			return Color.decode(color.trim().toUpperCase());
		} else {
			try {
				Field field = java.awt.Color.class.getField(color.trim().toUpperCase());
				return (Color) field.get(null);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return Color.BLUE;
	}

	public ChartLine addLabel(String title, String textX, String textY) {
		this.title = title;
		this.eixoX = textX;
		this.eixoY = textY;
		return this;
	}
	

	public ChartLine addLineColor(String colors[]) {
		this.colors = colors;
		return this;
	}

	public ChartLine addDataSet(double value, String serie, String categoria) {
		dataset.setValue(value, serie, categoria);
		return this;
	}

	public ChartLine addDataSet(List<? extends DataModelChartLine> list) {
		for (DataModelChartLine dataModelChartBar : list) {
			dataset.setValue(dataModelChartBar.getValue(), dataModelChartBar.getSerie(), dataModelChartBar.getCategoria());
		}
		return this;
	}

	public ChartLine addSize(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}

	// TODO se tiver muito mais estilo, mudar para uma classe Style.
	public ChartLine addOrientacaoHorizontal() {
		this.orientacao = PlotOrientation.HORIZONTAL;
		return this;
	}

	private void clear() {
		title = "";
		eixoX = "";
		eixoY = "";
		dataset = new DefaultCategoryDataset();
		orientacao = PlotOrientation.VERTICAL;
		width = 300;
		height = 300;
	}

}
