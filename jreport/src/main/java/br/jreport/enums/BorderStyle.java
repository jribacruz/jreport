package br.jreport.enums;

import com.lowagie.text.Rectangle;

public enum BorderStyle {
	//@formatter:off
	BOX(Rectangle.BOX), 
	BOTTOM(Rectangle.BOTTOM), 
	LEFT(Rectangle.LEFT), 
	TOP(Rectangle.TOP),
	RIGHT(Rectangle.RIGHT),
	LEFT_TOP_BOTTOM(Rectangle.LEFT | Rectangle.TOP | Rectangle.BOTTOM),
	TOP_BOTTOM(Rectangle.TOP | Rectangle.BOTTOM),
	RIGHT_TOP_BOTTOM(Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
	//@formatter:on

	private int border;

	private BorderStyle(int border) {
		this.border = border;
	}

	public int getBorder() {
		return border;
	}

}
