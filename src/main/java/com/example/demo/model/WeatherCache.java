package com.example.demo.model;

//WeatherCache.java


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherCache {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String pincode;
 private double latitude;
 private double longitude;
 private LocalDate date;
 private String weatherData;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getWeatherData() {
	return weatherData;
}
public void setWeatherData(String weatherData) {
	this.weatherData = weatherData;
}

 
}

