package com.washer.shoewasher.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washer.shoewasher.app.models.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
