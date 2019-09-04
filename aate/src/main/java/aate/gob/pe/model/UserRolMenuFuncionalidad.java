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

@Table(name = "ACSE_TV_USER_ROL_MENU_FUNC")
@Entity(name = "UserRolMenuFuncionalidad")
public class UserRolMenuFuncionalidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_USEROLMENUFUN")
    @SequenceGenerator(sequenceName = "ACSE_SQ_USEROLMENUFUN", allocationSize = 1, name = "ACSE_SQ_USEROLMENUFUN")
	@Column(name = "USUROLMENFUNCOD")
	private Integer USUROLMENFUNCOD;
	
	@ManyToOne
	@JoinColumn(name = "ROLMENFUNCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_USUMENROLFUN_ROLMENFUN"))
	private RolMenuFuncionalidad rolMenuFuncionalidad;
	
	@ManyToOne
	@JoinColumn(name = "USUCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_USUMENROLFUN_USU"))
	private Usuario usuario;
	
	@Column(name = "USUREG", nullable = true, length = 30)
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG = LocalDate.now();
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG")
	private char ESTREG;
	public Integer getUSUROLMENFUNCOD() {
		return USUROLMENFUNCOD;
	}
	public void setUSUROLMENFUNCOD(Integer uSUROLMENFUNCOD) {
		USUROLMENFUNCOD = uSUROLMENFUNCOD;
	}
	public RolMenuFuncionalidad getRolMenuFuncionalidad() {
		return rolMenuFuncionalidad;
	}
	public void setRolMenuFuncionalidad(RolMenuFuncionalidad rolMenuFuncionalidad) {
		this.rolMenuFuncionalidad = rolMenuFuncionalidad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
