package com.roberto.greenhousing.repository;

import com.roberto.greenhousing.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    List<Species> findByNameContainingIgnoreCase(String name);

}
