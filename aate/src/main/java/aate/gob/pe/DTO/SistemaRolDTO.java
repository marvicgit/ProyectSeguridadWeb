package aate.gob.pe.DTO;


public class SistemaRolDTO {
	
	private Integer SISCOD;
	private Integer ROLCOD;
	private String ROLNOM;
	
	
	public SistemaRolDTO(Integer sISCOD, Integer rOLCOD, String rOLNOM) {
		super();
		SISCOD = sISCOD;
		ROLCOD = rOLCOD;
		ROLNOM = rOLNOM;
	}
	
	public Integer getROLCOD() {
		return ROLCOD;
	}

	public void setROLCOD(Integer rOLCOD) {
		ROLCOD = rOLCOD;
	}

	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public String getROLNOM() {
		return ROLNOM;
	}
	public void setROLNOM(String rOLNOM) {
		ROLNOM = rOLNOM;
	}
	
}
