package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "ACSE_TV_ROL_MENU_FUNC")
@Entity(name = "RolMenuFuncionalidad")
public class RolMenuFuncionalidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_ROLMENUFUN")
    @SequenceGenerator(sequenceName = "ACSE_SQ_ROLMENUFUN", allocationSize = 1, name = "ACSE_SQ_ROLMENUFUN")
	@Column(name = "ROLMENFUNCOD")
	private Integer ROLMENFUNCOD;
	
	@ManyToOne
	@JoinColumn(name = "ROLMENCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_MENROLFUN_ROLMEN"))
	private RolMenu rolMenu;

	@ManyToOne
	@JoinColumn(name = "FUNCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_MENROLFUN_FUN"))
	private Funcionalidad funcionalidad;
	
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG;
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG")
	private char ESTREG;
	public Integer getROLMENFUNCOD() {
		return ROLMENFUNCOD;
	}
	public void setROLMENFUNCOD(Integer rOLMENFUNCOD) {
		ROLMENFUNCOD = rOLMENFUNCOD;
	}
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
