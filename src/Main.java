import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Compra compra = new Compra();
		
		Localizacao localizacao = new Localizacao();
		
		int op = -1;		
		while(op != 0){
			System.out.println("#####\n1 - Fazer Compra\n0 - Sair");
			op = sc.nextInt();
			
			switch (op) {
			case 1:				
				System.out.println("Encontramos um entregador a " + localizacao.getDistancia() + " metros de você!");
				
				System.out.println(compra.getEntregador());
				
				System.out.println("\n1 - Aceitar entregador\n2 - Escolher outro entregador");
				
				break;

			default:
				break;
			}
		}

	}

}