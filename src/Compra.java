
public class Compra {
	
	private double total;
	private double tempo;
	private String local; //Vamos ter que criar alguma funcao que compare localização dos bairros de Natal pra medir distância e usar pra calcular o tempo.
	private Produto produtos[];
	
	public void setQtdProdutos(int qtd) { //Para definir tamanho da array de produtos da compra.
		Produto aux[] = this.produtos;
		
		this.produtos = new Produto[qtd];
		if (aux != null) {
			for (int i = 0; i < aux.length; i++) {
				this.produtos[i] = aux[i];
			}
		}
	}
	
	public String getEntregador(){
		Entregador entregador = new Entregador();
		entregador.setAvaliacao(5);
		entregador.setNome("Marcelo Ramón");
		entregador.setTempo_servico(1);
		
		return "\nNome: " + entregador.getNome() + "\nAvaliação: " + entregador.getAvaliacao() + " estrelas" +
		"Tempo de serviço: " + entregador.getTempo_servico() + " meses\n";
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total += total; //Pra ir somando conforme for adicionando produtos.
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}
