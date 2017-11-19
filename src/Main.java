import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Entregador entregador = new Entregador();
		Usuario usuario = new Cliente();
		
		int op = -1;		
		while(op != 0){
			System.out.println("#####\n1 - Fazer Compra\n0 - Sair");
			op = sc.nextInt();
			
			System.out.println("Confirme sua localização: ");
		}
	}

}
