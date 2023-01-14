package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Veiculo;
import util.Contador;

public class VeiculoRepository implements Repository<Veiculo> {

	private Map<Integer,Veiculo> veiculoRepository;
	
	public VeiculoRepository() {
		this.veiculoRepository = new HashMap<>();
	}
	public List<Veiculo> buscarTodos() {
		
		Collection<Veiculo> veiculosColl = veiculoRepository.values();
		
		List<Veiculo> veiculos = veiculosColl.stream().collect(Collectors.toList());
		
		return veiculos;
	}

	@Override
	public Veiculo buscarPorId(Integer id) {
	
		return this.veiculoRepository.get(id);
	}
	@Override
	public void excluirPorid(Integer id) {
		this.veiculoRepository.remove(id);
		
	}
	@Override
	public Veiculo salvar(Veiculo veiculo) {
		this.veiculoRepository.put(veiculo.getId(), veiculo);
		return veiculo;
	}

}
