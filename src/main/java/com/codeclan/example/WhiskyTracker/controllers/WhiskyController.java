package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> findWhiskyByDistRegionOrYear(
//            @RequestParam(required = false, name = "region")
//                    String region,
//            @RequestParam(required = false, name = "year")
//                    Integer year
//    )
//    {
//        if (year != null){
//            List<Whisky> foundWhisky = whiskyRepository.findWhiskysByYear(year);
//            return new ResponseEntity<List<Whisky>>(foundWhisky, HttpStatus.OK);
//        }
//        if (region != null){
//            List<Whisky> found = whiskyRepository.getAllWhiskiesByDistilleryRegion(region);
//            return new ResponseEntity<>(found, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllDistilleries() {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public Optional<Whisky> getWhiskyById(@PathVariable Long id) {
        return whiskyRepository.findById(id);
    }

    @PostMapping(value = "/whiskies")
    public ResponseEntity<Whisky> updatePirate(@RequestBody Whisky whisky,
                                               @PathVariable Long id) {
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getByYear(@RequestParam(name = "year") int year) {
        List<Whisky> whiskies = whiskyRepository.findByYearEquals(year);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/year/{year}")
    public  ResponseEntity<List<Whisky>> getByWhiskyYear(@PathVariable int year){
        List<Whisky> whiskies = whiskyRepository.findByYearEquals(year);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries/{name}")
    public ResponseEntity<List<Whisky>> getByDistillery(@PathVariable String name){
        List<Whisky> whiskies = whiskyRepository.findByDistilleryNameEqualsIgnoreCase(name);
        return  new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distillery")
    public ResponseEntity<List<Whisky>> getByYear(@RequestParam(name = "region") String region) {
        List<Whisky> whiskies = whiskyRepository.findByDistilleryRegionEqualsIgnoreCase(region);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/age")
    public ResponseEntity<List<Whisky>> getByAge(@RequestParam(name = "age") int age) {
        List<Whisky> whiskies = whiskyRepository.findByAgeEquals(age);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }

}
