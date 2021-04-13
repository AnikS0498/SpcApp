package com.cg.spc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.spc.entities.Parent;
import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Student;
import com.cg.spc.entities.Teacher;
import com.cg.spc.services.IParentService;
import com.cg.spc.services.IStandardService;
import com.cg.spc.services.IStudentService;
import com.cg.spc.services.ITeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IParentService parentService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IStandardService standardService;

	@PostMapping("/parent/add")
	public Parent addParentDetails(@RequestBody Parent parent) {
		return parentService.addParentDetails(parent);
	}
	
	@PutMapping("/parent/update")
	public Parent updateParentDetails(@RequestBody Parent parent)
	{
		return parentService.updateParentDetails(parent);
	}
	
	@GetMapping("/parent/getParents")
	public List<Parent> getAllParent()
	{
		return parentService.getAllParent();
	}
	@PostMapping("/student/add")
	public Student addStudentDetails(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@PutMapping("/student/update")
	public int updateStudentDetails(@RequestBody Student student, @RequestParam int parentId)
	{
		return studentService.updateStudent(parentId, student);
	}
	
	@PostMapping("/teacher/add")
	public Teacher addTeacherDetails(@RequestBody Teacher teacher)
	{
		return teacherService.addTeacher(teacher);
	}
	
	@PutMapping("/teacher/update")
	public Teacher updateTeacherDetails(@RequestBody Teacher teacher,@RequestParam List<Integer> standardIdList,@RequestParam int standardId) {
		
		return teacherService.updateTeacher(teacher, standardIdList, standardId);
	}
	
	@GetMapping("/teacher/getTeachers")
	public List<String> getAllTeacher()
	{
		return teacherService.getAllTeachers();
	}
	
	@GetMapping("/teacher/getById/{tId}")
	public String getTeacherById(@PathVariable("tId") int tId) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
			String teacherJson = mapper.writeValueAsString(teacherService.getTeacherById(tId));
			return teacherJson;
//		Gson gson = new Gson();
//		String teacherGson = gson.toJson(teacherService.getTeacherById(tId));
//		return teacherGson;
	}
	
	@PostMapping("/standard/add")
	public Standard addStandardDetails(@RequestBody Standard standard)
	{
		return standardService.addDetails(standard);
	}
	
	@PutMapping("/standard/update")
	public Standard updateStandardDetails(@RequestBody Standard standard,@RequestParam List<Integer> examIdList)
	{
		return standardService.updateDetails(standard, examIdList);
	}
	
}
