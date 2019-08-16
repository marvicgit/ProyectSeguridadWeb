package aate.gob.pe.service;

import java.util.List;

import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;


public interface IRolService extends ICrud<Rol> {
	List<RolMenu> listarMenuPorRol(Integer id);
}
