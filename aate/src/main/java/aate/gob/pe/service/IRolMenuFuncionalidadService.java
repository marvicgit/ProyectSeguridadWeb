package aate.gob.pe.service;

import aate.gob.pe.DTO.RolMenuFuncionalidadDTO;
import aate.gob.pe.model.RolMenuFuncionalidad;

public interface IRolMenuFuncionalidadService extends ICrud<RolMenuFuncionalidad>{
	Integer registrarTransaccional(RolMenuFuncionalidadDTO rolmenufun);
}
