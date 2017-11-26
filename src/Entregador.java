
public class Entregador extends Usuario{
	
	private double avaliacao = 5;
	private int contadorAvaliacao = 1; //Quantas avaliações já teve, pra calcular a média após nova avaliação
	private double tempoServico;
	private Localizacao localizacao = new Localizacao();
	
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
		
	public void setAvaliacao(double avaliacao) {
		double avaliacao_aux = this.avaliacao * contadorAvaliacao;
		contadorAvaliacao++;
		this.avaliacao = (avaliacao+avaliacao_aux)/contadorAvaliacao;
	}
	
	/* Metodo temporário enquanto não tem Banco de Dados */
	public String getEntregador(){
		Entregador entregador = new Entregador();
		entregador.setAvaliacao(5);
		entregador.setNome("Marcelo Ramón");
		entregador.setTempo_servico(1);
		
		return "\nNome: " + entregador.getNome() + "\nAvaliação: " + entregador.getAvaliacao() + " estrelas" +
		"\nTempo de serviço: " + entregador.getTempo_servico() + " meses\n";
	}
	
	public double getAvaliacao() {
		return avaliacao;
	}
	
	public double getTempo_servico() {
		return tempoServico;
	}
	public void setTempo_servico(double tempo_servico) {
		this.tempoServico = tempo_servico;
	}
	
}
