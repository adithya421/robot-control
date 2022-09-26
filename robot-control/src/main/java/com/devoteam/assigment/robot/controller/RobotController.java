package com.devoteam.assigment.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devoteam.assigment.robot.request.RobotInputsRequest;
import com.devoteam.assigment.robot.response.RobotReportResponse;
import com.devoteam.assigment.robot.service.RobotService;

@RestController
public class RobotController {

	@Autowired RobotService robotService;
	@CrossOrigin
	 @PostMapping("/robot-report")
	  RobotReportResponse getRobotReport(@RequestBody RobotInputsRequest inputs) {
		 RobotReportResponse response = new RobotReportResponse();
		 response.setStatusCode(200);
		 response.setStatusMessage("SUCCESS");
		 response.setReport(robotService.getRobotReport(inputs));
	    return response;
	  }
}
