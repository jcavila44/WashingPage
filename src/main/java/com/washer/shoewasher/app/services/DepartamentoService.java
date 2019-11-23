package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.washer.shoewasher.app.models.Color;
import com.washer.shoewasher.app.models.Departamento;
import com.washer.shoewasher.app.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository Rep;

	public Departamento save(Departamento var) {
		return Rep.save(var);
	}

	public Departamento update(Departamento var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<Departamento> listar() {
		return Rep.findAll();
	}

	public Optional<Departamento> listarId(long var) {
		return Rep.findById(var);
	}
	@Transactional(readOnly = true)
	public Departamento listarId(Long id) {
		return Rep.findById(id).orElse(null);
	}
}
