package com.cg.spc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SPCGlobalExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex){
		
		String response = "This student does not exist";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ReportCardNotFoundException.class)
	public ResponseEntity<Object> handleReportCardNotFoundException(ReportCardNotFoundException ex){
		
		String response = "Report card not found";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = StandardNotFoundException.class)
	public ResponseEntity<Object> handleStandardNotFoundException(StandardNotFoundException ex){
		
		String response = "Invalid Standard";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DateNotFoundException.class)
	public ResponseEntity<Object> handleDateNotFoundException(DateNotFoundException ex){
		
		String response = "No exam scheduled on this date";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ConcernResolvedException.class)
	public ResponseEntity<Object> handleConcernResolvedException(ConcernResolvedException ex){
		
		String response = "Concern has already been resolved";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ParentNotFoundException.class)
	public ResponseEntity<Object> handleParentNotFoundException(ParentNotFoundException ex){
		
		String response = "Parent not found";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = TeacherNotFoundException.class)
	public ResponseEntity<Object> handleTeacherNotFoundException(TeacherNotFoundException ex){
		
		String response = "This teacher does not exist";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
}
