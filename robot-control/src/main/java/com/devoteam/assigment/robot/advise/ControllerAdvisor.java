package com.devoteam.assigment.robot.advise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devoteam.assigment.robot.response.ErrorResponse;

@ControllerAdvice
@ResponseBody
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<ErrorResponse> handleConflict(IllegalArgumentException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatusCode(400);
		error.setStatusMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
