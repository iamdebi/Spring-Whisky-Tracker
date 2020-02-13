package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {
    List<Whisky> findByYearEquals(int year);

    List<Whisky> findByYearEqualsAndDistilleryNameEqualsIgnoreCase(int year, String distillery);

    List<Whisky> findByDistilleryRegionEqualsIgnoreCase(String region);

    List<Whisky> findByAgeEquals(int age);

    List<Whisky> findByDistilleryNameEqualsIgnoreCase(String name);

    List<Whisky> findByYearEqualsAndDistilleryIdEquals(int year, Long distillery_id);
}
