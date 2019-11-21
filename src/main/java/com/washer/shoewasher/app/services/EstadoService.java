package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Estado;
import com.washer.shoewasher.app.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository Rep;
	
	public Estado save(Estado var) {
		return Rep.save(var);
	}
	public Estado update(Estado var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<Estado> listar(){
		return Rep.findAll();
	}
	
	public Optional<Estado> listarId(long var) {
        return Rep.findById(var);
    }
	
	public List<Estado> ListEst(Long id) {
		return Rep.findByTypeEst(id);
    }
}
