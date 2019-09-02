package aate.gob.pe.DTO;

import java.util.List;

import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;

public class RolMenuFuncionalidadDTO {
	private Rol rol;
	private List<Menu> lstMenus;
	private List<Funcionalidad> lstFuncionalidad;
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Menu> getLstMenus() {
		return lstMenus;
	}
	public void setLstMenus(List<Menu> lstMenus) {
		this.lstMenus = lstMenus;
	}
	public List<Funcionalidad> getLstFuncionalidad() {
		return lstFuncionalidad;
	}
	public void setLstFuncionalidad(List<Funcionalidad> lstFuncionalidad) {
		this.lstFuncionalidad = lstFuncionalidad;
	}
	
}
