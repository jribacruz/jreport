package br.jreport.table;

import br.jreport.style.defined.DetaultTableHeaderStyleClass;

public class TableHeader {

	private String nome;

	private DetaultTableHeaderStyleClass style = new DetaultTableHeaderStyleClass();

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
	public TableHeader(String nome, DetaultTableHeaderStyleClass style) {
		super();
		this.nome = nome;
		this.style = style;
	}
	
	public TableHeader(String nome, String style) {
		super();
		this.nome = nome;
		this.style = new DetaultTableHeaderStyleClass(style);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DetaultTableHeaderStyleClass getStyle() {
		return style;
	}

	public void setStyle(DetaultTableHeaderStyleClass style) {
		this.style = style;
	}

}
