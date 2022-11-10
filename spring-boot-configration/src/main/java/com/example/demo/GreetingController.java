package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${my.greeting:default value}")
	private String greet ;
	
	@Autowired
	Environment env;
	@GetMapping("/greeting")
	public String greeting(){
		return  greet;
	}
	
	@Autowired
	DBsettings dbSetting ;
	
	@GetMapping("/test")
	public String dbConnect() {
		return dbSetting.getConnection();
	}
	@GetMapping("/enviroment")
	public String getEnvdetail() {
		return env.toString();
	}
}
