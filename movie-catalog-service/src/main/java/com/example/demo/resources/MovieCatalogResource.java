package com.example.demo.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	RestTemplate resttemplate ;
	@RequestMapping("/{userID}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getcatalog(@PathVariable("userID") String UserID)
	{

		
//		Movie movie = resttemplate.getForObject("https://localhost:9011/movies", Movie.class);
//		List<Rating> ratings = Arrays.asList(
//				new Rating("m1", 4),
//				new Rating("m2", 5));
//		UserRatings ratings = resttemplate.getForObject("http://localhost:9012/ratingsdata/users/"+UserID, UserRatings.class);
		UserRatings ratings =resttemplate.getForObject("http://rating-data-service/ratingsdata/users/"+UserID, UserRatings.class);
		return ratings.getUserRating().stream().map(rating->{
			System.out.println( rating.getRating());
//			Movie movie = resttemplate.getForObject("http://localhost:9011/movies/"+rating.getMovieID(), Movie.class);
			Movie movie = resttemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieID(), Movie.class);
		    return	new CatalogItem(movie.getName(),movie.getDes(), rating.getRating());
		}).collect(Collectors.toList());
		
	}
	public List<CatalogItem> getFallbackCatalog(@PathVariable("userID") String UserID)
	{
		System.out.println("HERE AT fallback");
		return Arrays.asList(new CatalogItem( "No movie" , "",0));
		
	}
}
