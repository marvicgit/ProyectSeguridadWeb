package aate.gob.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import aate.gob.pe.DTO.Login;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.IUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public List<Usuario> listar()
	{
		return service.listar();
	}
	
	@GetMapping("/{dni}")
	public List<Usuario> leerDNI(@PathVariable("dni") String dni)
	{
		return service.dniFindAll(dni);
	}
	
	@PostMapping
	public ResponseEntity<Integer> validarAcceso(@RequestBody Login obj)
	{
		int rpta = service.validaAcceso(obj);
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	
}
