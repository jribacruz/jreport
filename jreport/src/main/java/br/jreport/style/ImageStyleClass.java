package br.jreport.style;

import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.enums.ImageAlign;

public class ImageStyleClass {

	private ImageAlign align = ImageAlign.CENTER;

	public ImageStyleClass() {

	}

	public ImageStyleClass(String style) {
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setAlign(map.get("align"));
			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAlign(String textAlign) {
		if (textAlign != null) {
			this.align = ImageAlign.valueOf(textAlign.trim().toUpperCase());
		}
	}

	public ImageAlign getAlign() {
		return align;
	}

	public void setAlign(ImageAlign textAlign) {
		this.align = textAlign;
	}

}
