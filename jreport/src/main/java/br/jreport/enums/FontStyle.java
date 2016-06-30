package br.jreport.enums;

public enum FontStyle {
	NORMAL(0), BOLD(1), ITALIC(2);
//	TODO mudança para novo padrão Font f = new Font(Font.HELVETICA, 10, Font.BOLDITALIC);
	private int value;

	private FontStyle(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
