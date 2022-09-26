package com.devoteam.assigment.robot.request;

import lombok.Data;

@Data
public class RobotInputsRequest {
	
	private Integer wide;
	
	private Integer deep;
	
	private Integer positionX;
	
	private Integer positionY;
	
	private String orientation;
	
	private String commands;

}
