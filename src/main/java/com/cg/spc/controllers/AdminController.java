package com.cg.spc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.spc.entities.Parent;
import com.cg.spc.entities.Student;
import com.cg.spc.entities.Teacher;
import com.cg.spc.services.IParentService;
import com.cg.spc.services.IStudentService;
import com.cg.spc.services.ITeacherService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IParentService parentService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITeacherService teacherService;

	@PostMapping("/addParent")
	public Parent addParentDetails(@RequestBody Parent parent) {
		return parentService.addParentDetails(parent);
	}
	
	@PutMapping("/updateParent")
	public Parent updateParentDetails(@RequestBody Parent parent)
	{
		return parentService.updateParentDetails(parent);
	}
	
	@PostMapping("/addStudent")
	public Student addStudentDetails(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@PutMapping("/updateStudent")
	public int updateStudentDetails(@RequestBody Student student,@RequestParam int parentId)
	{
		return studentService.updateStudent(parentId, student);
	}
	
	@PostMapping("/addTeacher")
	public Teacher addTeacherDetails(@RequestBody Teacher teacher)
	{
		return teacherService.addTeacher(teacher);
	}
	
	

}
