package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@Autowired
	RestTemplate resttemplate ;
	
	String url = "https://gorest.co.in/public/v2/users/11/posts";
	
	@GetMapping("/countries")
	public List<Object> getCountries() {
		
		Object [] countries = resttemplate.getForObject(url, Object [].class);
		
		return Arrays.asList(countries);
		
	}
	@GetMapping("/hello")
	public String hello() {
		
		
		Object [] countries = resttemplate.getForObject(url, Object [].class);
		
		return "Hello";
		
	}
}

