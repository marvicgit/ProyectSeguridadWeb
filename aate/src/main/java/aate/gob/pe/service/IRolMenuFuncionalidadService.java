package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.RolFuncionalidadDTO;
import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.RolMenuFuncionalidad;

public interface IRolMenuFuncionalidadService extends ICrud<RolMenuFuncionalidad>{
	Integer registrarTransaccional(RolFuncionalidadDTO rolfun);
	List<SisRolFuncionalidadDTO> listaSistemaRolFun();
	void eliminarRolMenFunc(SisRolFuncionalidadDTO sisrolfun);
}
