package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public interface CustomCrudRepo extends JpaRepository<Person ,Integer >{

	@Query("SELECT p FROM Person p WHERE p.personid = :id")
	public Person findPersonById(@Param("id") Integer personid);
}
