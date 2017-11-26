import java.util.Scanner;


public class Main {
	
	public static int menuEntregador(Scanner sc, Entregador entregador, Compra compra){	
		
			Localizacao localizacao = entregador.getLocalizacao();
		
			System.out.println("Encontramos um entregador a " + localizacao.getDistancia() + " de " + compra.getLocal());
			
			System.out.println(entregador.getEntregador());
			
			System.out.println("#####\nConfirmar Pedido\n	21 - Aceitar entregador\n	22 - Escolher outro entregador\n9 - Voltar\n");
		
		return sc.nextInt();
	}
	
	public static int menuCompra(Scanner sc){
		System.out.println("\nComprar\n	11 - Inserir Produto\n	12 - Excluir Produto\n	13 - Ver Cesta\n9 - Voltar\n");
		return sc.nextInt();
	}
	
	public static void exibirCesta(Compra compra){
		for (int i = 0; i < compra.getCesta().size(); i++) {
			System.out.print("[" + (i+1) + "] - " + compra.getCesta().get(i).getQuantidade() + " x " +compra.getCesta().get(i).getNome());
			System.out.print(" - R$ " + compra.getCesta().get(i).getPreco() + "\n");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Entregador entregador = new Entregador();
		Compra compra = new Compra();
		
		int op = -1;		
		while(op != 0){
			System.out.println("#####\n1 - Comprar\n2 - Confirmar Pedido\n0 - Sair");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				if (compra.getLocal() == null) {
					System.out.print("Insira o local da compra: ");
					sc.nextLine();
					compra.setLocal(sc.nextLine());
					System.out.println(compra.getLocal() + " está a " + compra.getLocalizacao().getDistancia() + " da sua localização.");
				}
				op = 0;
				while (op != 9) {
					op = menuCompra(sc);
					if (op == 11) {
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
						System.out.print("Preço: R$ ");
						produto.setPreco(sc.nextFloat());
						System.out.print("Quantidade: ");
						produto.setQuantidade(sc.nextInt());
						
						compra.adicionarProduto(produto);
					}
					else if (op == 12) {
						if (compra.CestaVazia()) System.out.println("\n-- Cesta vazia --\n");
						else {
							System.out.println();
							exibirCesta(compra);
							System.out.print("Digite o número do produto que deseja excluir\n-> ");
							compra.removerProduto(compra.getCesta().get(sc.nextInt()-1));
							System.out.println("\nProduto excluído.\n");
						}
					}
					else if (op == 13) {
						if (compra.CestaVazia()) System.out.println("\n-- Cesta vazia --\n");
						else {
							System.out.println("\nLocal: " + compra.getLocal());
							exibirCesta(compra);
							System.out.println("\nTotal R$ " + compra.getTotal() + "\n");
						}	
					}
				}
				break;

			case 2:
				if (compra.CestaVazia()) {
					System.out.println("\nNão foi inserido nenhum produto na compra.\n");
				}
				else {
					op = 22;
					while(op == 22){
						op = menuEntregador(sc, entregador, compra);	
					}
					if (op == 21) {
						compra.setTempo(entregador);
						System.out.println("Confirmado!\nSua compra chegará em até " + compra.getTempo() + " minutos.");
					}
				}
					
				break;
				
			case 3:
				
				break;
				
			default:
			
				break;
			}
		}

	}

}