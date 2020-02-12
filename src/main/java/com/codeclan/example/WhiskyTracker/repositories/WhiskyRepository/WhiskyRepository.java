package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {
    List<Whisky> findByYearEquals(int year);

    List<Whisky> findByYearEqualsAndDistilleryNameEquals(int year, String distillery);

    List<Whisky> findByDistilleryRegionEquals(String region);

    List<Whisky> findByAgeEquals(int age);
}
