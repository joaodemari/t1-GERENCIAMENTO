package bean;

public class Item {
	private String nome;
	private String descricao;
	private double valUnitario;
	private int quantidade;

	public Item(String nome, String descricao, double valUnitario, int quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.valUnitario = valUnitario;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValUnitario() {
		return valUnitario;
	}

	public void setValUnitario(double valUnitario) {
		this.valUnitario = valUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return this.valUnitario * this.quantidade;
	}

}
