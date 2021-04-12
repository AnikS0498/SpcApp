package com.cg.spc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Exam;
import com.cg.spc.entities.ReportCard;
import com.cg.spc.services.IExamService;
import com.cg.spc.services.IReportCardService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private IExamService examService;
	
	@Autowired
	private IReportCardService reportCardService;
	
	@PostMapping("/exam/add")
	public Exam addExamDetails(@RequestBody Exam exam)
	{
		return examService.addExam(exam);
	}
	
	@PostMapping("/exam/update")
	public Exam updateExamDetails(@RequestBody Exam exam)
	{
		return examService.updateExam(exam);
	}
	
	@PostMapping("/reportCard/add")
	public ReportCard addReportCardDetails(@RequestBody ReportCard reportCard)
	{
		return reportCardService.addDetails(reportCard);
	}
}
