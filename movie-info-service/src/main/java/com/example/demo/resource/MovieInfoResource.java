package com.example.demo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@RequestMapping("/{movieID}")
	public Movie getMovie(@PathVariable("movieID") String movieID) throws Exception{
		return new Movie("TestMovieID","MovieTestName","TestDesc");
	}
}
