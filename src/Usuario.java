
public class Usuario {
	
	private String nome;
	private double avaliacao = 5;
	private int contadorAvaliacao = 1; //Quantas avaliações já teve, pra calcular a média após nova avaliação
	private Localizacao localizacao = new Localizacao();

	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
	public void setAvaliacao(double avaliacao) {
		double avaliacao_aux = this.avaliacao * contadorAvaliacao;
		contadorAvaliacao++;
		this.avaliacao = (avaliacao+avaliacao_aux)/contadorAvaliacao;
	}
	
	public double getAvaliacao() {
		return avaliacao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
