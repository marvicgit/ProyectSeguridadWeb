package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ACSE_TV_ROL_MENU_FUNCIONALIDAD")
@IdClass(MenuRolFuncionalidadPK.class)
public class MenuRolFuncionalidad {
	@Id
	private RolMenu rolMenu;
	
	@Id
	private Funcionalidad funcionalidad;
	@Column(name = "USUREG", nullable = true,length = 30)
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG;
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG")
	private char ESTREG;

	public RolMenu getRolMenu() {
		return rolMenu;
	}

	public void setRolMenu(RolMenu rolMenu) {
		this.rolMenu = rolMenu;
	}

	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public String getUSUREG() {
		return USUREG;
	}

	public void setUSUREG(String uSUREG) {
		USUREG = uSUREG;
	}

	public LocalDate getFECREG() {
		return FECREG;
	}

	public void setFECREG(LocalDate fECREG) {
		FECREG = fECREG;
	}

	public String getUSUMOD() {
		return USUMOD;
	}

	public void setUSUMOD(String uSUMOD) {
		USUMOD = uSUMOD;
	}

	public LocalDate getFECMOD() {
		return FECMOD;
	}

	public void setFECMOD(LocalDate fECMOD) {
		FECMOD = fECMOD;
	}

	public char getESTREG() {
		return ESTREG;
	}

	public void setESTREG(char eSTREG) {
		ESTREG = eSTREG;
	}
	

}
