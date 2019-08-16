package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.Menu;
import aate.gob.pe.repo.IMenuRepo;
import aate.gob.pe.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuRepo repo;
	
	@Override
	public Menu registrar(Menu t) {
	 return	repo.save(t);
	}

	@Override
	public Menu modificar(Menu t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Menu leer(Integer id) {
		Optional<Menu> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Menu();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> listarPorIdSistema(Integer idSistema) {
		return repo.listarPorIdSistema(idSistema);
	}


}
