package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cliente;

public class ClienteRepository implements Repository<Cliente> {

	private Map<Integer,Cliente> clienteRepotitory;
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
	public Cliente salvar(Cliente t) {
		
         this.clienteRepotitory.put(t.getId(), t);
		return t;
	}
	
	public Cliente buscarPorCpf(String cpf) {
		List<Cliente> clientes = this.buscarTodos();
		
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return  cliente;
			}
		}
		return null;
		
	}

}
