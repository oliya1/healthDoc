package com.nicico.healthDoc.rest;

import com.nicico.healthDoc.dao.LocationRepository;
import com.nicico.healthDoc.entity.Location;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/location")
public class LocationRestController {
    final private LocationRepository locationRepository;
    @GetMapping("/")
    public ResponseEntity<List<Location>> getAllLocation(){
        List<Location> allLocation = locationRepository.findAll();
        return new ResponseEntity<>(allLocation, HttpStatus.OK);
    }
}
