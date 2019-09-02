package aate.gob.pe.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.DTO.RolMenuFuncionalidadDTO;
import aate.gob.pe.model.RolMenuFuncionalidad;
import aate.gob.pe.service.IRolMenuFuncionalidadService;

@RestController
@RequestMapping("/rolesMenusFunc")
public class RolMenuFuncionalidadController {

	@Autowired
	private IRolMenuFuncionalidadService service;
	
	
	@GetMapping
	public ResponseEntity<List<RolMenuFuncionalidad>> listar()
	{
		List<RolMenuFuncionalidad> lRol = service.listar();
		return new ResponseEntity<List<RolMenuFuncionalidad>>(lRol, HttpStatus.OK);
	}
	
	
	@PostMapping
	public  ResponseEntity<Integer> registrar(@RequestBody RolMenuFuncionalidadDTO rolmenfun) {
		Integer rpta = service.registrarTransaccional(rolmenfun);
		return new ResponseEntity<Integer>(rpta, HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<RolMenuFuncionalidad> modificar(@RequestBody RolMenuFuncionalidad rolmenfun) {
		rolmenfun.setFECMOD(LocalDate.now());
		RolMenuFuncionalidad obj = service.modificar(rolmenfun);
		return new ResponseEntity<RolMenuFuncionalidad>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
}
