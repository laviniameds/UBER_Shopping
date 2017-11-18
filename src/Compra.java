
public class Compra {

	private double total;
	private double tempo;
	private String local; //Vamos ter que criar alguma funcao que compare localização dos bairros de Natal pra medir distância e usar pra calcular o tempo.
	private Produto produtos[] = new Produto[10];
	
	public void setTamanho(int tamanho) { //Para definir tamanho da array de produtos da compra.
		Produto aux[] = produtos;
		
		produtos = new Produto[tamanho];
		if (aux != null) {
			for (int i = 0; i < aux.length; i++) {
				produtos[i] = aux[i];
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
