package com.washer.shoewasher.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washer.shoewasher.app.models.AccionTipoUsuario;
import com.washer.shoewasher.app.services.AccionTipoUsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accionTipoUsuario")
public class AccionTipoUsuarioController {
	@Autowired
	private AccionTipoUsuarioService Serv;

	@PostMapping(path = "/insertar")
	public AccionTipoUsuario insertar(@RequestBody AccionTipoUsuario var) {
		return Serv.save(var);
	}

	@PutMapping(path = "/update/{id}")
	public AccionTipoUsuario update(@RequestBody AccionTipoUsuario var, @PathVariable("id") long id) {
		var.setId_Accion_Tipo_Usuario(id);
		return Serv.update(var);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<AccionTipoUsuario> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<AccionTipoUsuario> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
}
