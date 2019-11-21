package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.washer.shoewasher.app.models.ClaseEstado;
import com.washer.shoewasher.app.repositories.ClaseEstadoRepository;

@Service
public class ClaseEstadoService {
	@Autowired
	private ClaseEstadoRepository Rep;

	@Transactional
	public void save(ClaseEstado us) {
		Rep.save(us);
	}
	
	@Transactional
	public void update(ClaseEstado us) {
		Rep.save(us);
	}
	
	public void delete(long id) {
		Rep.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<ClaseEstado> listar(){
		return Rep.findAll();
	}
	
	public Optional<ClaseEstado> listarId(long id) {
        return Rep.findById(id);
    }
	
	@Transactional(readOnly = true)
	public ClaseEstado listarId(Long id) {
		return Rep.findById(id).orElse(null);
	}
	
}
