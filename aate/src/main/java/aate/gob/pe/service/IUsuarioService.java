package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.Login;
import aate.gob.pe.model.Usuario;

public interface IUsuarioService extends ICrud<Usuario>{

	List<Usuario> dniFindAll(@Param("dni") String dni);
	
	List<Usuario> loginFindAll(@Param("login") String login);
	
	int validaAcceso(Login login);
	
	Usuario BuscarUsuarioLdap (@Param("user") String user);
}


