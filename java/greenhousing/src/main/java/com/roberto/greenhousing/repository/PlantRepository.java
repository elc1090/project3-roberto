package com.roberto.greenhousing.repository;

import com.roberto.greenhousing.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Integer> {


}
