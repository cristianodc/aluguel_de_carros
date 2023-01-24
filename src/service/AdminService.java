package service;

import java.util.List;
import java.util.Scanner;

import model.Admin;
import model.Cliente;
import model.Cliente.TipoPessoa;
import model.Veiculo;
import model.Veiculo.Segmento;
import model.Veiculo.Status;
import model.Vendedor;
import repository.AdminRepository;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import repository.VendedorRepository;

public class AdminService {

	private AdminRepository repository;
	private ClienteRepository clienteRepositository;
	private VendedorRepository vendedorRepository;
	private VeiculoRepository veiculoRepository;
	private Scanner sc;
	
	public AdminService(Scanner sc,ClienteRepository clienteRepository, VendedorRepository vendedorRepository,
			VeiculoRepository veiculoRepository) {
		this.repository = new AdminRepository();
		this.vendedorRepository = vendedorRepository;
		this.veiculoRepository= veiculoRepository;
		this.clienteRepositository = clienteRepository;
		this.sc = sc;
		// TODO Auto-generated constructor stub
	}
	public Admin buscarAdmindorPcpf(String cpf) {
		List<Admin> admins = this.repository.buscarTodos();
		
		for (Admin admin : admins) {
			if(admin.getCpf().equals(cpf)) {
				return admin;
			}
		}
		return null;
	}
	public void cadastrarPessoa(boolean cliente) {
		sc.nextLine();
		System.out.println("Digite o  nome do ");
		String nome = sc.nextLine();
		System.out.println("Digite o cpf do ");
		String cpf = sc.nextLine();
		System.out.println("Digite o endereco do ");
		String endereco = sc.nextLine();
		System.out.println("Crie  uma senha ");
		String senha = sc.nextLine();
		
		if(cliente) {
			System.out.println("Digite o tipo do cliente (PF ou PJ)");
			String tipo = sc.nextLine();
			Cliente novoCliente  =null;
			try {
				 novoCliente = new Cliente(nome, cpf, senha, endereco, TipoPessoa.valueOf(tipo));
			} catch (IllegalArgumentException e) {
				 System.out.println("TIPO INVÁLIDO , VAMOS SALVAR COMO PADRÃO PESSOA FISICA");
				 novoCliente = new Cliente(nome, cpf, senha, endereco, TipoPessoa.PF);
			}
			
			this.clienteRepositository.salvar(novoCliente);
			
		}else {
			System.out.println("Digite o Salario ");
			double salario = sc.nextDouble();
			Vendedor vendedor = new Vendedor(nome, cpf, senha, endereco, salario);
			this.vendedorRepository.salvar(vendedor);
		}
		
		
	}
	public void removerCliente() {
		
		List<Cliente> todosClientes = this.clienteRepositository.buscarTodos();
		
		for (Cliente cliente : todosClientes) {
			
			System.out.println(cliente.getId() + " -->> " + cliente.getNome());
		}
		
		System.out.println("Escolha qual cliente deseja excluir");
		
		int opcao = sc.nextInt();
		this.clienteRepositository.excluirPorid(opcao);
	}
	public void cadastrarVeiuclo() {
		
		sc.nextLine();
		System.out.println("Digite a marca do Veiculo");
		String marca = sc.nextLine();
		System.out.println("Digite  o modelo do Veiculo");
		String modelo = sc.nextLine();
		System.out.println("Digite a placa do veiculo");
		String placa = sc.nextLine();
		System.out.println("Digite a cor do veiculo");
		String cor = sc.nextLine();
		System.out.println("Digite o ano do veiculo");
		String ano = sc.nextLine();
		System.out.println("Digite o seguimentodo veiculoo");
		String seguimento = sc.nextLine();
		System.out.println("Digite o valor do veiculo");
		double valor = sc.nextDouble();
		Veiculo veiculo = null;
		try {
			veiculo =  new Veiculo(marca, modelo, placa, cor, ano, Segmento.valueOf(seguimento.toUpperCase()), valor);
			
		} catch (IllegalArgumentException e) {
			 System.out.println("TIPO INVÁLIDO VAMOS ADD COMO SEGMENTO PADÃO CARRO");
			 veiculo =  new Veiculo(marca, modelo, placa, cor, ano, Segmento.CARRO, valor);
		}
		
		this.veiculoRepository.salvar(veiculo);
		
	}
	
	public void removerVeiculo() {

		List<Veiculo> todosVeiculos = this.veiculoRepository.buscarTodos();
		
		for (Veiculo veiculo : todosVeiculos) {
			
			System.out.println(veiculo.getId() + " -->> " + veiculo.getModelo());
		}
		
		System.out.println("Escolha qual veiculo deseja excluir");
		
		int opcao = sc.nextInt();
		this.veiculoRepository.excluirPorid(opcao);
	}
	
	public void removerVendedor() {
		List<Vendedor> todosVendedores = this.vendedorRepository.buscarTodos();
		
		System.out.println("Escolha qual vendedor sera excluido");
		
		for (Vendedor vendedor : todosVendedores) {
			System.out.println(vendedor.getId()+" --> " + vendedor.getNome());
		}
		
		int opcao = sc.nextInt();
		
		this.vendedorRepository.excluirPorid(opcao);
	}
}
