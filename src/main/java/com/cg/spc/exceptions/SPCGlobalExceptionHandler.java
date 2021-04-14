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
	
	@ExceptionHandler(value = DiaryNotFoundException.class)
	public ResponseEntity<Object> handleDiaryNotFoundException(DiaryNotFoundException ex){
		
		String response = "This diary does not exist";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ExamNotFoundException.class)
	public ResponseEntity<Object> handleExamNotFoundException(ExamNotFoundException ex){
		
		String response = "This exam does not exist";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = FeeNotFoundException.class)
	public ResponseEntity<Object> handleFeeNotFoundException(FeeNotFoundException ex){
		
		String response = "Fee details not found";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
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
		
		String response = "Date not found";
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
}
