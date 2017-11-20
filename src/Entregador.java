
public class Entregador extends Usuario{
	
	private double avaliacao = 5;
	private int cont_avaliacao = 1; //Quantas avaliações já teve, pra calcular a média após nova avaliação
	private double tempo_servico;
	private double comissao;
		
	public void setAvaliacao(double avaliacao) {
		double avaliacao_aux = this.avaliacao * cont_avaliacao;
		cont_avaliacao++;
		this.avaliacao = (avaliacao+avaliacao_aux)/cont_avaliacao;
	}
	
	/* Metodo temporário enquanto não tem Banco de Dados */
	public String getEntregador(){
		Entregador entregador = new Entregador();
		entregador.setAvaliacao(5);
		entregador.setNome("Marcelo Ramón");
		entregador.setTempo_servico(1);
		
		return "\nNome: " + entregador.getNome() + "\nAvaliação: " + entregador.getAvaliacao() + " estrelas" +
		"Tempo de serviço: " + entregador.getTempo_servico() + " meses\n";
	}
	
	public void setComissaoEntregador(double tempoCompra, double totalCompra, int qtdProdutos){
		this.comissao = ((tempoCompra + totalCompra + qtdProdutos)*30)/100;
	}
	
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	
	public double getTempo_servico() {
		return tempo_servico;
	}
	public void setTempo_servico(double tempo_servico) {
		this.tempo_servico = tempo_servico;
	}
	
}
