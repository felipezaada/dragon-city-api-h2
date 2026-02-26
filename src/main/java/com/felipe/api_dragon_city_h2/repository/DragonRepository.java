package com.felipe.api_dragon_city_h2.repository;

import com.felipe.api_dragon_city_h2.model.DragonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DragonRepository extends JpaRepository<DragonModel, UUID> {

}
