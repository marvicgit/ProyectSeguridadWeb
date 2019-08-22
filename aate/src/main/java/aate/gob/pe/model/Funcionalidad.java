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

@Table(name="ACSE_TM_FUNCIONALIDAD")
@Entity(name = "Funcionalidad")
public class Funcionalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_FUNCIONALIDAD")
    @SequenceGenerator(sequenceName = "ACSE_SQ_FUNCIONALIDAD", allocationSize = 1, name = "ACSE_SQ_FUNCIONALIDAD")
	@Column(name = "FUNCOD")
	private Integer FUNCOD;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "SISCOD",nullable = true, foreignKey = @ForeignKey(name =
	 * "FK_ACSE_TM_FUNC_TB_SISTEMA")) private Sistema sistema;
	 */
	
	
	@Column(name = "FUNNOM", nullable = true,length = 50)
	private String FUNNOM;
	@Column(name = "FUNDES", nullable = true,length = 100)
	private String FUNDES;
	@Column(name = "FUNSIG", nullable = true, columnDefinition = "char(50)")
	private char[] FUNSIG;
	@Column(name = "FUNEST", nullable = true, columnDefinition = "CHAR(1)")
	private char FUNEST;
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
	
	
	
	public Integer getFUNCOD() {
		return FUNCOD;
	}
	public void setFUNCOD(Integer fUNCOD) {
		FUNCOD = fUNCOD;
	}

	/*
	 * public Sistema getSistema() { return sistema; } public void
	 * setSistema(Sistema sistema) { this.sistema = sistema; }
	 */
	public String getFUNNOM() {
		return FUNNOM;
	}
	public void setFUNNOM(String fUNNOM) {
		FUNNOM = fUNNOM;
	}
	public String getFUNDES() {
		return FUNDES;
	}
	public void setFUNDES(String fUNDES) {
		FUNDES = fUNDES;
	}
	public char[] getFUNSIG() {
		return FUNSIG;
	}
	public void setFUNSIG(char[] fUNSIG) {
		FUNSIG = fUNSIG;
	}
	public char getFUNEST() {
		return FUNEST;
	}
	public void setFUNEST(char fUNEST) {
		FUNEST = fUNEST;
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
