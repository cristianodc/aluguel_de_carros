package service;

import java.util.Scanner;

import model.Cliente;
import model.Cliente.TipoPessoa;
import repository.ClienteRepository;
import util.Contador;

public class ClienteService {

	private ClienteRepository repository;
	private Scanner sc;
	
	public ClienteService(Scanner sc) {
		this.repository= new ClienteRepository();
		this.sc  = sc;
	}
	
	public Cliente buscarCliPorCpf(String cpf) {
		
		Cliente cliente = this.repository.buscarPorCpf(cpf);
		
		if(cliente == null) {
			
			return this.criarCliente(cpf);
		}
		return cliente;
	}
	
	private Cliente criarCliente(String cpf) {
		sc.nextLine();
		System.out.println("Digite seu nome");
		String nome = sc.nextLine();
		System.out.println("Digite seu endereco");
		String endereco = sc.nextLine();
		System.out.println("Digite sua senha");
		String senha = sc.nextLine();
		System.out.println("Digite PF para pessoa fisica ou PJ para pessoa juridica");
		String tipo = sc.next();
		TipoPessoa tipoPessoa;
		if(tipo.equalsIgnoreCase("PF")) {
			tipoPessoa= TipoPessoa.PF;
		}else {
			tipoPessoa= TipoPessoa.PJ;
		}
		
		Cliente cliente = new Cliente(nome, cpf, senha, endereco, tipoPessoa);
		
		return this.repository.salvar(cliente);
	}
}
