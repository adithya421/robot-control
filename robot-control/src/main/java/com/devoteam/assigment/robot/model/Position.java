package com.devoteam.assigment.robot.model;

import static java.lang.String.format;

import com.devoteam.assigment.robot.model.Direction;
import com.devoteam.assigment.robot.model.Room;

public class Position {

	private final Room room;
	private Direction direction;
	private int x;
	private int y;

	public Position(Room room, Direction direction, int x, int y) {
		this.room = room;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}

	public void right() {
		switch (direction) {
		case NORTH:
			direction = Direction.EAST;
			break;
		case EAST:
			direction = Direction.SOUTH;
			break;
		case SOUTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.NORTH;
			break;
		}
	}

	public void left() {
		switch (direction) {
		case NORTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.SOUTH;
			break;
		case SOUTH:
			direction = Direction.EAST;
			break;
		case EAST:
			direction = Direction.NORTH;
			break;
		}
	}
	
	public  void forward() {
		    switch (direction) {
		      case NORTH:
		        y--;
		        break;
		      case SOUTH:
		        y++;
		        break;
		      case EAST:
		        x++;
		        break;
		      case WEST:
		        x--;
		        break;
		    }
		    boolean outOfRoom = x > room.getWide() || y > room.getDeep() || x < 0 || y < 0;
		    if (outOfRoom) {
		    	throw new IllegalArgumentException(format(
            "Robot can't be placed/move outside room. Room dimensions are [%s, %s], but Robot placed at [%s %s]",
            room.getWide(), room.getDeep(), x, y));
  }
		  }
	
	 @Override
	  public String toString() {
	    return format("Report: %s %s %s", x, y, direction);
	  }
}
