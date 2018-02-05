package br.jreport.style.defined;

import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.style.TableDataStyleClass;

public class DetaultColspanLineStyleClass extends TableDataStyleClass {
	/** Tamanho do espaço entre uma célula e outra, da table **/

	private Float borderWidth = 0F;
	private Float borderTopWidth = null;
	private Float borderLeftWidth = null;
	private Float borderRightWidth = null;
	private Float borderBottomWidth = null;

	public DetaultColspanLineStyleClass() {
		super();
		setBorderBottomWidth(0f);
		setBorderLeftWidth(0f);
		setBorderRightWidth(0f);
		setBorderTopWidth(0f);
	}

	public DetaultColspanLineStyleClass(String style) {
		super(style);
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);

				setBorderWidth(map.get("border-width"));
				setBorderTopWidth(map.get("border-top-width"));
				setBorderLeftWidth(map.get("border-left-width"));
				setBorderRightWidth(map.get("border-right-width"));
				setBorderBottomWidth(map.get("border-bottom-width"));

			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public Float getBorderWidth() {
		return borderWidth;
	}

	public Float getBorderTopWidth() {
		return borderTopWidth;
	}

	public Float getBorderLeftWidth() {
		return borderLeftWidth;
	}

	public Float getBorderRightWidth() {
		return borderRightWidth;
	}

	public Float getBorderBottomWidth() {
		return borderBottomWidth;
	}

}
