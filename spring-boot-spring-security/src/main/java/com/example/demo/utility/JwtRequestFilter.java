package com.example.demo.utility;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.security.UserDetailService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailService userDetailsService ;
	@Autowired
	JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHead = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		
		if(authorizationHead!=null && authorizationHead.startsWith("Bearer "))
		{
			jwt = authorizationHead.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken userPasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
			userPasswordAuthenticationToken.setDetails(userPasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(userPasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
