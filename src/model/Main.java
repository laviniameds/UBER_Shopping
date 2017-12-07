package model;

import java.util.Scanner;


public class Main {  
    
        public static void main(String[] args) {
            
           Cliente c = new Cliente();
           new view.Cliente.LoginView(c).setVisible(true);
                       
        } 
               
        
	/*public static int menuEntregador(Scanner sc, Entregador entregador, Compra compra){	
		
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
	
	public static int lerInteiro(Scanner sc) {
		int op ;
		try {
			op = sc.nextInt();
		}
		catch (Exception e) {
			System.out.println("Opção inválida.");
			sc.nextLine();
			op = 404;
		}
		return op;
	}
	
	public static boolean validarLogin(Usuario usuario, String login, String senha) {
		
		if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
			return true;
		}
		
		System.out.println("Usuário ou senha incorretos");
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Entregador entregador = new Entregador();
		Cliente cliente = new Cliente();
		Compra compra = new Compra();
		String login;
		String senha;
		int op;
		boolean ok;
		
		do {
			System.out.println("UBER SHOPPING\n");
			System.out.print("Entrar como:\n[1] Cliente\n[2] Entregador\n-> ");
			op = lerInteiro(sc);
		}while(op == 404 || op < 1 || op > 2);
		
		//INTERFACE DO USUARIO
		if (op == 1) {
			
			do {
				System.out.print("Login: ");
				login = sc.next();
				System.out.print("Senha: ");
				senha = sc.next();
			} while(!validarLogin(cliente, login, senha));
			
			while(op != 0){
				do {
					System.out.println("\n#####\n1 - Comprar\n2 - Confirmar Pedido\n0 - Sair");
					op = lerInteiro(sc);
				}while (op == 404);
				
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
							String catOp;
							
							do {
								ok = false;
								System.out.println("Selecione a categoria:\n[1] - Alimentos\n[2] - Vestuário\n[3] - Eletrônicos\n[4] - Material de limpeza\n[5] - Diversos\n");
								catOp = sc.next();
								switch (catOp) {
								case "1":
									produto.setCategoria("Alimentos");
									break;
								case "2":
									produto.setCategoria("Vestuário");
									break;
								case "3":
									produto.setCategoria("Eletrônicos");
									break;
								case "4":
									produto.setCategoria("Material de Limpeza");
									break;
								case "5":
									produto.setCategoria("Diversos");
									break;
								default:
									System.out.println("Opção inválida");
									ok = true;
									break;
								}
							}while(ok);
							
							System.out.print("Nome: ");
							sc.nextLine();
							produto.setNome(sc.nextLine());
							do {
								System.out.print("Preço: R$ ");
								produto.setPreco(sc.nextFloat());
							}while(produto.getPreco() < 0.01);
							do {
								System.out.print("Quantidade: ");
								produto.setQuantidade(sc.nextInt());
							}while(produto.getQuantidade() < 1);
							compra.adicionarProduto(produto);
						}
						else if (op == 12) {
							if (compra.CestaVazia()) System.out.println("\n-- Cesta vazia --\n");
							else {
								System.out.println();
								exibirCesta(compra);
								try {
									System.out.print("Digite o número do produto que deseja excluir\n-> ");
									compra.removerProduto(compra.getCesta().get(sc.nextInt()-1));
									System.out.println("\nProduto excluído.\n");									
								}
								catch (Exception e) {
									System.out.println("Opção inválida");
								}
							}
						}
						else if (op == 13) {
							if (compra.CestaVazia()) System.out.println("\n-- Cesta vazia --\n");
							else {
								System.out.println("\nLocal: " + compra.getLocal());
								exibirCesta(compra);
								
								System.out.println("\n\nValor da compra:" + compra.getValorTotalProdutos());
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
							compra.setComissaoEntregador();
							compra.setValorTotalCompra();
							System.out.println("Confirmado!\nSua compra chegará em até " + compra.getTempo() + " minutos.");
							
							System.out.println("\nValor da compra:" + compra.getValorTotalProdutos());
							System.out.println("Taxa de Serviço: R$ " + compra.getComissaoEntregador());
							System.out.println("\n\nTotal: R$ " + compra.getValorTotalCompra() + "\n");
							System.out.print("\nAvalie nosso entregador " + entregador.getNome() + " (0 a 5)\n-> ");
							entregador.setAvaliacao(sc.nextDouble());
							System.out.println("Obrigado!\nAvaliacão atual: " + String.format("%.1f", entregador.getAvaliacao()));
							cliente.adicionarHistoricoDeCompra(compra);
							compra = new Compra();
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
		//INTERFACE DO ENTREGADOR
		else if (op == 2) {
			do {
                            System.out.print("Login: ");
                            login = sc.next();
                            System.out.print("Senha: ");
                            senha = sc.next();
                                
			} while(!validarLogin(entregador, login, senha));
		}

	}*/

}