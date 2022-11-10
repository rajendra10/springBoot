package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

private static final Logger log = LoggerFactory.getLogger(HomeResource.class);

@RequestMapping("/")
public String home() {
	log.error("ERROR HAPPNED");
	log.error("ERROR HAPPNED");
	return "hello from spring boo";
}

	
}
