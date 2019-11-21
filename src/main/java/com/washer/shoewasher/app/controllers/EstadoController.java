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

import com.washer.shoewasher.app.models.Estado;
import com.washer.shoewasher.app.services.EstadoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/estado")
public class EstadoController {
	@Autowired
	private EstadoService Serv;

	@PostMapping(path = "/insertar")
	public Estado insertar(@RequestBody Estado var) {
		return Serv.save(var);
	}

	@PutMapping(path = "/update/{id}")
	public Estado update(@RequestBody Estado var, @PathVariable("id") long id) {
		var.setId_Estado(id);
		return Serv.update(var);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Estado> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Estado> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
	
	@GetMapping(path = "/list/{id}")
	public List<Estado> listarEst(@PathVariable("id") Long id) {
		return Serv.ListEst(id);
	}
}
