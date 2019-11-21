package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Accion;
import com.washer.shoewasher.app.repositories.AccionRepository;

@Service
public class AccionService {
	@Autowired
	private AccionRepository Rep;

	public Accion save(Accion var) {
		return Rep.save(var);
	}

	public Accion update(Accion var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<Accion> listar() {
		return Rep.findAll();
	}

	public Optional<Accion> listarId(long var) {
		return Rep.findById(var);
	}
}
