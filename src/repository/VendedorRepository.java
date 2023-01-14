package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Vendedor;

public class VendedorRepository implements Repository<Vendedor> {

	private Map<Integer,Vendedor> vendedorRepository;
	
	private VendedorRepository() {
		this.vendedorRepository = new HashMap<>();
	}
	@Override
	public List<Vendedor> buscarTodos() {
		Collection<Vendedor> vendedorColl = this.vendedorRepository.values();
		List<Vendedor> vendedores = vendedorColl.stream().collect(Collectors.toList());
		return vendedores;
	}

	@Override
	public Vendedor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.vendedorRepository.get(id);
	}

	@Override
	public void excluirPorid(Integer id) {
		this.vendedorRepository.remove(id);
	}

	@Override
	public Vendedor salvar(Vendedor t) {
		// TODO Auto-generated method stub
		return this.vendedorRepository.put(t.getId(), t);
	}


}
