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
	private float borderTopWidth = 0.5f;
	private float borderLeftWidth = 0.5f;
	private float borderRightWidth = 0.5f;
	private float borderBottomWidth = 0.5f;
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
	public void setBorderTopWidth(String borderTopWidth) {
		if (borderTopWidth != null) {
			try {
				this.borderTopWidth = Float.valueOf(borderTopWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-top-width, valor: " + borderTopWidth);
			}
		}
	}
	public void setBorderLeftWidth(String borderLeftWidth) {
		if (borderLeftWidth != null) {
			try {
				this.borderLeftWidth = Float.valueOf(borderLeftWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-left-width, valor: " + borderLeftWidth);
			}
		}
	}
	public void setBorderRightWidth(String borderRightWidth) {
		if (borderRightWidth != null) {
			try {
				this.borderRightWidth = Float.valueOf(borderRightWidth.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para border-right-width, valor: " + borderRightWidth);
			}
		}
	}
	public void setBorderBottomWidth(String borderBottomWidth) {
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

	public float getBorderTopWidth() {
		return borderTopWidth;
	}

	public void setBorderTopWidth(float borderWidthTop) {
		this.borderTopWidth = borderWidthTop;
	}

	public float getBorderLeftWidth() {
		return borderLeftWidth;
	}

	public void setBorderLeftWidth(float borderWidthLeft) {
		this.borderLeftWidth = borderWidthLeft;
	}

	public float getBorderRightWidth() {
		return borderRightWidth;
	}

	public void setBorderRightWidth(float borderWidthRight) {
		this.borderRightWidth = borderWidthRight;
	}

	public float getBorderBottomWidth() {
		return borderBottomWidth;
	}

	public void setBorderBottomWidth(float borderWidthBottom) {
		this.borderBottomWidth = borderWidthBottom;
	}

}
