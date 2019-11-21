package com.washer.shoewasher.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.washer.shoewasher.app.models.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
	@Query("SELECT u FROM Ciudad u WHERE u.Id_Depto = ?1")
	List<Ciudad> findByDpto(Long Dpto);
}
