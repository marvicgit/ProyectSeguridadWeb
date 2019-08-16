package aate.gob.pe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RolMenuPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "MENCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_ACSE_ROL_MENU_TM_MENU"))
	private Menu menu;

	@ManyToOne
	@JoinColumn(name = "ROLCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_ACSE_ROL_MENU_TM_ROL"))
	private Rol rol;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolMenuPK other = (RolMenuPK) obj;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		return true;
	}
	
	
}
