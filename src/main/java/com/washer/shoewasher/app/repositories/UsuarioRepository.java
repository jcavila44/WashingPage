package com.washer.shoewasher.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.washer.shoewasher.app.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.Email = ?1 and u.Contrasena = ?2")
	List <Usuario> findByEmailAndPassword(String Email, String Contrasena);
}
