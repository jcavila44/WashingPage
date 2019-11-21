package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Rol;
import com.washer.shoewasher.app.repositories.RolRepository;

@Service
public class RolService {
	@Autowired
	private RolRepository Rep;
	
	public Rol save(Rol us) {
		return Rep.save(us);
	}
	public Rol update(Rol us) {
		return Rep.save(us);
	}
	public void delete(long id) {
		Rep.deleteById(id);
	}
	public List<Rol> listar(){
		return Rep.findAll();
	}
	
	public Optional<Rol> listarId(long id) {
        return Rep.findById(id);
    }
}
