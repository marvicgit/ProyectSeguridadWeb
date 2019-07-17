package aate.gob.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.model.Sistema;
import aate.gob.pe.service.ISistemaService;


@RestController
@RequestMapping("/sistemas")
public class SistemaController {

	@Autowired
	private ISistemaService service;
	
	@GetMapping
	public List<Sistema> listar()
	{
		return service.listar();
	}
	
	@GetMapping("/{sigla}")
	public List<Sistema> leerDNI(@PathVariable("sigla") String sigla)
	{
		return service.siglaFindAll(sigla);
	}
}
