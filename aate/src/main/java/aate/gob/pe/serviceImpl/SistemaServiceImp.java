package aate.gob.pe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.Sistema;
import aate.gob.pe.repo.ISistemaRepo;
import aate.gob.pe.service.ISistemaService;

@Service
public class SistemaServiceImp implements ISistemaService {

	@Autowired
	private ISistemaRepo repo;
	
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
		return repo.findAll();
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
	public List<Sistema> siglaFindAll(String sigla) {
		
		List<Sistema> lista = new ArrayList<>();
		repo.siglaFindAll(sigla).forEach(x -> {
			Sistema cr = new Sistema();
			cr.setSISCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setSISNOM(String.valueOf(x[1]));
			cr.setSISDES(String.valueOf(x[2]));
			cr.setSISSIG(String.valueOf(x[3]));
			cr.setSISEST(String.valueOf(x[4]).charAt(0));
			cr.setESTREG(String.valueOf(x[9]).charAt(0));
			//cr.setUSUFOT(byte[] (x[7]));
			lista.add(cr);
		});
		return lista;
	}
}
