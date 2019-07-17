package aate.gob.pe.model;

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
	@Column(name = "SISNOM")
	private String SISNOM;
	@Column(name = "SISDES")
	private String SISDES;
	@Column(name = "SISSIG", columnDefinition = "CHAR(10)")
	private String SISSIG;
	@Column(name = "SISEST")
	private char SISEST;
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
	
}
