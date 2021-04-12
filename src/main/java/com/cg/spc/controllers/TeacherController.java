package com.cg.spc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Exam;
import com.cg.spc.services.IExamService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private IExamService examService;
	
	@PostMapping("/exam/add")
	public Exam addExamDetails(@RequestBody Exam exam)
	{
		return examService.addExam(exam);
	}

}
