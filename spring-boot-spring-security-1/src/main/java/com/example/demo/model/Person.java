package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="persons")
public class Person {
	@Id
	private int personid ;
	private String firstname;
	private String lastname;
	private String address ;
	private String city;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int personid, String firstname, String lastname, String address, String city) {
		super();
		this.personid = personid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
