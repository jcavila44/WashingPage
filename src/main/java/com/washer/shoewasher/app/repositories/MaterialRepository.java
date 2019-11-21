package com.washer.shoewasher.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.washer.shoewasher.app.models.Material;

public interface MaterialRepository extends JpaRepository<Material, Long>{

}
