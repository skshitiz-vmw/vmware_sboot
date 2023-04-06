package com.examples.boot;

public class Engine {

	private int capacity;
	private int noOfCynclinders;
	private int torque;

	public Engine() {}

	public Engine(int capacity, int noOfCynclinders, int torque) {
		this.capacity = capacity;
		this.noOfCynclinders = noOfCynclinders;
		this.torque = torque;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNoOfCynclinders() {
		return noOfCynclinders;
	}

	public void setNoOfCynclinders(int noOfCynclinders) {
		this.noOfCynclinders = noOfCynclinders;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	@Override
	public String toString() {
		return "Engine{" +
				"capacity=" + capacity +
				", noOfCynclinders=" + noOfCynclinders +
				", torque=" + torque +
				'}';
	}
}
