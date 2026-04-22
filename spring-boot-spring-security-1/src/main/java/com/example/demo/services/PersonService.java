package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repo.CustomCrudRepo;

@Service
public class PersonService {

	@Autowired
	CustomCrudRepo repo;
	
	public PersonService(CustomCrudRepo repo) {
		this.repo = repo;
	}

	public boolean isPersonPresent(int id) {

		if (null!=this.repo.findPersonById(id))
			return true;
		
		return false;
		
	}
}
