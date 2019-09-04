package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="ACSE_TM_ROL")
@Entity(name="Rol")
public class Rol {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_ROL")
    @SequenceGenerator(sequenceName = "ACSE_SQ_ROL", allocationSize = 1, name = "ACSE_SQ_ROL")
	@Column(name = "ROLCOD")
	private Integer ROLCOD;
	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "SISCOD",nullable = true, foreignKey = @ForeignKey(name =
	 * "FK_ACSE_TM_ROL_TB_SISTEMA")) private Sistema sistema;
	 */
	
	@Column(name = "ROLNOM", nullable = true,length = 50)
	private String ROLNOM;
	
	public String getROLNOM() {
		return ROLNOM;
	}
	public void setROLNOM(String rOLNOM) {
		ROLNOM = rOLNOM;
	}
	@Column(name = "ROLDES", nullable = true,length = 100)
	private String ROLDES;
	@Column(name = "ROLSIG", nullable = true, columnDefinition = "char(20)")
	private char[] ROLSIG;
	@Column(name = "ROLEST", nullable = true, columnDefinition = "CHAR(1)")
	private char ROLEST;
	@Column(name = "USUREG", nullable = true,length = 30)
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG = LocalDate.now();
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG")
	private char ESTREG;
	public Integer getROLCOD() {
		return ROLCOD;
	}
	public void setROLCOD(Integer rOLCOD) {
		ROLCOD = rOLCOD;
	}

	/*
	 * public Sistema getSistema() { return sistema; } public void
	 * setSistema(Sistema sistema) { this.sistema = sistema; }
	 */
	public String getROLDES() {
		return ROLDES;
	}
	public void setROLDES(String rOLDES) {
		ROLDES = rOLDES;
	}
	public char[] getROLSIG() {
		return ROLSIG;
	}
	public void setROLSIG(char[] rOLSIG) {
		ROLSIG = rOLSIG;
	}
	public char getROLEST() {
		return ROLEST;
	}
	public void setROLEST(char rOLEST) {
		ROLEST = rOLEST;
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
	