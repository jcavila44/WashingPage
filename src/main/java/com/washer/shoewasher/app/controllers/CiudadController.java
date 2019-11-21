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

import com.washer.shoewasher.app.models.Ciudad;
import com.washer.shoewasher.app.services.CiudadService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
	@Autowired
	private CiudadService Serv;

	@PostMapping(path = "/insertar")
	public Ciudad insertar(@RequestBody Ciudad var) {
		return Serv.save(var);
	}

	@PutMapping(path = "/update/{id}")
	public Ciudad update(@RequestBody Ciudad var, @PathVariable("id") long id) {
		var.setId_Ciudad(id);
		return Serv.update(var);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Ciudad> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Ciudad> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
	
	@GetMapping(path = "/list/{id}")
	public List<Ciudad> listarCity(@PathVariable("id") Long id) {
		return Serv.ListCity(id);
	}
}
