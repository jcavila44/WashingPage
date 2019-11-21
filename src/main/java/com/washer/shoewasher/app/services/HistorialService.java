package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Historial;
import com.washer.shoewasher.app.repositories.HistorialRepository;

@Service
public class HistorialService {
	@Autowired
	private HistorialRepository Rep;

	public Historial save(Historial var) {
		return Rep.save(var);
	}

	public Historial update(Historial var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<Historial> listar() {
		return Rep.findAll();
	}

	public Optional<Historial> listarId(long var) {
		return Rep.findById(var);
	}
}
