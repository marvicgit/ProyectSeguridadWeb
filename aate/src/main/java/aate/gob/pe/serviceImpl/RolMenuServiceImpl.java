package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.RolMenu;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IRolMenuService;


@Service
public class RolMenuServiceImpl implements IRolMenuService {

	@Autowired
	IRolMenuRepo repo;

	@Override
	public RolMenu registrar(RolMenu t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public RolMenu modificar(RolMenu t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolMenu> listar() {
		return repo.findAll();
	}

	@Override
	public RolMenu leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<RolMenu> op = repo.findById(id);
		return op.isPresent() ? op.get() : new RolMenu();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	


	

}
