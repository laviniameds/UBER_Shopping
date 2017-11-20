
public class Compra {
	
	private double total;
	private double tempo;
	private String local;
	private Produto produtos[];
	
	public void setQtdProdutos(int qtd) { 
		Produto aux[] = this.produtos;
		
		this.produtos = new Produto[qtd];
		if (aux != null) {
			for (int i = 0; i < aux.length; i++) {
				this.produtos[i] = aux[i];
			}
		}
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
