package com.washer.shoewasher.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washer.shoewasher.app.models.TipoCalzado;

@Repository
public interface TipoCalzadoRepository extends JpaRepository<TipoCalzado, Long>{

}
