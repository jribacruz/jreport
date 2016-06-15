package br.jreport.enums;

public enum FontStyle {
	NORMAL(0), BOLD(1), ITALIC(2);

	private int value;

	private FontStyle(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
