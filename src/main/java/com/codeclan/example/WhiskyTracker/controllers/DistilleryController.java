package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/distilleries")
public class DistilleryController {

@Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public Optional<Distillery> getDistillerById(@PathVariable Long id){
        return distilleryRepository.findById(id);
    }

    @PostMapping(value = "/distilleries")
    public ResponseEntity<Distillery> updatePirate(@RequestBody Distillery distillery,
           @PathVariable Long id){
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

    @GetMapping(value = "/distilleries/name")
    public ResponseEntity<List<Distillery>> getByDistilleryName(@RequestParam(name = "name") String name) {
        List<Distillery> distillery = distilleryRepository.findByNameEqualsIgnoreCase(name);
        return new ResponseEntity<>(distillery, HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/region")
    public ResponseEntity<List<Distillery>> getByDistilleryRegion(@RequestParam(name = "region") String region) {
        List<Distillery> distillery = distilleryRepository.findByNameEqualsIgnoreCase(region);
        return new ResponseEntity<>(distillery, HttpStatus.OK);
    }
}
