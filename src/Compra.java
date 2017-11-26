import java.util.ArrayList;

public class Compra {
	
	private double total;
	private double tempo;
	private String local;
	private ArrayList<Produto> produtos;
	private Localizacao localizacao;
	
	public Compra(){
		this.produtos = new ArrayList<Produto>(10);
		this.localizacao = new Localizacao();
	}
	
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
	public void adicionarProduto(Produto produto){
		produtos.add(produto);
		this.total += (produto.getPreco() * produto.getQuantidade());
	}
	
	public void removerProduto(Produto produto){
		if(this.produtos.contains(produto)){
			this.produtos.remove(produto);
			this.total -= (produto.getPreco() * produto.getQuantidade());
		}
	}
	
	public ArrayList<Produto> getCesta() {
		return this.produtos;
	}
	
	public boolean CestaVazia(){
		if(this.produtos.size() == 0)
			return true;
		else
			return false;
	}

	public double getTotal() {
		return total;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(Entregador entregador) {
		this.tempo = 20 + (int)(entregador.getLocalizacao().getDistanciaDefinida()/100) 
				+ (int)(this.getLocalizacao().getDistanciaDefinida()/100);
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}
