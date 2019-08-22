package aate.gob.pe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class MenuRolFuncUsuarioPK implements Serializable {

	@ManyToOne
	@JoinColumns ( 
	value = { @JoinColumn(name = "MENCOD", nullable = false),
			  @JoinColumn(name = "ROLCOD", nullable = false),
			  @JoinColumn(name = "FUNCOD", nullable = false)
			 })
	private MenuRolFuncionalidad menuRolFunc;
	
	@ManyToOne
	@JoinColumn(name = "USUCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_MENROLFUN_USU"))
	private Usuario usuario;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuRolFunc == null) ? 0 : menuRolFunc.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		MenuRolFuncUsuarioPK other = (MenuRolFuncUsuarioPK) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (menuRolFunc == null) {
			if (other.menuRolFunc != null)
				return false;
		} else if (!menuRolFunc.equals(other.menuRolFunc))
			return false;
		return true;
	}
}
