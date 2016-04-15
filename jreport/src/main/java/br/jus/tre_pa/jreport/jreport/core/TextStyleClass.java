package br.jus.tre_pa.jreport.jreport.core;

import java.awt.Color;

import br.jus.tre_pa.jreport.jreport.enums.FontStyle;
import br.jus.tre_pa.jreport.jreport.enums.TextAlign;
import br.jus.tre_pa.jreport.jreport.enums.TextDecoration;

public class TextStyleClass {

	private FontStyle fontStyle;

	private TextAlign textAlign;

	private float fontSize;

	private Color fontColor;

	private Color backgroudColor;

	private TextDecoration textDecoration;

	private float firstLineIndent;

	private float indentationLeft;

	public TextStyleClass() {
		super();
		this.textAlign = TextAlign.JUSTIFIED;
		this.fontSize = 9;
		this.fontStyle = FontStyle.NORMAL;
		this.fontColor = Color.BLACK;
		this.textDecoration = TextDecoration.NONE;
		this.indentationLeft = 0;
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
