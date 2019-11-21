package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.TipoCalzado;
import com.washer.shoewasher.app.repositories.TipoCalzadoRepository;

@Service
public class TipoCalzadoService {
	@Autowired
	private TipoCalzadoRepository Rep;
	
	public TipoCalzado save(TipoCalzado var) {
		return Rep.save(var);
	}
	public TipoCalzado update(TipoCalzado var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<TipoCalzado> listar(){
		return Rep.findAll();
	}
	
	public Optional<TipoCalzado> listarId(long var) {
        return Rep.findById(var);
    }
}
