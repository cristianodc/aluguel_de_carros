package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Admin;

public class AdminRepository implements Repository<Admin> {

	private Map<Integer,Admin> adminRepository;
	
	public AdminRepository() {
		
		this.adminRepository = new HashMap<>();
	}
	@Override
	public List<Admin> buscarTodos() {
		// TODO Auto-generated method stub
		return this.adminRepository.values().stream().collect(Collectors.toList());
	}

	@Override
	public Admin buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.adminRepository.get(id);
	}

	@Override
	public void excluirPorid(Integer id) {
		// TODO Auto-generated method stub
		this.adminRepository.remove(id);
		
	}

	@Override
	public Admin salvar(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminRepository.put(admin.getId(), admin);
	}

}
