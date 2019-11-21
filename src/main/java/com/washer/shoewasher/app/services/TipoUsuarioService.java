package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.TipoUsuario;
import com.washer.shoewasher.app.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository Rep;
	
	public TipoUsuario save(TipoUsuario var) {
		return Rep.save(var);
	}
	public TipoUsuario update(TipoUsuario var) {
		return Rep.save(var);
	}
	public void delete(long var) {
		Rep.deleteById(var);
	}
	public List<TipoUsuario> listar(){
		return Rep.findAll();
	}
	
	public Optional<TipoUsuario> listarId(long var) {
        return Rep.findById(var);
    }
}
