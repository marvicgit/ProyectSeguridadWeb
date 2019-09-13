package aate.gob.pe.service;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Usuario;

public interface IUsuarioService extends ICrud<Usuario>{
	Usuario BuscarUsuarioLdap (@Param("user") String user);
}


