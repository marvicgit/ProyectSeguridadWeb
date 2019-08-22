package aate.gob.pe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class MenuRolFuncionalidadPK implements Serializable {
	@ManyToOne
	@JoinColumns ( 
	value = { @JoinColumn(name = "MENCOD", nullable = false),
			 @JoinColumn(name = "ROLCOD", nullable = false) })
	private RolMenu rolMenu;

	@ManyToOne
	@JoinColumn(name = "FUNCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_MENROLFUN_FUN"))
	private Funcionalidad funcionalidad;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rolMenu == null) ? 0 : rolMenu.hashCode());
		result = prime * result + ((funcionalidad == null) ? 0 : funcionalidad.hashCode());
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
		MenuRolFuncionalidadPK other = (MenuRolFuncionalidadPK) obj;
		if (funcionalidad == null) {
			if (other.funcionalidad != null)
				return false;
		} else if (!funcionalidad.equals(other.funcionalidad))
			return false;
		if (rolMenu == null) {
			if (other.rolMenu != null)
				return false;
		} else if (!rolMenu.equals(other.rolMenu))
			return false;
		return true;
	}

}
