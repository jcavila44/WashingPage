package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.washer.shoewasher.app.models.Usuario;
import com.washer.shoewasher.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository Rep;
	
	@Transactional
	public void save(Usuario us) {
		Rep.save(us);
	}
	
	@Transactional
	public void update(Usuario us) {
		Rep.save(us);
	}
	
	public void delete(long id) {
		Rep.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> listar(){
		return Rep.findAll();
	}
	
	public Optional<Usuario> listarId(long id) {
        return Rep.findById(id);
    }
	
	@Transactional(readOnly = true)
	public Usuario listarId(Long id) {
		return Rep.findById(id).orElse(null);
	}
	
	public List<Usuario> LoginService(String user, String pwd) {
		return Rep.findByEmailAndPassword(user, pwd);
    }
}
