package br.jreport.core;

import java.awt.Color;

import br.jreport.enums.FontStyle;
import br.jreport.enums.TextAlign;
import br.jreport.enums.TextDecoration;

public class TextStyleClass {

	/**	Font **/ 
	private FontStyle fontStyle;
	
	private float fontSize;

	private Color fontColor;

	private TextDecoration textDecoration;

	private Color backgroudColor;

	
	/**	Paragraph identation **/ 
	private float firstLineIndent;

	private float indentationLeft;
	
	private TextAlign textAlign;

	public TextStyleClass() {
		super();
		this.textAlign = TextAlign.JUSTIFIED;
		this.fontSize = 9;
		this.fontStyle = FontStyle.NORMAL;
		this.fontColor = Color.BLACK;
		this.textDecoration = TextDecoration.NONE;
		this.indentationLeft = 0;
		this.firstLineIndent = 0;
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
