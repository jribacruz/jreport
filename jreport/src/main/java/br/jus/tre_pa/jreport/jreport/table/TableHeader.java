package br.jus.tre_pa.jreport.jreport.table;

public class TableHeader {

	private String nome;
	
	private float width = 1f;
	
	private int colspan = 1;
	
	//private TextStyleClass style;
	
	/**
	 * @param nome: Nome da coluna no header
	 * @author Nota: Espaçamento padrão 1f header
	 * 
	 * **/
	public TableHeader(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * @param nome: Nome da coluna no header
	 * @param width: Espaçamento que a coluna do header
	 * 
	 * **/
	public TableHeader(String nome, float width) {
		super();
		this.nome = nome;
		this.width = width;
	}
	
	/**
	 * @param nome: Nome da coluna no header
	 * @param width: Espaçamento que a coluna do header
	 * @param colspan
	 * 
	 * **/
	public TableHeader(String nome, float width, int colspan) {
		super();
		this.nome = nome;
		this.width = width;
		this.colspan = colspan;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
	
}
