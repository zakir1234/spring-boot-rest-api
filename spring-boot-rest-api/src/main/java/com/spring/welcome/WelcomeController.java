package com.spring.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Zakir
 *
 */

@RestController
public class WelcomeController {
	
	public static final String WELCOME_MESSAGE = "Welcome to Spring Boot Rest API. Please Go to swagger for details :<a href='http://localhost:8080/swagger-ui.html'>Swagger</a>";

	@GetMapping("/")
	public String showWelcomeMessage() {
		return WELCOME_MESSAGE;
	}
	
}
