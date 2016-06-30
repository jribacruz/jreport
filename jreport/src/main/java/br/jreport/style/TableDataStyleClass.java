package br.jreport.style;

import java.awt.Color;
import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.enums.BorderStyle;
import br.jreport.enums.ColorJReport;
import br.jreport.enums.TextAlign;

public class TableDataStyleClass extends TextStyleClass {

	/** Cell table **/

	private Float fixedHeight = null;

	private int horizontalAlignment = TextAlign.LEFT.getValue();

	private int verticalAlignment = TextAlign.TOP.getValue();

	private BorderStyle border = BorderStyle.BOX;

	private float borderWidth = 0.5f;

	private ColorJReport borderColor = ColorJReport.BLACK;

	private int colspan = 1;

	private ColorJReport backgroundCellColor = ColorJReport.WHITE;

	public TableDataStyleClass(String style) {
		super(style);
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setFixedHeight(map.get("height"));
				setVerticalAlignment(map.get("vertical-alignment"));
				setHorizontalAlignment(map.get("horizontal-alignment"));
				setBorder(map.get("border"));
				setBorderWidth(map.get("border-width"));
				setBorderColor(map.get("border-color"));
				setColspan(map.get("colspan"));
			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TableDataStyleClass() {
		super();
	}

	public TableDataStyleClass(float width, int colspan, ColorJReport backgroundTableColor, ColorJReport borderColor,
			float tableSpaceCell) {
		super();
		this.colspan = colspan;
		this.backgroundCellColor = backgroundTableColor;
		this.borderColor = borderColor;
	}

	public void setBackgroundCellColor(String backgroundCellColor) {
		if (backgroundCellColor != null) {
			if (backgroundCellColor.startsWith("#")) {
				this.backgroundCellColor.setColor(Color.getColor(backgroundCellColor.trim().toUpperCase()));
			} else {
				this.backgroundCellColor = ColorJReport.valueOf(backgroundCellColor.trim().toUpperCase());
			}
		}
	}

	public void setColspan(String colspan) {
		if (colspan != null) {
			this.colspan = Integer.valueOf(colspan.trim());
		}
	}

	public void setBorderColor(String borderColor) {
		if (borderColor != null) {
			if (borderColor.startsWith("#")) {
				this.borderColor.setColor(Color.getColor(borderColor.trim().toUpperCase()));
			} else {
				this.borderColor = ColorJReport.valueOf(borderColor.trim().toUpperCase());
			}
		}
	}

	public void setBorderWidth(String borderWidth) {
		if (borderWidth != null) {
			try {
				this.borderWidth = Float.valueOf(borderWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-width, valor: " + borderWidth);
			}
		}
	}

	public void setBorder(String border) {
		if (border != null) {
			try {
				this.border = BorderStyle.valueOf(border.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border, valor: " + border);
			}
		}
	}

	public void setVerticalAlignment(String verticalAlignment) {
		if (verticalAlignment != null) {
			try {
				this.verticalAlignment = TextAlign.valueOf(verticalAlignment.trim()).getValue();
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para vertical-alignment, valor: " + verticalAlignment);
			}
		}
	}

	public void setHorizontalAlignment(String horizontalAlignment) {
		if (horizontalAlignment != null) {
			try {
				this.horizontalAlignment = TextAlign.valueOf(horizontalAlignment.trim()).getValue();
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para horizontal-alignment, valor: " + horizontalAlignment);
			}
		}
	}

	public void setFixedHeight(String fixedHeight) {
		if (fixedHeight != null) {
			try {
				this.fixedHeight = Float.valueOf(fixedHeight.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para height, valor: " + fixedHeight);
			}
		}
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

	public ColorJReport getBackgroundCellColor() {
		return backgroundCellColor;
	}

	public void setBackgroundCellColor(ColorJReport backgroundTableColor) {
		this.backgroundCellColor = backgroundTableColor;
	}

}
