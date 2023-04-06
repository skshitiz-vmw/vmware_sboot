package com.examples.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.examples"})
//@Configuration, @ComponentScan, @EnableAutoConfiguration
public class SbootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("Launching Spring Boot App...");
		SpringApplication.run(SbootHelloWorldApplication.class, args);
		// 1. Creates AppContext
		// 2. Constructs Beans and injects bean dependencies
		// 3. Call run method
		// 4. Launch the app

		System.out.println("Spring Boot App Launched!!!");

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(context);
		System.out.println("No of beans: " + context.getBeanDefinitionCount());
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}

		Greetings greetings = context.getBean("greetings", Greetings.class);
		System.out.println(greetings.getMessage());
	}
}
