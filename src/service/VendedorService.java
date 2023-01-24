package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import execptions.VendedorException;
import model.Veiculo;
import model.Vendedor;
import repository.VendedorRepository;

public class VendedorService {

	private VendedorRepository repository;
	private Scanner sc;
	
	public VendedorService(Scanner sc) {
		this.repository = new VendedorRepository();
		this.sc = sc;
	}
	
	public void motrarTodosVendedores() {
		List<Vendedor> vendedores = this.repository.buscarTodos();
		
		for (Vendedor vendedor : vendedores) {
			
			System.out.println(vendedor);
		}
	}
	
	public void gerarComissao(int idVendedor,Veiculo veiculo) throws VendedorException {
		LocalDate dataAtual = LocalDate.now();
		veiculo.getDataEntrega();
		
		long qtd_dias = dataAtual.until(veiculo.getDataEntrega(),ChronoUnit.DAYS);
		double totalVenda = veiculo.getValor() * qtd_dias;
		double comissao = totalVenda  * Vendedor.PORCENTAGEM_COMISSAO;
		Vendedor vendedor = this.repository.buscarPorId(idVendedor);
		if(vendedor == null) {
			
			throw new VendedorException("Vendedor não encontrado");
		}
		vendedor.setComissao(vendedor.getComissao() + comissao);
		System.out.println("COMISSAO VENDEDOR " + vendedor.getComissao());
	}

	public Vendedor buscarVendedorPcpf(String cpf) {
		List<Vendedor> vendidores  = this.repository.buscarTodos();
	
		for (Vendedor vendedor : vendidores) {
			if(vendedor.getCpf().equals(cpf)) {
				return vendedor;
			}
		}
		return null;
	}

	public void mostrarSalarioAtual(Vendedor vendedorLogado) {
		System.out.println(vendedorLogado.getNome() + "Seu salario e a comissao  " + (vendedorLogado.getSalario() + vendedorLogado.getComissao()));
		
	}

	public VendedorRepository getRepository() {
		return repository;
	}

	
	
}
