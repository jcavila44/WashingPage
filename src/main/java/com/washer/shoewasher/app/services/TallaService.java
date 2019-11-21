package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Talla;
import com.washer.shoewasher.app.repositories.TallaRepository;

@Service
public class TallaService {
	@Autowired
	private TallaRepository Rep;
	
	public Talla save(Talla var) {
		return Rep.save(var);
	}
	public Talla update(Talla var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<Talla> listar(){
		return Rep.findAll();
	}
	
	public Optional<Talla> listarId(long var) {
        return Rep.findById(var);
    }
}
