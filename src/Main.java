import java.util.Scanner;


public class Main {
	
	public static int menuEntregador(Scanner sc, Entregador entregador, Localizacao localizacao){		
		System.out.println("Encontramos um entregador a " + localizacao.getDistancia() + " de você!");
		
		System.out.println(entregador.getEntregador());
		
		System.out.println("\n2 - Aceitar entregador\n3 - Escolher outro entregador");
		
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Entregador entregador = new Entregador();
		Localizacao localizacao = new Localizacao();
		
		int op = -1;		
		while(op != 0){
			System.out.println("#####\n1 - Fazer Compra\n0 - Sair");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				
				while(op != 2){
					op = menuEntregador(sc, entregador, localizacao);	
				}
				
				System.out.println("pronto");
				
				break;

			default:
				break;
			}
		}

	}

}