package com.washer.shoewasher.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.washer.shoewasher.app.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	@Query("SELECT u FROM Estado u WHERE u.Id_Clase_Estado = ?1")
	List <Estado> findByTypeEst(Long id);
}
