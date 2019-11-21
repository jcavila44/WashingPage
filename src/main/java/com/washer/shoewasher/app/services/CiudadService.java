package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Ciudad;
import com.washer.shoewasher.app.repositories.CiudadRepository;

@Service
public class CiudadService {
	@Autowired
	private CiudadRepository Rep;

	public Ciudad save(Ciudad var) {
		return Rep.save(var);
	}

	public Ciudad update(Ciudad var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<Ciudad> listar() {
		return Rep.findAll();
	}

	public Optional<Ciudad> listarId(long var) {
		return Rep.findById(var);
	}
	
	public List<Ciudad> ListCity(Long dpto) {
		return Rep.findByDpto(dpto);
    }
}
