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

import com.washer.shoewasher.app.models.TipoUsuario;
import com.washer.shoewasher.app.services.TipoUsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioService TUServ;
	
	@PostMapping(path="/insertar")
	public TipoUsuario insertar(@RequestBody TipoUsuario var) {
		return TUServ.save(var); 
	}
	
	@PutMapping(path="/update/{id}")
	public TipoUsuario update(@RequestBody TipoUsuario var,@PathVariable("id") long id) {
		var.setId_Tipo_Usuario(id);
		return TUServ.update(var); 
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		TUServ.delete(id); 
	}
	
	@GetMapping(path="/all")
	public List<TipoUsuario> listarall() {
		return TUServ.listar(); 
	}
	
	@GetMapping(path = {"/{id}"})
    public Optional<TipoUsuario> listarId(@PathVariable("id")long id){
        return TUServ.listarId(id);
    }
}
