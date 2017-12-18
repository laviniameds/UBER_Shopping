package model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	
	private double valorTotalProdutos;
	private double valorTotalCompra;
	private double tempo;
        private double tempoComissao;
        private Date data;
	private String local;
	private ArrayList<Produto> produtos;
	private Localizacao localizacao;
	private double comissaoEntregador;
	
	public Compra(){
		this.produtos = new ArrayList<Produto>(50);
		this.localizacao = new Localizacao();
	}
	
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
	public void adicionarProduto(Produto produto){
		produtos.add(produto);
		this.valorTotalProdutos += (produto.getPreco() * produto.getQuantidade());
	}
        
        public void setValorTotalProdutos(double valor){
            this.valorTotalProdutos = valor;
        }
	
	public void removerProduto(Produto produto){
		if(this.produtos.contains(produto)){
			this.produtos.remove(produto);
			this.valorTotalProdutos -= (produto.getPreco() * produto.getQuantidade());
		}
	}
	
	public void setComissaoEntregador(){
		this.comissaoEntregador = ((this.getTempoComissao() + this.getValorTotalProdutos() 
				+ this.qtdProdutosCesta())*15)/100;
                if (this.comissaoEntregador < 7)
                    this.comissaoEntregador = 7;
	}
	
	public double getComissaoEntregador(){
		return this.comissaoEntregador;
	}
	
	public ArrayList<Produto> getCesta() {
		return this.produtos;
	}
	
	public int qtdProdutosCesta(){
		return this.produtos.size();
	}
	
	public boolean CestaVazia(){
		if(qtdProdutosCesta() == 0)
			return true;
		else
			return false;
	}

	public double getValorTotalProdutos() {
		return this.valorTotalProdutos;
	}
	
	public void setValorTotalCompra(){
		this.valorTotalCompra = getValorTotalProdutos() + getComissaoEntregador();
	}
	
	public double getValorTotalCompra(){
		return this.valorTotalCompra;
	}

	public double getTempo() {
		return tempo;
	}
        
        public double getTempoComissao() {
            return tempoComissao;
        }

	public void setTempo(Entregador entregador) {
                int aux = (int)(this.getLocalizacao().getDistanciaDefinida()/100);
		this.tempo = 20 + (int)(entregador.getLocalizacao().getDistanciaDefinida()/100) 
				+ aux;
                this.tempoComissao = 20 + aux;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }
	
}
