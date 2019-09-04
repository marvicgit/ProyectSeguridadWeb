package aate.gob.pe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.Login;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.repo.ISistemaRepo;
import aate.gob.pe.repo.IUsuarioRepo;
import aate.gob.pe.service.IUsuarioService;
import aate.gob.pe.util.Encriptador;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	@Autowired
	private ISistemaRepo repoSis;

	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "USUCOD"));
	}

	@Override
	public Usuario leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Usuario> dniFindAll(String dni) {

		List<Usuario> lista = new ArrayList<>();
		repo.dniFindAll(dni).forEach(x -> {
			Usuario cr = new Usuario();
			cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setUSUDNI(String.valueOf(x[1]));
			cr.setUSUNOM(String.valueOf(x[2]));
			cr.setUSUAPEPAT(String.valueOf(x[3]));
			cr.setUSUAPEMAT(String.valueOf(x[4]));
			cr.setUSUCOR(String.valueOf(x[5]));
			cr.setUSULOG(String.valueOf(x[6]));
			// cr.setUSUFOT(byte[] (x[7]));
			try {
				cr.setUSUPAS(Encriptador.Encriptar("123"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.add(cr);
		});
		return lista;
		// return null;
	}

	@Override
	public List<Usuario> loginFindAll(String login) {

		List<Usuario> lista = new ArrayList<>();
		repo.loginFindAll(login).forEach(x -> {
			Usuario cr = new Usuario();
			cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setUSUDNI(String.valueOf(x[1]));
			cr.setUSUNOM(String.valueOf(x[2]));
			cr.setUSUAPEPAT(String.valueOf(x[3]));
			cr.setUSUAPEMAT(String.valueOf(x[4]));
			cr.setUSUCOR(String.valueOf(x[5]));
			cr.setUSULOG(String.valueOf(x[6]));
			lista.add(cr);
		});
		return lista;
	}

	@Override
	public int validaAcceso(Login login) {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		List<Sistema> listaSistema = new ArrayList<>();
		int rpta = 0;
		String Mensaje = "";
		try {
		String passwordEncriptado = Encriptador.Encriptar(login.getPassword());
		
		if(login.getCorreo() == null) {
			
			repo.validaAccesoDNIUsuario(login.getDni(), login.getLogin(), passwordEncriptado).forEach(x -> {
				Usuario cr = new Usuario();
				cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
				cr.setUSUDNI(String.valueOf(x[1]));
				cr.setUSUNOM(String.valueOf(x[2]));
				cr.setUSUAPEPAT(String.valueOf(x[3]));
				cr.setUSUAPEMAT(String.valueOf(x[4]));
				cr.setUSUCOR(String.valueOf(x[5]));
				cr.setUSULOG(String.valueOf(x[6]));
				lista.add(cr);
			});
			
		} else {
			repo.validaAccesoDNICorreo(login.getDni(), login.getCorreo(), passwordEncriptado).forEach(x -> {
				Usuario cr = new Usuario();
				cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
				cr.setUSUDNI(String.valueOf(x[1]));
				cr.setUSUNOM(String.valueOf(x[2]));
				cr.setUSUAPEPAT(String.valueOf(x[3]));
				cr.setUSUAPEMAT(String.valueOf(x[4]));
				cr.setUSUCOR(String.valueOf(x[5]));
				cr.setUSULOG(String.valueOf(x[6]));
				lista.add(cr);
			});
			//rpta = repo.validaAccesoDNICorreo(login.getDni(), login.getCorreo(), passwordEncriptado).isEmpty() ? 0 : 1;
		}
		
		if(!lista.isEmpty()) {
			if(lista.get(0).getUSUBLO() == '1') {
				Mensaje= "Usuario Bloqueado";
			} else if(lista.get(0).getUSUEST() == '0') {
				Mensaje= "Usuario Inactivo";
			}
			
			repoSis.siglaFindAll(login.getSigla()).forEach(x -> {
				Sistema cr = new Sistema();
				cr.setSISCOD(Integer.parseInt(String.valueOf(x[0])));
				cr.setSISNOM(String.valueOf(x[1]));
				cr.setSISDES(String.valueOf(x[2]));
				cr.setSISSIG(String.valueOf(x[3]));
				cr.setSISEST(String.valueOf(x[4]).charAt(0));
				cr.setESTREG(String.valueOf(x[5]).charAt(0));
				listaSistema.add(cr);
			});
			
				/*
				 * if(!listaSistema.isEmpty()) {
				 * 
				 * SistemaUsuario busqueda = new SistemaUsuario();
				 * busqueda.setUSUCOD(lista.get(0).getUSUCOD());
				 * busqueda.setSISCOD(listaSistema.get(0).getSISCOD()); List<SistemaUsuario>
				 * listaSisUsu = sistemaUsuService.buscarSistemaUsuario(busqueda);
				 * if(!listaSisUsu.isEmpty()) { rpta =1; } }
				 */
			
		} else {
			Mensaje= "Datos Incorrectos";
		}
		
		

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rpta = 0;
		}
		return rpta;
	}


	

}
