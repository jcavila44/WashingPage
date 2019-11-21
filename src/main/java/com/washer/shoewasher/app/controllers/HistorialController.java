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

import com.washer.shoewasher.app.models.Historial;
import com.washer.shoewasher.app.services.HistorialService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/historial")
public class HistorialController {
	@Autowired
	private HistorialService Serv;

	@PostMapping(path = "/insertar")
	public Historial insertar(@RequestBody Historial var) {
		return Serv.save(var);
	}

	@PutMapping(path = "/update/{id}")
	public Historial update(@RequestBody Historial var, @PathVariable("id") long id) {
		var.setId_Depto(id);
		return Serv.update(var);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Historial> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Historial> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
}
