package com.nicico.healthDoc.rest;

import com.nicico.healthDoc.dao.LocationRepository;
import com.nicico.healthDoc.entity.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/location")
public class LocationRestController {
    final private LocationRepository locationRepository;
    @GetMapping("/")
    public ResponseEntity<List<Location>> getAllLocation(){
        List<Location> allLocation = locationRepository.findAll();
        return new ResponseEntity<>(allLocation, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable(name = "id") long id){
        Optional<Location> byId = locationRepository.findById(id);
        Location location = byId.orElse(new Location());
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
