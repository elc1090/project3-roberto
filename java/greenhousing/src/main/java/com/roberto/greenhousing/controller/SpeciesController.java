package com.roberto.greenhousing.controller;

import com.roberto.greenhousing.dto.SpeciesDto;
import com.roberto.greenhousing.entity.Species;
import com.roberto.greenhousing.repository.SpeciesRepository;
import mapper.SpeciesMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    private final SpeciesMapper speciesMapper = Mappers.getMapper(SpeciesMapper.class);

    @GetMapping
    public ResponseEntity<List<SpeciesDto>> getSpecies(@RequestParam(required = false) String name) {

        List<Species> species;

        if (StringUtils.hasText(name))
            species = speciesRepository.findByNameContainingIgnoreCase(name);
        else
            species = speciesRepository.findAll();

        if (species.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(speciesMapper.fromSpecies(species), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeciesDto> getSpeciesById(@PathVariable("id") Integer id) {
        Optional<Species> species = speciesRepository.findById(id);

        return species.map(value -> new ResponseEntity<>(speciesMapper.fromSpecies(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SpeciesDto> createSpecies(@RequestBody SpeciesDto speciesDto) {
        try {
            Species species = speciesRepository.save(speciesMapper.toSpecies(speciesDto));

            return new ResponseEntity<>(speciesMapper.fromSpecies(species), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSpecies(@PathVariable("id") Integer id) {
        try {
            speciesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
