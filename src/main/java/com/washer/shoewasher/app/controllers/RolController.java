package com.washer.shoewasher.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washer.shoewasher.app.models.Rol;
import com.washer.shoewasher.app.services.RolService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RolController {
	@Value("${design}")
	private String tittle;
	
	@Value("${version}")
	private String version;
	
	@Value("${actualizado}")
	private String update;
	
	@Autowired
	private RolService Serv;
	
	@PostMapping(path="/insertar")
	public Rol insertar(@RequestBody Rol us) {
		return Serv.save(us); 
	}
	
	@PutMapping(path="/update/{id}")
	public Rol update(@RequestBody Rol us,@PathVariable("id") long id) {
		us.setId_Rol(id);
		return Serv.update(us); 
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id); 
	}
	
	@GetMapping(path="/all")
	public List<Rol> listarall(Model model) {
		return Serv.listar();
	}
	
	@GetMapping(path = {"/{id}"})
    public Optional<Rol> listarId(@PathVariable("id")long id){
        return Serv.listarId(id);
    }
}
