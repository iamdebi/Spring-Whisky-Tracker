package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long>, DistilleryRepositoryCustom {
    List<Distillery> findByRegionEqualsIgnoreCase(String region);

    List<Distillery> findByNameEqualsIgnoreCase(String name);

    List<Distillery> findDistilleryByWhiskiesAge(int age);
}
