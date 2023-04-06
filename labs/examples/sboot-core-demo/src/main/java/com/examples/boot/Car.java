package com.examples.boot;

import org.springframework.beans.factory.annotation.Value;

public class Car {

//	@Value("${car.color}")
	private String color;
//	@Value("${car.model}")
	private String model;
//	@Value("${car.manufacturer}")
	private String manufacturer;
	private Engine engine;
	
	public Car() {
		System.out.println("Car default constructor called...");
	}

	public Car(Engine engine) {
		System.out.println("Car constructor called..");
		this.engine = engine;
	}

	public Car(String color, String model, String manufacturer, Engine engine) {
		this.color = color;
		this.model = model;
		this.manufacturer = manufacturer;
		this.engine = engine;
	}
	
	public static Car createInstance(Engine engine) {
		System.out.println("Car static factory method called...");
		Car car = new Car(engine);
		return car;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		System.out.println("Car setter called..");
		this.engine = engine;
	}

	public void init() {
		System.out.println("Car Bean Initialized...");
	}

	public void destroy() {
		System.out.println("Car Bean Destroyed...");
	}

	@Override
	public String toString() {
		return "Car{" +
				"color='" + color + '\'' +
				", model='" + model + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", engine=" + engine +
				'}';
	}
}
