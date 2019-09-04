package aate.gob.pe.service;

import aate.gob.pe.DTO.UserRolMenuFuncionalidadDTO;
import aate.gob.pe.model.UserRolMenuFuncionalidad;

public interface IUserRolMenuFuncionalidadService extends ICrud<UserRolMenuFuncionalidad>{
	Integer registrarTransaccional(UserRolMenuFuncionalidadDTO userrolmenufun);
}
