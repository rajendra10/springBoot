package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	@GetMapping("/person/{id}")
	public boolean isPersonPresent (@PathVariable("id") int personId)
	{
		System.out.println("controller");
		return service.isPersonPresent(personId);
	}
}
