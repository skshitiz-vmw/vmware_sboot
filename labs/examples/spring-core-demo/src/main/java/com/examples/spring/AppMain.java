package com.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args)
	{
		Car bmw = new Car();
		bmw.setColor("White");
		bmw.setManufacturer("BMW");
		bmw.setModel("X7");

		Engine petrol = new Engine();
		petrol.setCapacity(3000);
		petrol.setNoOfCynclinders(6);
		petrol.setTorque(700);

//		Engine electic = new Engine();
//		electic.setCapacity(4000);
//		electic.setNoOfCynclinders(4);
//		electic.setTorque(10);

		bmw.setEngine(petrol);

		System.out.println("Manufacturer: " + bmw.getManufacturer());
		System.out.println("Color: " + bmw.getColor());
		System.out.println("Capacity: " + bmw.getEngine().getCapacity());
		
		// Instantiate IoC container
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		System.out.println("No of beans: " + context.getBeanDefinitionCount());
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

		Car bmw = (Car) context.getBean("bmw");

		System.out.println("Manufacturer: " + bmw.getManufacturer());
		System.out.println("Color: " + bmw.getColor());
		System.out.println("Capacity: " + bmw.getEngine().getCapacity());

		context.registerShutdownHook();
		
	}
}