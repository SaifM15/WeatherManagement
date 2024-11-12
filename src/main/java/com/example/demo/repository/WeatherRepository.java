package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.WeatherCache;

import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherCache, Long> {
 Optional<WeatherCache> findByPincodeAndDate(String pincode, LocalDate date);
}
