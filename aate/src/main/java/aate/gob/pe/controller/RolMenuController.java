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
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.service.IRolMenuService;
import aate.gob.pe.service.ISistemaService;

@RestController
@RequestMapping("/RolMenus")

public class RolMenuController {
	
	@Autowired
	private IRolMenuService service;
	
	@GetMapping
	public ResponseEntity<List<RolMenu>>listar()
	{
		List<RolMenu> lRolMenu = service.listar();
		if(lRolMenu==null)
		{
			throw new ModeloNotFoundException("Sin resultados");
		}
		
		return new ResponseEntity<List<RolMenu>>(lRolMenu, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RolMenu>  registrar(@RequestBody RolMenu fun) {
		RolMenu RolMenu = service.registrar(fun);
		return new ResponseEntity<RolMenu>(RolMenu, HttpStatus.CREATED);
	}

}
