package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieID}")
	public Rating getRating(@PathVariable("movieID") String movieID)
	{
		return new Rating(movieID,5);
	}
	@RequestMapping("/users/{userID}")
	public UserRatings getRatings (@PathVariable("userID") String userID)
	{
		List<Rating> rates = Arrays.asList(
				new Rating("m1", 4),
				new Rating("m2", 5));
		UserRatings userRating = new UserRatings();
		userRating.setUserRating(rates);
		return userRating;
	}
}
