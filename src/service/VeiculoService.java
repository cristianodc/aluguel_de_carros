package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.Veiculo;
import model.Veiculo.Status;
import repository.VeiculoRepository;

public class VeiculoService {

	private VeiculoRepository repository;
	DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Scanner sc;
	
	public VeiculoService(Scanner sc, DateTimeFormatter fm) {
		// TODO Auto-generated constructor stub
		this.repository = new VeiculoRepository();
		this.formater = fm;
		this.sc = sc;
		
	}
	
	public void buscarTodos() {
		
		List<Veiculo> todosVeiculos = this.repository.buscarTodos();
		
		for (Veiculo veiculo : todosVeiculos) {
			if(veiculo.getStatus() == Status.LIVRE) {
				System.out.println(veiculo);
			}
			
		}
	}
	
	public Veiculo alugaVeiculo(int id, int dias) {
		Veiculo  veiculo = this.repository.buscarPorId(id);
		
		if(veiculo.getStatus() == Status.ALUGADO)
			{
				System.out.println("Veiculo Alugado");
				return null;
			}
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataEntregue = dataAtual.plusDays(dias);
		veiculo.setStatus(Status.ALUGADO);
	
		veiculo.setDataEntrega(dataEntregue);
		
		System.out.println("O veiculo devera ser entregue no dia  " + dataEntregue.format(formater));
		return veiculo;
	}

	public void devolverVeiuclo(int opcaoVeiculo) {
		 Veiculo veiculo = this.repository.buscarPorId(opcaoVeiculo);
		 veiculo.setStatus(Status.LIVRE);
		
	}
	
		
}
