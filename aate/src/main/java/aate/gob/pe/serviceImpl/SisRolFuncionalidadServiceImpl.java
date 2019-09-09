package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.DTO.RolFuncionalidadDTO;
import aate.gob.pe.DTO.RolMenuFuncionalidadDTO;
import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.repo.IMenuRepo;
import aate.gob.pe.repo.ISisRolFuncionalidadRepo;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IMenuService;
import aate.gob.pe.service.ISisRolFuncionalidadService;

@Service
public class SisRolFuncionalidadServiceImpl implements ISisRolFuncionalidadService {

	@Autowired
	private ISisRolFuncionalidadRepo repo;
	
	@Autowired
	private IRolMenuRepo repoMR;
	
	@Override
	public SisRolFuncionalidad registrar(SisRolFuncionalidad t) {
	 return	repo.save(t);
	}

	@Override
	public SisRolFuncionalidad modificar(SisRolFuncionalidad t) {
		return	repo.save(t);
	}

	@Override
	public List<SisRolFuncionalidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public SisRolFuncionalidad leer(Integer id) {
		Optional<SisRolFuncionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new SisRolFuncionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	//@Transactional
	@Override
	public Integer registrarTransaccional(RolFuncionalidadDTO rolfun) { 
		//List<Integer> listaRM = repoMR.buscarIdRolMenuxSistema(rolfun.getSISCOD(), rolfun.getROLCOD());
		//listaRM.forEach(i -> {
			rolfun.getLstFuncionalidad().forEach(f -> {
				SisRolFuncionalidad mrf = new SisRolFuncionalidad();
				mrf.setSISCOD(rolfun.getSISCOD());
				Rol r = new Rol();
				r.setROLCOD(rolfun.getROLCOD());
				mrf.setRol(r);
				mrf.setFuncionalidad(f); 
				repo.save(mrf);			
			});
		//});
		
		return 1;
		 
	}

	@Override
	public List<SisRolFuncionalidadDTO> listaSistemaRolFun() {
		// TODO Auto-generated method stub
		return repo.listaSistemaRolFun();
	}

	@Override
	public void eliminarRolMenFunc(SisRolFuncionalidadDTO sisrolfun) {
		// TODO Auto-generated method stub
		//repo.eliminarRolMenFunc(sisrolfun.getSistema().getSISCOD(), sisrolfun.getRol().getROLCOD(), sisrolfun.getFuncionalidad().getFUNCOD());
	}

	@Override
	public List<Integer> buscarIdRolMenuFunxSistema(Integer siscod, Integer rolcod) {
		// TODO Auto-generated method stub
		return null; //repo.buscarIdRolMenuFunxSistema(siscod, rolcod);
	}

}
