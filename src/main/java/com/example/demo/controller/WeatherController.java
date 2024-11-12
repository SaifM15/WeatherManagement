package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WeatherService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/categories")
public class WeatherController {

 @Autowired
 private WeatherService weatherService;

 @GetMapping("/weather")
 public String getWeather(
          @RequestParam(required = false) String pincode,
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate for_date) {
     System.out.println("In weather");
     return weatherService.getWeather(pincode, for_date);
 }


 
 
}

