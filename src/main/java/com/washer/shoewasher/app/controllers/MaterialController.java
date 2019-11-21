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

import com.washer.shoewasher.app.models.Material;
import com.washer.shoewasher.app.services.MaterialService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	private MaterialService Serv;

	@PostMapping(path = "/insertar")
	public Material insertar(@RequestBody Material var) {
		return Serv.save(var);
	}

	@PutMapping(path = "/update/{id}")
	public Material update(@RequestBody Material var, @PathVariable("id") long id) {
		var.setId_Material(id);
		return Serv.update(var);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Material> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Material> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
}
