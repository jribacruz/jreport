package br.jreport.style;

import com.lowagie.text.Element;

import br.jreport.core.TextStyleClass;
import br.jreport.enums.BorderStyle;
import br.jreport.enums.ColorJReport;

public class TableDataStyleClass extends TextStyleClass {

	/** Cell table **/

	private Float fixedHeight = null;

	private int horizontalAlignment = Element.ALIGN_LEFT;

	private int verticalAlignment = Element.ALIGN_TOP;

	private BorderStyle border = BorderStyle.BOX;

	private float borderWidth = 0.5f;

	private ColorJReport borderColor = ColorJReport.BLACK;

	private int colspan = 1;

	private ColorJReport backgroundTableColor = ColorJReport.WHITE;

	public TableDataStyleClass() {
		super();
		this.horizontalAlignment = Element.ALIGN_LEFT;
		this.verticalAlignment = Element.ALIGN_TOP;
		this.borderColor = ColorJReport.BLACK;
		this.borderWidth = 0.5f;
		this.border = BorderStyle.BOX;
		this.colspan = 1;
		this.backgroundTableColor = ColorJReport.WHITE;
	}

	public TableDataStyleClass(float width, int colspan, ColorJReport backgroundTableColor, ColorJReport borderColor,
			float tableSpaceCell) {
		super();
		this.colspan = colspan;
		this.backgroundTableColor = backgroundTableColor;
		this.borderColor = borderColor;
	}

	public Float getFixedHeight() {
		return fixedHeight;
	}

	public void setFixedHeight(Float fixedHeight) {
		this.fixedHeight = fixedHeight;
	}

	public int getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public void setHorizontalAlignment(int horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public BorderStyle getBorder() {
		return border;
	}

	public void setBorder(BorderStyle border) {
		this.border = border;
	}

	public ColorJReport getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(ColorJReport borderColor) {
		this.borderColor = borderColor;
	}

	public float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	public ColorJReport getBackgroundTableColor() {
		return backgroundTableColor;
	}

	public void setBackgroundTableColor(ColorJReport backgroundTableColor) {
		this.backgroundTableColor = backgroundTableColor;
	}

}
