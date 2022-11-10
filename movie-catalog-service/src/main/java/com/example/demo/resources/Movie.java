package com.example.demo.resources;

public class Movie {
private String movieID;
private String name;
private String des;

public Movie() {
	
}
public Movie(String movieID, String name, String des) {
	super();
	this.movieID = movieID;
	this.name = name;
	this.des = des;
}
public String getMovieID() {
	return movieID;
}
public void setMovieID(String movieID) {
	this.movieID = movieID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}

}
