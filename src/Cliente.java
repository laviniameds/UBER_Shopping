import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private ArrayList<Compra> compras;
	
	public Cliente() {
		this.compras = new ArrayList<Compra>(50);
	}
	
	public void adicionarCompra(Compra compra){
		compras.add(compra);
	}
	
	public Cliente getCliente(){
		Cliente cliente = new Cliente();
		cliente.setAvaliacao(5);
		cliente.setNome("Carlos Manuel");
		
		return cliente;
	}
	
}
