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
	private Float width = 1f;

	private Color borderColor = Color.BLACK;
	private Float borderWidth = 0.5f;
	private Float borderTopWidth = null;
	private Float borderLeftWidth = null;
	private Float borderRightWidth = null;
	private Float borderBottomWidth = null;
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

				setBorderTopWidth(map.get("border-top-width"));
				setBorderLeftWidth(map.get("border-left-width"));
				setBorderRightWidth(map.get("border-right-width"));
				setBorderBottomWidth(map.get("border-bottom-width"));

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

	public TableDataStyleClass(Float width, int colspan, Color backgroundTableColor, Color borderColor, Float tableSpaceCell) {
		super();
		this.colspan = colspan;
		this.backgroundCellColor = backgroundTableColor;
		this.borderColor = borderColor;
	}

	private void setWidth(String width) {
		if (width != null) {
			try {
				this.width = Float.valueOf(width.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para width, valor: " + width);
			}
		}
	}

	private void setBackgroundCellColor(String backgroundCellColor) {
		if (backgroundCellColor != null) {
			if (backgroundCellColor.trim().startsWith("#")) {
				this.backgroundCellColor = Color.decode(backgroundCellColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(backgroundCellColor.trim().toUpperCase());
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

	private void setColspan(String colspan) {
		if (colspan != null) {
			this.colspan = Integer.valueOf(colspan.trim());
		}
	}

	private void setBorderColor(String borderColor) {
		if (borderColor != null) {
			if (borderColor.trim().startsWith("#")) {
				this.borderColor = Color.decode(borderColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(borderColor.trim().toUpperCase());
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

	private void setBorderWidth(String borderWidth) {
		if (borderWidth != null) {
			try {
				this.borderWidth = Float.valueOf(borderWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-width, valor: " + borderWidth);
			}
		}
	}

	private void setBorderTopWidth(String borderTopWidth) {
		if (borderTopWidth != null) {
			try {
				this.borderTopWidth = Float.valueOf(borderTopWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-top-width, valor: " + borderTopWidth);
			}
		}
	}

	private void setBorderLeftWidth(String borderLeftWidth) {
		if (borderLeftWidth != null) {
			try {
				this.borderLeftWidth = Float.valueOf(borderLeftWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-left-width, valor: " + borderLeftWidth);
			}
		}
	}

	private void setBorderRightWidth(String borderRightWidth) {
		if (borderRightWidth != null) {
			try {
				this.borderRightWidth = Float.valueOf(borderRightWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-right-width, valor: " + borderRightWidth);
			}
		}
	}

	private void setBorderBottomWidth(String borderBottomWidth) {
		if (borderBottomWidth != null) {
			try {
				this.borderBottomWidth = Float.valueOf(borderBottomWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-bottom-width, valor: " + borderBottomWidth);
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

	private void setVerticalAlignment(String verticalAlignment) {
		if (verticalAlignment != null) {
			try {
				this.verticalAlignment = TextAlign.valueOf(verticalAlignment.trim().toUpperCase()).getValue();
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para vertical-alignment, valor: " + verticalAlignment);
			}
		}
	}

	private void setHorizontalAlignment(String horizontalAlignment) {
		if (horizontalAlignment != null) {
			try {
				this.horizontalAlignment = TextAlign.valueOf(horizontalAlignment.trim().toUpperCase()).getValue();
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para horizontal-alignment, valor: " + horizontalAlignment);
			}
		}
	}

	private void setHeight(String height) {
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

	public Float getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Float borderWidth) {
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

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getBorderTopWidth() {
		return borderTopWidth;
	}

	public void setBorderTopWidth(Float borderWidthTop) {
		this.borderTopWidth = borderWidthTop;
	}

	public Float getBorderLeftWidth() {
		return borderLeftWidth;
	}

	public void setBorderLeftWidth(Float borderWidthLeft) {
		this.borderLeftWidth = borderWidthLeft;
	}

	public Float getBorderRightWidth() {
		return borderRightWidth;
	}

	public void setBorderRightWidth(Float borderWidthRight) {
		this.borderRightWidth = borderWidthRight;
	}

	public Float getBorderBottomWidth() {
		return borderBottomWidth;
	}

	public void setBorderBottomWidth(Float borderWidthBottom) {
		this.borderBottomWidth = borderWidthBottom;
	}

}
