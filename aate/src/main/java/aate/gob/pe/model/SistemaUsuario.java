package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ACSE_TV_USUARIO_SISTEMA")
@Entity(name = "SistemaUsuario")
public class SistemaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_USUARIO_SISTEMA")
    @SequenceGenerator(sequenceName = "ACSE_SQ_USUARIO_SISTEMA", allocationSize = 1, name = "ACSE_SQ_USUARIO_SISTEMA")
	@Column(name = "USUSISCOD")
	private int USUSISCOD;
	@Column(name = "USUCOD")
	private int USUCOD;
	@Column(name = "SISCOD")
	private int SISCOD;
	@Column(name = "USUSISBLO", columnDefinition = "char(1)")
	private char USUSISBLO;
	@Column(name = "USUREG")
	private String USUREG;
	@Column(name = "FECREG")
	private LocalDate FECREG;
	@Column(name = "USUMOD")
	private String USUMOD;
	@Column(name = "FECMOD")
	private LocalDate FECMOD;     
	@Column(name = "ESTREG")
	private char ESTREG;
	
	public int getUSUSISCOD() {
		return USUSISCOD;
	}
	public void setUSUSISCOD(int uSUSISCOD) {
		USUSISCOD = uSUSISCOD;
	}
	public int getUSUCOD() {
		return USUCOD;
	}
	public void setUSUCOD(int uSUCOD) {
		USUCOD = uSUCOD;
	}
	public int getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(int sISCOD) {
		SISCOD = sISCOD;
	}
	public char getUSUSISBLO() {
		return USUSISBLO;
	}
	public void setUSUSISBLO(char uSUSISBLO) {
		USUSISBLO = uSUSISBLO;
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
