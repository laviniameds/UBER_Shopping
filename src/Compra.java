import java.util.ArrayList;

public class Compra {
	
	private double total;
	private double tempo;
	private String local;
	private ArrayList<Produto> produtos;
	
	public void adicionarProduto(Produto produto){
		produtos.add(produto);
		this.total += (produto.getPreco() * produto.getQuantidade());
	}
	
	public void removerProduto(Produto produto){
		produtos.remove(produto);
		this.total -= (produto.getPreco() * produto.getQuantidade());
	}

	public double getTotal() {
		return total;
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
