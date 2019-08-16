package aate.gob.pe.service;

import java.util.List;

import aate.gob.pe.model.SistemaUsuario;

public interface ISistemaUsuarioService extends ICrud<SistemaUsuario>{

	List<SistemaUsuario> buscarSistemaUsuario(SistemaUsuario objeto);
	

}


