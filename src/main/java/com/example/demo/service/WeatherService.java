package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.WeatherCache;
import com.example.demo.repository.WeatherRepository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class WeatherService {

 @Autowired
 private WeatherRepository weatherRepository;

 @Value("${openweather.api.key}")
 private String apiKey;

 @Value("${openweather.api.url}")
 private String weatherApiUrl;

 @Value("${geocode.api.url}")
 private String geocodeApiUrl;

 private final RestTemplate restTemplate = new RestTemplate();

 public String getWeather(String pincode, LocalDate date) {
   
     Optional<WeatherCache> cachedData = weatherRepository.findByPincodeAndDate(pincode, date);
     if (cachedData.isPresent()) {
         return cachedData.get().getWeatherData();
     }

     
     String geocodeUrl = geocodeApiUrl + "?zip=" + pincode + ",IN&appid=" + apiKey;
     var geocodeResponse = restTemplate.getForObject(geocodeUrl, Map.class);
     double lat = (double) geocodeResponse.get("lat");
     double lon = (double) geocodeResponse.get("lon");

     // Fetch weather data
     String weatherUrl = weatherApiUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
     var weatherResponse = restTemplate.getForObject(weatherUrl, String.class);

     // Cache the weather data
     WeatherCache weatherCache = new WeatherCache();
     weatherCache.setPincode(pincode);
     weatherCache.setLatitude(lat);
     weatherCache.setLongitude(lon);
     weatherCache.setDate(date);
     weatherCache.setWeatherData(weatherResponse);
     weatherRepository.save(weatherCache);

     return weatherResponse;
 }
}

