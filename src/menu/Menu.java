package menu;

public class Menu {

	public static void bemVindo() {
		System.out.println("==================================================");
		System.out.println("Bem vindo aou sistema de Aluguel de carros!");
		System.out.println("Para come�ar, digite seu CPF ");
		System.out.println("Digit 0 para sair ");
	}
	
	public static void opcoesCliente() {
		System.out.println();
		System.out.println("Escolha a Op��o");
		System.out.println("1 - Alugar um ve�culo");
		System.out.println("2 - Devolver um Veiculo");
		System.out.println("");
	}
	
	public static void opcoesAdmin() {
		System.out.println();
		System.out.println("Escolha a Op��o");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Remover Cliente");
		System.out.println("3 - Cadastrar Ve�culo");
		System.out.println("4 - Remover Ve�culo");
		System.out.println("5 - Cadastrar Vendedor");
		System.out.println("6 - Remover Vendedor");
		
	}
	
	public static void opcoesVendedor() {
		System.out.println();
		System.out.println("Escolha a Op��o");
		System.out.println("1 - Ver carros alugados");
		System.out.println("2 - Ver salario e comi�oes");
	}
	
	public static void tipoUsuario() {
		System.out.println("=======================================================");
		System.out.println("Bem vindo ao aluguel de carros");
		System.out.println("1 - Cliente");
		System.out.println("2 - Vendedor");
		System.out.println("3 - Administrador");
	}
}
