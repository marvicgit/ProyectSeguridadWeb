package aate.gob.pe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.Sistema;
import aate.gob.pe.repo.ISistemaRepo;
import aate.gob.pe.service.ISistemaService;

@Service
public class SistemaServiceImp implements ISistemaService {

	@Autowired
	private ISistemaRepo repo;
	
	@Autowired
	private ISistemaService service;
	
	@Override
	public Sistema registrar(Sistema t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Sistema modificar(Sistema t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<Sistema> listar() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "SISCOD"));
	}

	@Override
	public Sistema leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Sistema> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Sistema();
	}
	

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Sistema> buscarSistema(Sistema filtro) {
		return repo.buscarSistema(filtro.getSISNOM(), filtro.getSISSIG(), filtro.getSISEST());
		
	}

	@Override
	public List<Sistema> siglaFindAll(String sigla) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
