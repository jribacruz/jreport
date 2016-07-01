package br.jreport.style;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;
import br.jreport.enums.TextDecoration;

public class TextStyleClass {

	/** Font **/
	private FontStyle fontStyle = FontStyle.NORMAL;

	private float fontSize = 9;

	private Color fontColor = Color.BLACK;

	private TextDecoration textDecoration = TextDecoration.NONE;

	private Color backgroudColor;//TODO remover essa propriedade.

	/** Paragraph identation **/
	private float firstLineIndent = 0;

	private float indentationLeft = 0;

	private TextAlign textAlign = TextAlign.JUSTIFIED;

	public static void main(String[] args) {
		TextStyleClass a = new TextStyleClass(
				"text-align: center ; font-size:1.5; font-style:normal; "
				+ "font-color:#000000; text-decoration: underline; background-color: #FFFFFF; text-indent:10; indentation-left: 10");
		System.out.println(a);
	}

	public TextStyleClass() {

	}

	public TextStyleClass(String style) {
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setFontStyle(map.get("font-style"));
				setFontSize(map.get("font-size"));
				setFontColor(map.get("font-color"));

				setTextDecoration(map.get("text-decoration"));
				setBackgroudColor(map.get("background-color"));

				setFirstLineIndent(map.get("text-indent"));
				setIndentationLeft(map.get("indentation-left"));
				setTextAlign(map.get("text-align"));
			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO se todos os parametros fossem String
		// DozerBeanMapper seria a melhor solução.
		// DozerBeanMapper mapper = new DozerBeanMapper();
		// TextStyleClass pojo = mapper.map(map, TextStyleClass.class);
	}

	public void setIndentationLeft(String indentationLeft) {
		if (indentationLeft != null) {
			try {
				this.indentationLeft = Float.valueOf(indentationLeft.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para indentationLeft, valor: " + indentationLeft);
			}
		}
	}

	public void setFirstLineIndent(String textIndent) {
		if (textIndent != null) {
			try {
				this.firstLineIndent = Float.valueOf(textIndent.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para textIndent, valor: " + textIndent);
			}
		}
	}

	public void setBackgroudColor(String backgroudColor) {
		if (backgroudColor != null) {
			if (backgroudColor.trim().startsWith("#")) {
				this.backgroudColor = Color.decode(backgroudColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(backgroudColor.trim().toLowerCase());
					this.backgroudColor = (Color)field.get(null);
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

	public void setTextDecoration(String textDecoration) {
		if (textDecoration != null) {
			this.textDecoration = TextDecoration.valueOf(textDecoration.trim().toUpperCase());
		}
	}

	public void setFontStyle(String fontStyle) {
		if (fontStyle != null) {
			this.fontStyle = FontStyle.valueOf(fontStyle.trim().toUpperCase());
		}
	}

	public void setTextAlign(String textAlign) {
		if (textAlign != null) {
			this.textAlign = TextAlign.valueOf(textAlign.trim().toUpperCase());
		}
	}

	public void setFontSize(String fontSize) {
		if (fontSize != null) {
			try {
				this.fontSize = Float.valueOf(fontSize.trim());
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Elemento inválido para fontSize, valor: " + fontSize);
			}
		}
	}

	public void setFontColor(String fontColor) {
		if (fontColor != null) {
			if (fontColor.trim().startsWith("#")) {
				this.fontColor = Color.decode(fontColor.trim().toUpperCase());
			} else {
				try {
					Field field = Color.class.getField(fontColor.trim().toLowerCase());
					this.fontColor = (Color)field.get(null);
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

	public TextAlign getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(TextAlign textAlign) {
		this.textAlign = textAlign;
	}

	public FontStyle getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}

	public float getFontSize() {
		return fontSize;
	}

	public void setFontSize(float fontSize) {
		this.fontSize = fontSize;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public Color getBackgroudColor() {
		return backgroudColor;
	}

	public void setBackgroudColor(Color backgroudColor) {
		this.backgroudColor = backgroudColor;
	}

	public TextDecoration getTextDecoration() {
		return textDecoration;
	}

	public void setTextDecoration(TextDecoration textDecoration) {
		this.textDecoration = textDecoration;
	}

	public float getFirstLineIndent() {
		return firstLineIndent;
	}

	public void setFirstLineIndent(float firstLineIndent) {
		this.firstLineIndent = firstLineIndent;
	}

	public float getIndentationLeft() {
		return indentationLeft;
	}

	public void setIndentationLeft(float indentationLeft) {
		this.indentationLeft = indentationLeft;
	}

}
