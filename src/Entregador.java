
public class Entregador extends Usuario{
	
	private double avaliacao = 5;
	private int cont_avaliacao = 1; //Quantas avaliações já teve, pra calcular a média após nova avaliação
	private double tempo_servico;
	
	public double getAvaliacao() {
		return avaliacao;
	}	
	public void setAvaliacao(double avaliacao) {
		double avaliacao_aux = this.avaliacao * cont_avaliacao;
		cont_avaliacao++;
		this.avaliacao = (avaliacao+avaliacao_aux)/cont_avaliacao;
	}
	public double getTempo_servico() {
		return tempo_servico;
	}
	public void setTempo_servico(double tempo_servico) {
		this.tempo_servico = tempo_servico;
	}
	
}
