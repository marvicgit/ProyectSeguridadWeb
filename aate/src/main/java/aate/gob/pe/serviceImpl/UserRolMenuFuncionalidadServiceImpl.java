package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.DTO.RolMenuFuncionalidadDTO;
import aate.gob.pe.DTO.UserRolMenuFuncionalidadDTO;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.UserRolMenuFuncionalidad;
import aate.gob.pe.repo.IMenuRepo;
import aate.gob.pe.repo.IUserRolMenuFuncionalidadRepo;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IMenuService;
import aate.gob.pe.service.IUserRolMenuFuncionalidadService;

@Service
public class UserRolMenuFuncionalidadServiceImpl implements IUserRolMenuFuncionalidadService {

	@Autowired
	private IUserRolMenuFuncionalidadRepo repo;
	
	@Autowired
	private IRolMenuRepo repoMR;
	
	@Override
	public UserRolMenuFuncionalidad registrar(UserRolMenuFuncionalidad t) {
	 return	repo.save(t);
	}

	@Override
	public UserRolMenuFuncionalidad modificar(UserRolMenuFuncionalidad t) {
		return	repo.save(t);
	}

	@Override
	public List<UserRolMenuFuncionalidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UserRolMenuFuncionalidad leer(Integer id) {
		Optional<UserRolMenuFuncionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new UserRolMenuFuncionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Integer registrarTransaccional(UserRolMenuFuncionalidadDTO userrolmenufun) { 
		/*
		 * rolmenufun.getLstMenus().forEach(m -> { RolMenu rm = new RolMenu();
		 * rm.setRol(rolmenufun.getRol()); rm.setMenu(m); RolMenu rmRpta =
		 * repoMR.save(rm);
		 * 
		 * rolmenufun.getLstFuncionalidad().forEach(f -> { UserRolMenuFuncionalidad mrf
		 * = new UserRolMenuFuncionalidad(); mrf.setRolMenu(rmRpta);
		 * mrf.setFuncionalidad(f); repo.save(mrf); }); });
		 */ 
		return 1;	 
	}
}
