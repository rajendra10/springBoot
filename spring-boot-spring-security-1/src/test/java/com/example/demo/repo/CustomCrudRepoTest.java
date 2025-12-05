package com.example.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Person;

@SpringBootTest
class CustomCrudRepoTest {

	@Autowired
	private CustomCrudRepo crudRepo ;
	@BeforeEach
	void setUp() throws Exception {
		Person p = new Person(4, "l4", "f4", "add4", "city4s");
		crudRepo.save(p);
	}

	@Test
	void testFindPersonById() {
		System.out.println("------"+crudRepo.findPersonById(1));
	 Boolean actualResult = (null!=crudRepo.findPersonById(7));
	 assertThat(actualResult).isTrue();
	}

}
