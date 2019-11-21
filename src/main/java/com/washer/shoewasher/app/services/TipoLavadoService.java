package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.TipoLavado;
import com.washer.shoewasher.app.repositories.TipoLavadoRepository;

@Service
public class TipoLavadoService {
	@Autowired
	private TipoLavadoRepository Rep;
	
	public TipoLavado save(TipoLavado var) {
		return Rep.save(var);
	}
	public TipoLavado update(TipoLavado var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<TipoLavado> listar(){
		return Rep.findAll();
	}
	
	public Optional<TipoLavado> listarId(long var) {
        return Rep.findById(var);
    }
}
