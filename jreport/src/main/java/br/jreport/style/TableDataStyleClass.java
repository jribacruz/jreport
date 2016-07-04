package br.jreport.style;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.enums.TextAlign;

public class TableDataStyleClass extends TextStyleClass {

	/** Cell table **/

	private int verticalAlignment = TextAlign.TOP.getValue();

	private int horizontalAlignment = TextAlign.LEFT.getValue();

	private Float height = null;
	private float width = 1f;

	private Color borderColor = Color.BLACK;
	private float borderWidth = 0.5f;
	private float borderWidthTop = 0.5f;
	private float borderWidthLeft = 0.5f;
	private float borderWidthRight = 0.5f;
	private float borderWidthBottom = 0.5f;
	private int colspan = 1;
	private Color backgroundCellColor = Color.WHITE;

	public TableDataStyleClass(String style) {
		super(style);
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setVerticalAlignment(map.get("vertical-alignment"));
				setHorizontalAlignment(map.get("horizontal-alignment"));
				setHeight(map.get("height"));
				setBorderColor(map.get("border-color"));
				setBorderWidth(map.get("border-width"));
				setColspan(map.get("colspan"));
				setBackgroundCellColor(map.get("background-color"));
				setWidth(map.get("width"));
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

	public TableDataStyleClass(float width, int colspan, Color backgroundTableColor, Color borderColor, float tableSpaceCell) {
		super();
		this.colspan = colspan;
		this.backgroundCellColor = backgroundTableColor;
		this.borderColor = borderColor;
	}
	
	public void setWidth(String width) {
		if (width != null) {
			try {
				this.width = Float.valueOf(width.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para width, valor: " + width);
			}
		}
	}

	public void setBackgroundCellColor(String backgroundCellColor) {
		if (backgroundCellColor != null) {
			if (backgroundCellColor.trim().startsWith("#")) {
				this.backgroundCellColor = Color.decode(backgroundCellColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(backgroundCellColor.trim().toLowerCase());
					this.backgroundCellColor = (Color) field.get(null);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			if (borderColor.trim().startsWith("#")) {
				this.borderColor = Color.decode(borderColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(borderColor.trim().toLowerCase());
					this.borderColor = (Color) field.get(null);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	// public void setBorder(String border) {
	// if (border != null) {
	// try {
	// this.border = BorderStyle.valueOf(border.trim());
	// } catch (NumberFormatException e) {
	// throw new NumberFormatException("Elemento inválido para border, valor: "
	// + border);
	// }
	// }
	// }

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

	public void setHeight(String height) {
		if (height != null) {
			try {
				this.height = Float.valueOf(height.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para height, valor: " + height);
			}
		}
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float fixedHeight) {
		this.height = fixedHeight;
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

	// public BorderStyle getBorder() {
	// return border;
	// }
	//
	// public void setBorder(BorderStyle border) {
	// this.border = border;
	// }

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

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getBackgroundCellColor() {
		return backgroundCellColor;
	}

	public void setBackgroundCellColor(Color backgroundCellColor) {
		this.backgroundCellColor = backgroundCellColor;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getBorderWidthTop() {
		return borderWidthTop;
	}

	public void setBorderWidthTop(float borderWidthTop) {
		this.borderWidthTop = borderWidthTop;
	}

	public float getBorderWidthLeft() {
		return borderWidthLeft;
	}

	public void setBorderWidthLeft(float borderWidthLeft) {
		this.borderWidthLeft = borderWidthLeft;
	}

	public float getBorderWidthRight() {
		return borderWidthRight;
	}

	public void setBorderWidthRight(float borderWidthRight) {
		this.borderWidthRight = borderWidthRight;
	}

	public float getBorderWidthBottom() {
		return borderWidthBottom;
	}

	public void setBorderWidthBottom(float borderWidthBottom) {
		this.borderWidthBottom = borderWidthBottom;
	}

}
