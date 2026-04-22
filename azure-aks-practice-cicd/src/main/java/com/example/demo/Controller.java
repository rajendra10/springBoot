package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class Controller {
	
	@GetMapping("/name")
	public String getMessage(@PathParam(value = "name") String msg) {
		return "Hello "+msg;
		
	}
	@GetMapping("/heath")
	public String getHealth() {
		return "OK";
	}

}
