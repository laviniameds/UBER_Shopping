package modelo;


public class Produto {

	private String nome;
	private float preco;
	//private String unidade; //Exemplo: Unitário, 2 litros (refrigerante), 10kg (ração).
	private int quantidade;


	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	/*
	public String getUnidade() {
		return unidade;
	}
	*/
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	/*
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	*/
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}