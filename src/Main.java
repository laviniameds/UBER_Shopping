import java.util.Scanner;


public class Main {
	
	public static int menuEntregador(Scanner sc, Entregador entregador, Localizacao localizacao){	
		
			System.out.println("Encontramos um entregador a " + localizacao.getDistancia() + " de você!");
			
			System.out.println(entregador.getEntregador());
			
			System.out.println("#####\nConfirmar Pedido\n	21 - Aceitar entregador\n	22 - Escolher outro entregador\n9 - Voltar\n");
		
		return sc.nextInt();
	}
	
	public static int menuCompra(Scanner sc){
		System.out.println("#####\nFazer Compra\n	11 - Consultar Menu\n	12 - Cadastrar produto\n9 - Voltar\n");
		return sc.nextInt();
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Entregador entregador = new Entregador();
		Localizacao localizacao = new Localizacao();
		Compra compra = new Compra();
		
		int op = -1;		
		while(op != 0){
			System.out.println("#####\n1 - Fazer Compra\n2 - Ver Cesta\n3 - Confirmar Pedido\n0 - Sair");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				op = menuCompra(sc);
				if (op == 11) {
					//Fazer um menu genérico dividido em categorias
				}
				else if (op == 12) {
					Produto produto = new Produto();
					int catOp;
					System.out.println("Selecione a categoria:\n[1] - Alimentos\n[2] - Vestuário\n[3] - Eletrônicos\n[4] - Material de limpeza\n[5] - Diversos\n");
					catOp = sc.nextInt();
					switch (catOp) {
					case 1:
						produto.setCategoria("Alimentos");
						break;
					case 2:
						produto.setCategoria("Vestuário");
						break;
					case 3:
						produto.setCategoria("Eletrônicos");
						break;
					case 4:
						produto.setCategoria("Material de Limpeza");
						break;
					default:
						produto.setCategoria("Diversos");
						break;
					}
					System.out.print("Nome: ");
					sc.nextLine();
					produto.setNome(sc.nextLine());
					System.out.print("Preço: R$");
					produto.setPreco(sc.nextFloat());
					/*
					if (produto.getCategoria().equalsIgnoreCase("Alimentos") || produto.getCategoria().equalsIgnoreCase("Material de limpeza")) {
						System.out.print("Unidade: ");
						produto.setUnidade(sc.next());
					}
					else produto.setUnidade("Unitário"); 
					*/ 
					System.out.print("Quantidade: ");
					produto.setQuantidade(sc.nextInt());
					
					compra.adicionarProduto(produto);
				}
				break;
			case 2:
				if (compra.getCesta().size() == 0) System.out.println("\n-- Cesta vazia --\n");
				else {
					System.out.println();
					for (int i = 0; i < compra.getCesta().size(); i++) {
						System.out.println("---------------");
						System.out.println("Item " + (i+1) + " - " +compra.getCesta().get(i).getNome());
						System.out.println("R$ " + compra.getCesta().get(i).getPreco());
						System.out.println(compra.getCesta().get(i).getQuantidade() + " unidades");
					}
					System.out.println("---------------");
					System.out.println("Total R$ " + compra.getTotal());
					System.out.println("---------------\n");
				}
				break;
			case 3:
				op = 22;
				while(op == 22){
					op = menuEntregador(sc, entregador, localizacao);	
				}
				if (op == 21) System.out.println("Confirmado!\nSua compra chegará em até [VER TEMPO].");
				
				break;

			default:
				break;
			}
		}

	}

}