package com.example.demo.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.utility.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class websecurityAdaptor extends WebSecurityConfigurerAdapter{
	@Autowired
	private JwtRequestFilter  jwtRequestFilter;
	@Autowired
	UserDetailService ud;
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

	
 	@Bean
 	PasswordEncoder passwordEncode() {
 		return NoOpPasswordEncoder.getInstance();
 	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(ud);
 	}
 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		 http.csrf().disable()
 		 .authorizeRequests().antMatchers("/authentication").permitAll()
 		 .anyRequest().authenticated().and()
 		 .sessionManagement()
 		 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 		 http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
 	}
 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user")
//		.password("password")
//		.roles("USER");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
//			.hasRole("USER").and()
//			// Possibly more configuration ...
//			.formLogin() // enable form based log in
//			// set permitAll for all URLs associated with Form Login
//			.permitAll();
//	}
}
