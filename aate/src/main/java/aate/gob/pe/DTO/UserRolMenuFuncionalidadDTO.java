package aate.gob.pe.DTO;

import java.util.List;

import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Usuario;

public class UserRolMenuFuncionalidadDTO {
	private Usuario usuario;
	private List<Rol> lstRol;
	private List<Funcionalidad> lstFuncionalidad;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Rol> getLstRol() {
		return lstRol;
	}
	public void setLstRol(List<Rol> lstRol) {
		this.lstRol = lstRol;
	}
	public List<Funcionalidad> getLstFuncionalidad() {
		return lstFuncionalidad;
	}
	public void setLstFuncionalidad(List<Funcionalidad> lstFuncionalidad) {
		this.lstFuncionalidad = lstFuncionalidad;
	}
	
	
}
