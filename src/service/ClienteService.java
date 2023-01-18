package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Cliente.TipoPessoa;
import model.Veiculo;
import repository.ClienteRepository;

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

	public boolean validarSenha(Cliente clienteLogado, String senha) {
		
		return clienteLogado.getSenha().equals(senha);
	
	}
	
	public void addVeiculo(Cliente cli,Veiculo veiculo) 
		{
			if(cli.getVeiculosAlugados() == null) {
				cli.setVeiculosAlugados(new ArrayList<>());
			}
			
			cli.getVeiculosAlugados().add(veiculo);
			LocalDate dataAtual = LocalDate.now();
			long qtd_dias = veiculo.getDataEntrega().until(dataAtual,ChronoUnit.DAYS);
			
			cli.setDebitos(cli.getDebitos() +( veiculo.getValor()* qtd_dias));
			
		}

	public void motrarVeiculosAlugados(Cliente clienteLogado) {
		List<Veiculo> veiculos = clienteLogado.getVeiculosAlugados();
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo);
		}
	}

	public void removerVeiculo(Cliente clienteLogado,int idVeiculo) {
		
		for(int i=0; i < clienteLogado.getVeiculosAlugados().size(); i++) {
			
			if(clienteLogado.getVeiculosAlugados().get(i).getId() == idVeiculo) 
				{
					clienteLogado.getVeiculosAlugados().remove(i);
				}
		}
			
		}
		
	
}
