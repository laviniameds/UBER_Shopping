package modelo;

import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private ArrayList<Compra> compras;
	
	public Cliente() {
		this.compras = new ArrayList<Compra>(50);
		setAvaliacao(5);
		setNome("Carlos Manuel");
		setLogin("manuel");
		setSenha("123");
	}
	
	public void adicionarHistoricoDeCompra(Compra compra){
		compras.add(compra);
	}
		
}
