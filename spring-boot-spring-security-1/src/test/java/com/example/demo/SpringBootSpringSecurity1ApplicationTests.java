package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootSpringSecurity1ApplicationTests {
	
	
	Calculator c= new Calculator();

//	@BeforeAll
//	void setUp() {
//	c= new Calculator();
//	}

	@Test
	void contextLoads() {
	}
	@Test
	void testDoSum() {
		
		int actualResult = c.doSum(2, 3, 5);
		int expectedResult = 17;
		assertThat(actualResult).isEqualTo(expectedResult);
	}

}
