package com.roberto.greenhousing.controller;

import com.roberto.greenhousing.dto.PlantDto;
import com.roberto.greenhousing.entity.Plant;
import com.roberto.greenhousing.repository.PlantRepository;
import mapper.PlantMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    private final PlantMapper plantMapper = Mappers.getMapper(PlantMapper.class);

    @GetMapping
    public ResponseEntity<List<PlantDto>> getPlants() {
        List<Plant> plants = plantRepository.findAll();
        if (plants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(plantMapper.fromPlant(plants), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) {
        try {
            Plant plant = plantRepository.save(plantMapper.toPlant(plantDto));

            return new ResponseEntity<>(plantMapper.fromPlant(plant), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlant(@PathVariable("id") Integer id) {
        try {
            plantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
