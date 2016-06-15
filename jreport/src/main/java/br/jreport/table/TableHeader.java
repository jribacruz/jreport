package br.jreport.table;

import br.jreport.enums.ColorJReport;
import br.jreport.style.TableHeaderStyleClass;

public class TableHeader {

	private String nome;

	private TableHeaderStyleClass style = new TableHeaderStyleClass();

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @author Nota: Espaçamento padrão 1f header
	 * 
	 **/
	public TableHeader(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @author Nota: Espaçamento padrão 1f header
	 * 
	 **/
	public TableHeader(String nome, TableHeaderStyleClass style) {
		super();
		this.nome = nome;
		this.style = style;
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * 
	 **/
	@Deprecated
	public TableHeader(String nome, float width) {
		super();
		this.nome = nome;
		style.setWidthHeaderTable(width);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * 
	 **/
	@Deprecated
	public TableHeader(String nome, float width, int colspan) {
		super();
		this.nome = nome;
		style.setWidthHeaderTable(width);
		style.setColspan(colspan);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * 
	 * @param backgroundTableColor
	 *            Cor de fundo do header
	 * 
	 **/
	@Deprecated
	public TableHeader(String nome, float width, int colspan, ColorJReport backgroundTableColor) {
		super();
		this.nome = nome;
		style.setWidthHeaderTable(width);
		style.setColspan(colspan);
		style.setBackgroundTableColor(backgroundTableColor);
	}

	/**
	 * @param nome:
	 *            Nome da coluna no header
	 * @param width:
	 *            Espaçamento que a coluna do header
	 * @param colspan
	 * 
	 * @param backgroundTableColor
	 *            Cor de fundo do header
	 * 
	 **/
	@Deprecated
	public TableHeader(String nome, float width, int colspan, ColorJReport backgroundTableColor, ColorJReport borderTableColor) {
		super();
		this.nome = nome;
		style.setWidthHeaderTable(width);
		style.setColspan(colspan);
		style.setBackgroundTableColor(backgroundTableColor);
		style.setBorderColor(borderTableColor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TableHeaderStyleClass getStyle() {
		return style;
	}

	public void setStyle(TableHeaderStyleClass style) {
		this.style = style;
	}

}
