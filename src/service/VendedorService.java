package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

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
	
	public void gerarComissao(int idVendedor,Veiculo veiculo) {
		LocalDate dataAtual = LocalDate.now();
		long qtd_dias = veiculo.getDataEntrega().until(dataAtual,ChronoUnit.DAYS);
		double totalVenda = veiculo.getValor() * qtd_dias;
		double comissao = totalVenda  * Vendedor.PORCENTAGEM_COMISSAO;
		Vendedor vendedor = this.repository.buscarPorId(idVendedor);
		vendedor.setComissao(vendedor.getComissao() + comissao);
		System.out.println("COMISSAO VENDEDOR" + vendedor.getComissao());
	}
	
}
