package aate.gob.pe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.SistemaUsuario;
import aate.gob.pe.repo.ISistemaUsuarioRepo;
import aate.gob.pe.service.ISistemaUsuarioService;

@Service
public class SistemaUsuarioServiceImp implements ISistemaUsuarioService {

	@Autowired
	private ISistemaUsuarioRepo repo;
	
	@Override
	public SistemaUsuario registrar(SistemaUsuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public SistemaUsuario modificar(SistemaUsuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<SistemaUsuario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public SistemaUsuario leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<SistemaUsuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new SistemaUsuario();
	}
	

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<SistemaUsuario> buscarSistemaUsuario(SistemaUsuario objeto) {
		// TODO Auto-generated method stub
		List<SistemaUsuario> lista = new ArrayList<>();
		repo.buscarSistemaUsuario(objeto.getUSUCOD(), objeto.getSISCOD()).forEach(x -> {
			SistemaUsuario cr = new SistemaUsuario();
			cr.setUSUSISCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setUSUCOD(Integer.parseInt(String.valueOf(x[1])));
			cr.setSISCOD(Integer.parseInt(String.valueOf(x[2])));
			lista.add(cr);
		});
		return lista;
	}
}
