package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.DTO.RolMenuFuncionalidadDTO;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.RolMenuFuncionalidad;
import aate.gob.pe.repo.IMenuRepo;
import aate.gob.pe.repo.IRolMenuFuncionalidadRepo;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IMenuService;
import aate.gob.pe.service.IRolMenuFuncionalidadService;

@Service
public class RolMenuFuncionalidadServiceImpl implements IRolMenuFuncionalidadService {

	@Autowired
	private IRolMenuFuncionalidadRepo repo;
	
	@Autowired
	private IRolMenuRepo repoMR;
	
	@Override
	public RolMenuFuncionalidad registrar(RolMenuFuncionalidad t) {
	 return	repo.save(t);
	}

	@Override
	public RolMenuFuncionalidad modificar(RolMenuFuncionalidad t) {
		return	repo.save(t);
	}

	@Override
	public List<RolMenuFuncionalidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public RolMenuFuncionalidad leer(Integer id) {
		Optional<RolMenuFuncionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new RolMenuFuncionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	//@Transactional
	@Override
	public Integer registrarTransaccional(RolMenuFuncionalidadDTO rolmenufun) {
		
		
		
		 
		 rolmenufun.getLstMenus().forEach(m -> {
			 RolMenu rm = new RolMenu(); 
			 rm.setRol(rolmenufun.getRol());
			 rm.setMenu(m); 
			 RolMenu rmRpta = repoMR.save(rm);
			
			 rolmenufun.getLstFuncionalidad().forEach(f -> {
				 RolMenuFuncionalidad mrf = new RolMenuFuncionalidad();
				 mrf.setRolMenu(rmRpta);
				 mrf.setFuncionalidad(f); 
				 repo.save(mrf);
			 });
		});
		 
		 
		
		
		
		return 1;
		 
	}

}
