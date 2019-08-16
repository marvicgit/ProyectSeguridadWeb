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

import aate.gob.pe.exception.ModeloNotFoundException;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;
	
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar()
	{
		List<Rol> lRol = service.listar();
		return new ResponseEntity<List<Rol>>(lRol, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarPorId/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer idRol)
	{
		Rol rol = service.leer(idRol);
		if(rol.getROLCOD() ==null)
		{
			throw new ModeloNotFoundException("id no encontrado: "+ idRol);
		}
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarMenuPorRol/{id}")
	public ResponseEntity<List<RolMenu>> listarMenuPorRol(@PathVariable("id")Integer id)
	{
		List<RolMenu> lmenu = service.listarMenuPorRol(id);
		return new ResponseEntity<List<RolMenu>>(lmenu, HttpStatus.OK);
	}
	
	
	@PostMapping
	public  ResponseEntity<Rol> registrar(@RequestBody Rol rol) {
		Rol obj = service.registrar(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.CREATED);
	}
	
}
