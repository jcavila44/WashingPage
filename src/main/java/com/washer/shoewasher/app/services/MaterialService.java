package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Material;
import com.washer.shoewasher.app.repositories.MaterialRepository;

@Service
public class MaterialService {
	@Autowired
	private MaterialRepository Rep;
	
	public Material save(Material var) {
		return Rep.save(var);
	}
	public Material update(Material var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<Material> listar(){
		return Rep.findAll();
	}
	
	public Optional<Material> listarId(long var) {
        return Rep.findById(var);
    }
}
