//package com.example.demo.test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class WeatherApplicationTests {
//
// @Autowired
// private TestRestTemplate restTemplate;
//
// @Test
// public void testWeatherEndpoint() {
//     ResponseEntity<String> response = restTemplate.getForEntity("/weather?pincode=411014&for_date=2023-10-15", String.class);
//     assertThat(response.getStatusCodeValue()).isEqualTo(200);
//     assertThat(response.getBody()).contains("weather");
// }
//}

