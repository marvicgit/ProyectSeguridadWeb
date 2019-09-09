package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.RolMenuDTO;
import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.model.UserSisRolFuncionalidad;
import aate.gob.pe.repo.ISisRolFuncionalidadRepo;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IRolMenuService;

@Service
public class RolMenuServiceImpl implements IRolMenuService {

	@Autowired
	private IRolMenuRepo repo;
	
	@Autowired
	private ISisRolFuncionalidadRepo repoRMF;
	
	@Override
	public Integer registrarTransaccional(RolMenuDTO rolmenu) { 
		
		//List<Integer> listaRM = repo.buscarIdRolMenuxSistema(rolfun.getSISCOD(), rolfun.getROLCOD());
		 rolmenu.getLstMenus().forEach(m -> { 
		  RolMenu rm = new RolMenu();
		  rm.setSISCOD(rolmenu.getSiscod());
		  rm.setRol(rolmenu.getRol()); 
		  rm.setMenu(m); 
		  RolMenu rmRpta = repo.save(rm);
		  
		 // SisRolFuncionalidad rmf = new SisRolFuncionalidad(); 
		 // Funcionalidad f = new Funcionalidad();
		 // f.setFUNCOD(1);
		 // rmf.setRolMenu(rmRpta);
		 // rmf.setFuncionalidad(f); 
		 // repoRMF.save(rmf);	
		  });	

		return 1;	 
	}
	
	@Override
	public RolMenu registrar(RolMenu t) {
	 return	repo.save(t);
	}

	@Override
	public RolMenu modificar(RolMenu t) {
		return	repo.save(t);
	}

	@Override
	public List<RolMenu> listar() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "ROLMENCOD"));
	}

	@Override
	public RolMenu leer(Integer id) {
		Optional<RolMenu> op = repo.findById(id);
		return op.isPresent() ? op.get() : new RolMenu();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<SistemaRolDTO> buscarSistemaRol() {
		// TODO Auto-generated method stub
		return repo.buscarSistemaRol();
	}

	@Override
	public List<Integer> buscarIdRolMenuxSistema(Integer siscod, Integer rolcod) {
		// TODO Auto-generated method stub
		return repo.buscarIdRolMenuxSistema(siscod, rolcod);
	}
}
