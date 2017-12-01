
public class Entregador extends Usuario{
	
	private double tempoServico;
	
	public Entregador() {
		setAvaliacao(5);
		setNome("Marcelo Ramón");
		setTempo_servico(1);
		setLogin("ramon");
		setSenha("123");
	}
	
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
