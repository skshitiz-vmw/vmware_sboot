package com.examples.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbootCoreDemoApplication implements CommandLineRunner {

	// Logging Frameworks - Log4J, Logback, JCL
	// SLF4J - Uniform Logging API

	Logger log = LoggerFactory.getLogger(SbootCoreDemoApplication.class);

	@Autowired
	ApplicationContext context;

//	@Autowired
//	CarConfig carConfig;

	public static void main(String[] args) {
		SpringApplication.run(SbootCoreDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.trace("TRACE LOG");
		log.debug("DEBUG LOG");
		log.info("INFO LOG");
		log.warn("WARN LOG");
		log.error("ERROR LOG");

		Car bmw = context.getBean("bmw", Car.class);
//		System.out.println(bmw);
//		bmw.setColor(carConfig.getColor());
//		bmw.setManufacturer(carConfig.getManufacturer());
//		bmw.setModel(carConfig.getModel());
		log.info(bmw.toString());
	}
}
