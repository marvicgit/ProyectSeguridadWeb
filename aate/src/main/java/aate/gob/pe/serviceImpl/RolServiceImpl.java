package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.repo.IRolRepo;
import aate.gob.pe.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	IRolRepo repo; 
	
	@Override
	public Rol registrar(Rol t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol modificar(Rol t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> listar() {
		return repo.findAll();
	}

	@Override
	public Rol leer(Integer id) {
		Optional<Rol> rol = repo.findById(id);
		return rol.isPresent() ? rol.get() : new Rol();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolMenu> listarMenuPorRol(Integer idRol) {
		return repo.listarMenuPorRol(idRol);
		
	}

}
