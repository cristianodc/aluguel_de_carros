package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cliente;
import model.Cliente.TipoPessoa;

public class ClienteRepository implements Repository<Cliente> {

	private Map<Integer,Cliente> clienteRepotitory;
	public ClienteRepository() {
		
		this.clienteRepotitory = new HashMap<>();
		Cliente cliente = new Cliente("Cristiano", "96683899053", "123", "Rua 1", TipoPessoa.PF);
		Cliente cliente01 = new Cliente("Beltrano", "5050", "123", "Rua 1", TipoPessoa.PJ);
		this.clienteRepotitory.put(cliente.getId(), cliente);
		this.clienteRepotitory.put(cliente01.getId(), cliente01);
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
