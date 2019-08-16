package aate.gob.pe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ACSE_TV_ROL_MENU")
@IdClass(RolMenuPK.class)
public class RolMenu {

	@Id
	private Rol rol;
	
	@Id
	private Menu menu;
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
}
