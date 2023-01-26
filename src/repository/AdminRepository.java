package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Admin;
import model.Vendedor;

public class AdminRepository implements Repository<Admin> {

	private Map<Integer,Admin> adminRepository;
	
	public AdminRepository() {
		
		this.adminRepository = new HashMap<>();
		this.salvar(new Admin("Beltrano", "96683899053", "123", "Rua 4"));
	}
	@Override
	public List<Admin> buscarTodos() {
		Collection<Admin> adminColl = this.adminRepository.values();
		List<Admin> admins = adminColl.stream().collect(Collectors.toList());
		return admins;
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
