package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ACSE_TB_SISTEMA")
@Entity(name = "Sistema")
public class Sistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_SISTEMA")
    @SequenceGenerator(sequenceName = "ACSE_SQ_SISTEMA", allocationSize = 1, name = "ACSE_SQ_SISTEMA")
	@Column(name = "SISCOD")
	private Integer SISCOD;
	@Column(name = "SISNOM",nullable = true, length = 50)
	private String SISNOM;
	@Column(name = "SISDES",nullable = true, length = 100)
	private String SISDES;
	
	@Column(name = "SISSIG", nullable = true,length = 10)
	private String SISSIG;
	
	@Column(name = "SISPAS",nullable = true, length = 100)
	private String SISPAS;
	
	@Column(name = "SISEST", nullable = true, columnDefinition = "CHAR(1)")
	private char SISEST;
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
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public String getSISNOM() {
		return SISNOM;
	}
	public void setSISNOM(String sISNOM) {
		SISNOM = sISNOM;
	}
	public String getSISDES() {
		return SISDES;
	}
	public void setSISDES(String sISDES) {
		SISDES = sISDES;
	}
	public String getSISSIG() {
		return SISSIG;
	}
	public void setSISSIG(String sISSIG) {
		SISSIG = sISSIG;
	}
	public char getSISEST() {
		return SISEST;
	}
	public void setSISEST(char sISEST) {
		SISEST = sISEST;
	}
	public char getESTREG() {
		return ESTREG;
	}
	public void setESTREG(char eSTREG) {
		ESTREG = eSTREG;
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
	
	
}
