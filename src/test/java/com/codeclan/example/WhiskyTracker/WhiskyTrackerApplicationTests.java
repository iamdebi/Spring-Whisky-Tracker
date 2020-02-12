package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;
	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyFromAYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYearEquals(2018);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegionEqualsIgnoreCase("Speyside");
		assertEquals(2, foundDistilleries.size());
	}

	@Test
	public void canFindWhiskyFromDistilleryAndYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYearEqualsAndDistilleryNameEqualsIgnoreCase(1995, "Macallan");
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canFindDistilleryByName(){
		List<Distillery> foundDistilleries = distilleryRepository.findByNameEqualsIgnoreCase("Balvenie");
		assertEquals(1, foundDistilleries.size());
	}

	@Test
	public void canFindWhiskyFromRegion(){
		List<Whisky> foundWhiskey = whiskyRepository.findByDistilleryRegionEqualsIgnoreCase("Speyside");
		assertEquals(1, foundWhiskey.size());
	}

	@Test
	public void canFindWhiskeyage12(){
		List<Whisky> foundWhiskey = whiskyRepository.findByAgeEquals(12);
		assertEquals(2, foundWhiskey.size());
	}


}
