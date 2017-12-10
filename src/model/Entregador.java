package model;


public class Entregador extends Usuario{
	
	private double tempoServico;
	
	
	/* Metodo temporário enquanto não tem Banco de Dados */
	public String getEntregador(){
		return "\nNome: " + getNome() + "\nAvaliação: " + getAvaliacao() + " estrelas" +
		"\nTempo de serviço: " + getTempo_servico() + " meses\n";
	}
	
	public double getTempo_servico() {
		return tempoServico;
	}
	public void setTempo_servico(double tempo_servico) {
		this.tempoServico = tempo_servico;
	}
	
}
