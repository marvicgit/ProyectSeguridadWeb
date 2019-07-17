package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="ACSE_TM_USUARIO")
@Entity(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_USUARIO")
    @SequenceGenerator(sequenceName = "ACSE_SQ_USUARIO", allocationSize = 1, name = "ACSE_SQ_USUARIO")
	@Column(name = "USUCOD")
	private int USUCOD;
	@Column(name = "USUDNI", columnDefinition = "char(11)" )
	private String USUDNI;
	@Column(name = "USUNOM")
	private String USUNOM;
	@Column(name = "USUAPEPAT")
	private String USUAPEPAT;
	@Column(name = "USUAPEMAT")
	private String USUAPEMAT;
	@Column(name = "USUCOR")
	private String USUCOR;
	@Column(name = "USULOG")
	private String USULOG;
	@Column(name = "USUPAS")
	private String USUPAS;
	@Column(name = "USUPASSAL")
	private String USUPASSAL;
	@Column(name = "PRECOD")
	private Integer PRECOD;
	@Column(name = "USURESSEC")
	private String USURESSEC;
	@Column(name = "USURESSAL")
	private String USURESSAL;
	@Column(name = "USUBLO")
	private char USUBLO;
	@Column(name = "USUDCP")
	private char USUDCP;
	@Column(name = "USUNCP")
	private char USUNCP;
	@Column(name = "USUPNE")
	private char USUPNE;
	@Column(name = "USUEST")
	private char USUEST;
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
	@Column(name = "USUFOT", updatable = false)
	private byte[] USUFOT;
	@Column(name = "USUFIR", updatable = false)
	private byte[] USUFIR;
	@Column(name = "USUVIS", updatable = false)
	private byte[] USUVIS;
	@Column(name = "FECEXPAS")
	private LocalDate FECEXPAS; 
	@Column(name = "USUTEFFIJO")
	private String USUTEFFIJO;  
	@Column(name = "USUTEFMOVIL")
	private String USUTEFMOVIL;  
	@Column(name = "USUANEXO")
	private String USUANEXO;
	public int getUSUCOD() {
		return USUCOD;
	}
	public void setUSUCOD(int uSUCOD) {
		USUCOD = uSUCOD;
	}
	public String getUSUDNI() {
		return USUDNI;
	}
	public void setUSUDNI(String uSUDNI) {
		USUDNI = uSUDNI;
	}
	public String getUSUNOM() {
		return USUNOM;
	}
	public void setUSUNOM(String uSUNOM) {
		USUNOM = uSUNOM;
	}
	public String getUSUAPEPAT() {
		return USUAPEPAT;
	}
	public void setUSUAPEPAT(String uSUAPEPAT) {
		USUAPEPAT = uSUAPEPAT;
	}
	public String getUSUAPEMAT() {
		return USUAPEMAT;
	}
	public void setUSUAPEMAT(String uSUAPEMAT) {
		USUAPEMAT = uSUAPEMAT;
	}
	public String getUSUCOR() {
		return USUCOR;
	}
	public void setUSUCOR(String uSUCOR) {
		USUCOR = uSUCOR;
	}
	public String getUSULOG() {
		return USULOG;
	}
	public void setUSULOG(String uSULOG) {
		USULOG = uSULOG;
	}
	public String getUSUPAS() {
		return USUPAS;
	}
	public void setUSUPAS(String uSUPAS) {
		USUPAS = uSUPAS;
	}
	public String getUSUPASSAL() {
		return USUPASSAL;
	}
	public void setUSUPASSAL(String uSUPASSAL) {
		USUPASSAL = uSUPASSAL;
	}
	public Number getPRECOD() {
		return PRECOD;
	}
	public void setPRECOD(Integer pRECOD) {
		PRECOD = pRECOD;
	}
	public String getUSURESSEC() {
		return USURESSEC;
	}
	public void setUSURESSEC(String uSURESSEC) {
		USURESSEC = uSURESSEC;
	}
	public String getUSURESSAL() {
		return USURESSAL;
	}
	public void setUSURESSAL(String uSURESSAL) {
		USURESSAL = uSURESSAL;
	}
	public char getUSUBLO() {
		return USUBLO;
	}
	public void setUSUBLO(char uSUBLO) {
		USUBLO = uSUBLO;
	}
	public char getUSUDCP() {
		return USUDCP;
	}
	public void setUSUDCP(char uSUDCP) {
		USUDCP = uSUDCP;
	}
	public char getUSUNCP() {
		return USUNCP;
	}
	public void setUSUNCP(char uSUNCP) {
		USUNCP = uSUNCP;
	}
	public char getUSUPNE() {
		return USUPNE;
	}
	public void setUSUPNE(char uSUPNE) {
		USUPNE = uSUPNE;
	}
	public char getUSUEST() {
		return USUEST;
	}
	public void setUSUEST(char uSUEST) {
		USUEST = uSUEST;
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
	public byte[] getUSUFOT() {
		return USUFOT;
	}
	public void setUSUFOT(byte[] uSUFOT) {
		USUFOT = uSUFOT;
	}
	public byte[] getUSUFIR() {
		return USUFIR;
	}
	public void setUSUFIR(byte[] uSUFIR) {
		USUFIR = uSUFIR;
	}
	public byte[] getUSUVIS() {
		return USUVIS;
	}
	public void setUSUVIS(byte[] uSUVIS) {
		USUVIS = uSUVIS;
	}
	public LocalDate getFECEXPAS() {
		return FECEXPAS;
	}
	public void setFECEXPAS(LocalDate fECEXPAS) {
		FECEXPAS = fECEXPAS;
	}
	public String getUSUTEFFIJO() {
		return USUTEFFIJO;
	}
	public void setUSUTEFFIJO(String uSUTEFFIJO) {
		USUTEFFIJO = uSUTEFFIJO;
	}
	public String getUSUTEFMOVIL() {
		return USUTEFMOVIL;
	}
	public void setUSUTEFMOVIL(String uSUTEFMOVIL) {
		USUTEFMOVIL = uSUTEFMOVIL;
	}
	public String getUSUANEXO() {
		return USUANEXO;
	}
	public void setUSUANEXO(String uSUANEXO) {
		USUANEXO = uSUANEXO;
	}  
	
	
}
