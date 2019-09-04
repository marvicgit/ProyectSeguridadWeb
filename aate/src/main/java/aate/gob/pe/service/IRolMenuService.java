package aate.gob.pe.service;

import java.util.List;

import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.RolMenu;

public interface IRolMenuService extends ICrud<RolMenu>{
	
	List<SistemaRolDTO> buscarSistemaRol();
}
