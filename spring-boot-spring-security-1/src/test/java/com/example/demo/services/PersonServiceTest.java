package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repo.CustomCrudRepo;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	@Mock
	private CustomCrudRepo crudRepo ;
	
	private PersonService personService;
	
	@BeforeEach
	void setUp() throws Exception {
		this.personService = new PersonService(this.crudRepo);
	}

	@Test
	void testIsPersonPresent() {
		personService.isPersonPresent(0);
		verify(crudRepo).findPersonById(0);
	}


}
