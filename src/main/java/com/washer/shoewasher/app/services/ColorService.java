package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.washer.shoewasher.app.models.Color;
import com.washer.shoewasher.app.repositories.ColorRepository;

@Service
public class ColorService {
	@Autowired
	private ColorRepository Rep;

	@Transactional
	public void save(Color us) {
		Rep.save(us);
	}
	
	@Transactional
	public void update(Color us) {
		Rep.save(us);
	}
	
	public void delete(long id) {
		Rep.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Color> listar(){
		return Rep.findAll();
	}
	
	public Optional<Color> listarId(long id) {
        return Rep.findById(id);
    }
	
	@Transactional(readOnly = true)
	public Color listarId(Long id) {
		return Rep.findById(id).orElse(null);
	}
	
}
