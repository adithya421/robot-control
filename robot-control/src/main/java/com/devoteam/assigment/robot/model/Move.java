package com.devoteam.assigment.robot.model;

import java.util.function.Consumer;

public enum Move {
	FORWARD(Position::forward), LEFT(Position::left), RIGHT(Position::right);

	final Consumer<Position> onMove;

	Move(Consumer<Position> onMove) {
		this.onMove = onMove;
	}

	public void perform(Position position) {
		onMove.accept(position);
	}
}
