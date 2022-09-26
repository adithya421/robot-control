package com.devoteam.assigment.robot.service;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.devoteam.assigment.robot.model.Direction;
import com.devoteam.assigment.robot.model.Move;
import com.devoteam.assigment.robot.model.Position;
import com.devoteam.assigment.robot.model.Room;
import com.devoteam.assigment.robot.request.RobotInputsRequest;

@Service
public class RobotService {

	public String getRobotReport(RobotInputsRequest inputs) throws IllegalArgumentException {

		Room room = setRoom(inputs.getWide(), inputs.getDeep());
		
		Direction direction = setDirection(inputs.getOrientation().toUpperCase());
		
		Position position = new Position(room, direction, inputs.getPositionX(), inputs.getPositionY());
		
		Stream<String> moveCommands = Arrays.stream(inputs.getCommands().toUpperCase().split(""));
		List<Move> moves = moveCommands.map(this::toMove).collect(toList());

		perform(moves,position);

		return position.toString();
	}
	
	private Room setRoom(Integer width,Integer deep) {
		Room room = new Room();
		room.setDeep(deep);
		room.setWide(width);
		return room;
	}

	private Move toMove(String moveCommand) {
		switch (moveCommand) {
		case "F":
			return Move.FORWARD;
		case "L":
			return Move.LEFT;
		case "R":
			return Move.RIGHT;
		}
		throw new IllegalArgumentException(format("This direction not known to robot for move [%s]", moveCommand));
	}


	private Direction setDirection(String directionCommand) {
		switch (directionCommand) {
		case "N":
			return Direction.NORTH;
		case "E":
			return Direction.EAST;
		case "S":
			return Direction.SOUTH;
		case "W":
			return Direction.WEST;
		default:
			throw new IllegalArgumentException(format("Unknown direction [%s]", directionCommand));
		}
	}
	
	
	
	 public void perform(List<Move> moves, Position position) {
		    moves.forEach(move -> move.perform(position));
		  }

}
