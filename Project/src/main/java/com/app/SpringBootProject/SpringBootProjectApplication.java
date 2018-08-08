package com.app.SpringBootProject;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class SpringBootProjectApplication.
 */

@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootProjectApplication {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger("SpringBootProjectApplication.class");

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */

	public static void main(String[] args) {
		
	
		SpringApplication.run(SpringBootProjectApplication.class, args);
		
		LOGGER.info("started. . .!!!");
	}
}

