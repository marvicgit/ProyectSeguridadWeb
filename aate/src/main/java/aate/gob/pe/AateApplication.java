package aate.gob.pe;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.model.OauthClientDetails;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.IOauthClientDetailsService;
import aate.gob.pe.service.IUsuarioService;


@SpringBootApplication
public class AateApplication  {

	@Autowired
	private IOauthClientDetailsService serviceOauth;
	@Autowired
	private IUsuarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(AateApplication.class, args);
	}
	
	@Transactional
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	if (service.listar().isEmpty()) {
				Usuario us = new Usuario();
				us.setESTREG('1');
				us.setPRECOD(1);
				us.setUSUAPEPAT("CARRILLO");
				us.setUSUAPEMAT("DURAND");
				us.setUSUBLO('0');
				us.setUSUDNI("43408900");
				us.setUSUEST(1);
				us.setUSUSEXO(1);
				us.setUSUAREA("SISTEMAS");
				us.setUSUCARGO("ANALISTA");
				us.setUSUCOR("DESARROLLO10@AATE.GOB.PE");
				us.setUSULOG("DESARROLLO10");
				us.setUSUPAS("$2a$10$EpTxl48p8zvBfSMvT2W/9uY20PVl29ANqlAjdT3KGrGbRPClrGQUC");
				//System.out.println("Usuario = DESARROLLO10 y Contraseña = 123");
				service.registrar(us);
			}
	    	
	    	if (serviceOauth.listar().isEmpty()) {
	    		OauthClientDetails auth = new OauthClientDetails();
	    		auth.setClient_id("SISAC");
	    		auth.setClient_secret("$2a$10$4shvkjncsFvuLIu.DD6w3OE8MnTwdfQzqPTDDTaCsHftPYHE1Lu6u");
	    		auth.setScope("read,write,trust");
	    		auth.setAuthorized_grant_types("password,refresh_token");
	    		auth.setAuthorities("role_client,role_trusted_client");
	    		auth.setAccess_token_validity(900);
	    		auth.setRefresh_token_validity(2592000);
				//System.out.println(us.getUSUPAS());
	    		serviceOauth.registrar(auth);
			}
	      };
	   }
	
}
