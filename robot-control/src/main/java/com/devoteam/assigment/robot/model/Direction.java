package com.devoteam.assigment.robot.model;

public enum Direction {

	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	public final String name;

	Direction(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
