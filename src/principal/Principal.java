package principal;

import java.util.Scanner;

import menu.Menu;

public class Principal {

	public static void main(String[] args) {
		/*Proximo video 05/12/2022*/
		Scanner sc = new Scanner(System.in);
		
		Menu.bemVindo();
		
		String cpf = sc .next();
			Menu.opcoesCliente();
			
			Menu.opcoesAdmin();
			
			Menu.opcoesVendedor();
		
		
	}
}
