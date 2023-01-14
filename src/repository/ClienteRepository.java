package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cliente;

public class ClienteRepository implements Repository<Cliente> {

	Map<Integer,Cliente> clienteRepotitory;
	public ClienteRepository() {
		
		this.clienteRepotitory = new HashMap<>();
	}
	@Override
	public List<Cliente> buscarTodos() {
		Collection<Cliente> clientesColl = this.clienteRepotitory.values();
		List<Cliente> clientes = clientesColl.stream().collect(Collectors.toList());
		return clientes;
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepotitory.get(id);
	}

	@Override
	public void excluirPorid(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepotitory.remove(id);
		
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepotitory.put(cliente.getId(), cliente);
	}

}
