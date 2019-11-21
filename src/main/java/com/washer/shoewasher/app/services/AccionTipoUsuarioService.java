package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.AccionTipoUsuario;
import com.washer.shoewasher.app.repositories.AccionTipoUsuarioRepository;

@Service
public class AccionTipoUsuarioService {
	@Autowired
	private AccionTipoUsuarioRepository Rep;

	public AccionTipoUsuario save(AccionTipoUsuario var) {
		return Rep.save(var);
	}

	public AccionTipoUsuario update(AccionTipoUsuario var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<AccionTipoUsuario> listar() {
		return Rep.findAll();
	}

	public Optional<AccionTipoUsuario> listarId(long var) {
		return Rep.findById(var);
	}
}
