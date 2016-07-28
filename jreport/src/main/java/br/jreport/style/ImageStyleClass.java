package br.jreport.style;

import java.util.Map;

import com.google.common.base.Splitter;

import br.jreport.enums.ImageAlign;

public class ImageStyleClass {

	private ImageAlign align = ImageAlign.CENTER;

	private Float width;

	private Float height;

	public ImageStyleClass() {

	}

	public ImageStyleClass(String style) {
		try {
			if (style.contains(":")) {
				Map<String, String> map = Splitter.on(";").trimResults().omitEmptyStrings().withKeyValueSeparator(":").split(style);
				setAlign(map.get("align"));
				setWidth(map.get("width"));
				setHeight(map.get("height"));
			} else {
				throw new Exception("formato css inválido, chave e valor separados por ':' e elementos separados por ';' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setWidth(String width) {
		if (width != null) {
			this.width = Float.valueOf(width.trim().toUpperCase());
		}
	}

	public void setHeight(String height) {
		if (height != null) {
			this.height = Float.valueOf(height.trim().toUpperCase());
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

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

}
