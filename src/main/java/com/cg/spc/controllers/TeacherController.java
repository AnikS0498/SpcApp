package com.cg.spc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Diary;
import com.cg.spc.entities.Exam;
import com.cg.spc.entities.ReportCard;
import com.cg.spc.services.IAttendanceService;
import com.cg.spc.services.IDiaryService;
import com.cg.spc.services.IExamService;
import com.cg.spc.services.IReportCardService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private IExamService examService;
	
	@Autowired
	private IReportCardService reportCardService;
	
	@Autowired
	private IAttendanceService attendanceService;
	
	@Autowired
	private IDiaryService diaryService;
	
	@PostMapping("/exam/add")
	public Exam addExamDetails(@RequestBody Exam exam)
	{
		return examService.addExam(exam);
	}
	
	@PutMapping("/exam/update")
	public Exam updateExamDetails(@RequestBody Exam exam)
	{
		return examService.updateExam(exam);
	}
	
	@PostMapping("/reportCard/add")
	public ReportCard addReportCardDetails(@RequestBody ReportCard reportCard,@RequestParam int studentId)
	{
		return reportCardService.addDetails(reportCard,studentId);
	}
	
	@PutMapping("/reportCard/update")
	public ReportCard updateReportCardDetails(@RequestBody ReportCard reportCard,@RequestParam int studentId)
	{
		return reportCardService.addDetails(reportCard,studentId);
	}
	
	@PostMapping("/attendance/add")
	public Attendance addAttendanceDetails(@RequestBody Attendance attendance, @RequestParam int studentId) {
		return attendanceService.addAttendance(attendance, studentId);
	}
	
	@PutMapping("/attendance/update")
	public Attendance updateAttendanceDetails(@RequestBody Attendance attendance, @RequestParam int studentId) {
		return attendanceService.updateAttendance(attendance, studentId);
	}
	
	@PostMapping("/dailyDiary/add")
	public Diary addDailyDiaryDetails(@RequestBody Diary diary, @RequestParam int studentId) {
		return diaryService.addDiary(diary, studentId);
	}
	
	@PutMapping("/dailyDiary/update")
	public Diary updateDailyDiaryDetails(@RequestBody Diary diary, @RequestParam int studentId) {
		return diaryService.updateDiary(diary, studentId);
	}
	
}
