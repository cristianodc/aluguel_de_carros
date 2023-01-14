package principal;

import java.util.Scanner;

import menu.Menu;
import model.Cliente;
import service.ClienteService;

public class Principal {

	public static void main(String[] args) {
		/*Proximo video 05/12/2022*/
		Scanner sc = new Scanner(System.in);
		ClienteService clienteService =new ClienteService(sc);
		Menu.bemVindo();
		
		String cpf = sc .next();
		Cliente clienteLogado = clienteService.buscarCliPorCpf(cpf);
		
		if(clienteLogado != null) {
			
			System.out.println("LOGADO !!!!");
		}
			Menu.opcoesCliente();
			
			Menu.opcoesAdmin();
			
			Menu.opcoesVendedor();
		
		
	}
}
