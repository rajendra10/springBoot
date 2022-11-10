package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.UserDetailService;
import com.example.demo.utility.AuthenticationRequest;
import com.example.demo.utility.AuthenticationResponse;
import com.example.demo.utility.JwtUtil;

@RestController
public class Rest_Controller {
	
	@Autowired
	AuthenticationManager authenticationManager ;
	
	@Autowired
	UserDetailService userdetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "WELCOME";
	}
	//cant call this endpoint direct since spring security 
	@RequestMapping(value="/authentication", method =RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest ) throws Exception
	{
		//this is for authenticate the userName and password which return the token
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect Credentials",e);
		}
		final UserDetails userDetails =userdetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt)); //payload of response will be AuthenticationResponse
		
	}
}
