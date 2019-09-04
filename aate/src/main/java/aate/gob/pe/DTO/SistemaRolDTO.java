package aate.gob.pe.DTO;


public class SistemaRolDTO {
	
	private Integer ROLMENCOD;
	private Integer SISCOD;
	private String ROLNOM;
	
	
	public SistemaRolDTO(Integer rOLMENCOD, Integer sISCOD, String rOLNOM) {
		super();
		ROLMENCOD = rOLMENCOD;
		SISCOD = sISCOD;
		ROLNOM = rOLNOM;
	}
	public Integer getROLMENCOD() {
		return ROLMENCOD;
	}
	public void setROLMENCOD(Integer rOLMENCOD) {
		ROLMENCOD = rOLMENCOD;
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
