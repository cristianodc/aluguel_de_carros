package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import menu.Menu;
import model.Cliente;
import model.Veiculo;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;

public class Principal {

	public static void main(String[] args) {
		/*Proximo video 07/12/2022 1:07 hs*/
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean continua = true;
		Scanner sc = new Scanner(System.in);
		ClienteService clienteService =new ClienteService(sc);
		VeiculoService veiculoService = new VeiculoService(sc,formater);
		VendedorService vendedorService = new VendedorService(sc);
		
		
		do {
			Cliente clienteLogado = null;
			boolean validou = false;
			
					Menu.tipoUsuario();
					int tipoUso = sc.nextInt();
					switch(tipoUso) 
							{
						case 1:
							do {
								Menu.bemVindo();
								
								String cpf = sc .next();
								if(cpf.equals("0")) {
									continua = false;
									break;
								}
							     clienteLogado = clienteService.buscarCliPorCpf(cpf);
							     if(clienteLogado != null) {
							    	    sc.nextLine();
										System.out.println(" Agora digite sua senha: ");
										
										String senha = sc.nextLine();

							    	validou= clienteService.validarSenha(clienteLogado,senha);
							     }
							  
							 }while(clienteLogado == null || !validou);
							Menu.opcoesCliente();
							
							int opcaoCliente = sc.nextInt();
							if(opcaoCliente == 1) {
								System.out.println(" Escolha a opção referente ao veículo: ");
								veiculoService.buscarTodos();
								int opcaoVeiculo = sc.nextInt();
								System.out.println("Digite quantos dias de aluguel");
								int dias = sc.nextInt();
								
								Veiculo veiculo = veiculoService.alugaVeiculo(opcaoVeiculo,dias);
								clienteService.addVeiculo(clienteLogado, veiculo);
								System.out.println("Digite a opçao do vendedor ");
								
								vendedorService.motrarTodosVendedores();
								
								int opVendedor = sc.nextInt();
								
								vendedorService.gerarComissao(opVendedor, veiculo);
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println(clienteLogado);
							}else if(opcaoCliente == 2) {
								System.out.println(" Escolha a opção referente ao veículo: ");
								clienteService.motrarVeiculosAlugados(clienteLogado);
								int opcaoVeiculo = sc.nextInt();
								clienteService.removerVeiculo(clienteLogado, opcaoVeiculo);
								veiculoService.devolverVeiuclo(opcaoVeiculo);
							}
							
							break;
						case 2:
							
							break;
						case 3:
							break;
						}
						
						
						
						
						Menu.opcoesAdmin();
						
						Menu.opcoesVendedor();
			
		}while(continua);
		
		
		
	}
}
