package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import execptions.VeiculoException;
import execptions.VendedorException;
import menu.Menu;
import model.Admin;
import model.Cliente;
import model.Veiculo;
import model.Vendedor;
import service.AdminService;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;

public class Principal {

	public static void main(String[] args) throws Exception {
		/*
		 * Proximo video 12/12/2022 INICIAR EM 1:15 MIN
		 * ******************************************
		 * */
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean continua = true;
		Scanner sc = new Scanner(System.in);
		ClienteService clienteService =new ClienteService(sc);
		VeiculoService veiculoService = new VeiculoService(sc,formater);
		VendedorService vendedorService = new VendedorService(sc);
		AdminService adminService = new AdminService(sc,clienteService.getRepository(),vendedorService.getRepository(),veiculoService.getRepository());
		
		
		do {
			try {
				
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

							    	validou= clienteLogado.validarSenha(senha);
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
									Thread.sleep(2000);
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
							Vendedor vendedorLogado = null;
							do {
								Menu.bemVindo();
								
								String cpf = sc .next();
								if(cpf.equals("0")) {
									continua = false;
									break;
								}
							     vendedorLogado = vendedorService.buscarVendedorPcpf(cpf);
							     if(vendedorLogado != null) {
							    	    sc.nextLine();
										System.out.println(" Agora digite sua senha: ");
										
										String senha = sc.nextLine();

							    	validou= vendedorLogado.validarSenha(senha);
							     }else {
							    	 System.out.println(" Vendedor Não encontrado: Digite Novamente seu cpf ");
							     }
							  
							 }while(vendedorLogado == null || !validou);
							  Menu.opcoesVendedor();
							  int opcaoVendedor = sc.nextInt();
							  if(opcaoVendedor == 1) {
								  veiculoService.buscarAlugados();
								  Thread.sleep(2000);
							  }else if(opcaoVendedor == 2) {
								  
								vendedorService.mostrarSalarioAtual(vendedorLogado);
							  }else {
								  System.out.println("OPCÃO INVÁLIDA");
							  }
							break;
						case 3:
							Admin adminLogado = null;
							do {
								Menu.bemVindo();
								
								String cpf = sc .next();
								if(cpf.equals("0")) {
									continua = false;
									break;
								}
								adminLogado = adminService.buscarAdmindorPcpf(cpf);
							     if(adminLogado != null) {
							    	    sc.nextLine();
										System.out.println(" Agora digite sua senha: ");
										
										String senha = sc.nextLine();

							    	   validou= adminLogado.validarSenha(senha);
							     }else {
							    	 System.out.println(" Vendedor Não encontrado: Digite Novamente seu cpf ");
							     }
							  
							 }while(adminLogado == null || !validou);
							   Menu.opcoesAdmin();
							   int opcaoAdmin  = sc.nextInt();
							   
							   switch(opcaoAdmin)
							   	{
							   case 1:
								   adminService.cadastrarPessoa(true);
								   break;
							   case 2:
								   adminService.removerCliente();
								   break;
							   case 3:
								   adminService.cadastrarVeiuclo();
									   break;
							   case 4:
								   adminService.removerVeiculo();
								   break;
							   case 5:
								   adminService.cadastrarPessoa(false);
								   break;
							   case 6:
								   adminService.removerVendedor();
								   break;
								   default:
									   System.out.println("OPCAO INVALIDA");
							   	}
							   
							 
							
						}
			} catch (VeiculoException e) {
				System.out.println(e.getMessage());
			} catch (VendedorException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				
				System.out.println("TIPO DE ENTRADA INVÁLIDO");
				sc.nextLine();
			}
														
		}while(continua);
		
		
		
	}
}
