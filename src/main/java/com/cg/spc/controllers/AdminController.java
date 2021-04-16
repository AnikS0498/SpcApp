package com.cg.spc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Parent> addParentDetails(@RequestBody Parent parent) {
		return new ResponseEntity<Parent>(parentService.addParentDetails(parent),HttpStatus.CREATED) ;
	}

	@PutMapping("/parent/update")
	public ResponseEntity<Integer> updateParentDetails(@RequestBody Parent parent, @RequestParam List<Integer> studentIdList) {
		return new ResponseEntity<Integer>(parentService.updateParentDetails(parent, studentIdList),HttpStatus.OK);
	}

	@GetMapping("/parent/getParents")
	public ResponseEntity<List<Parent>>  getAllParent() {
		return new ResponseEntity<List<Parent>>(parentService.getAllParent(),HttpStatus.OK);
	}

	@PostMapping("/student/add")
	public ResponseEntity<Student> addStudentDetails(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
	}

	@PutMapping("/student/update")
	public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student),HttpStatus.OK);
	}

	@PostMapping("/teacher/add")
	public ResponseEntity<Teacher> addTeacherDetails(@RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher> (teacherService.addTeacher(teacher),HttpStatus.CREATED);
	}

	@PutMapping("/teacher/update")
	public ResponseEntity<Teacher> updateTeacherDetails(@RequestBody Teacher teacher, @RequestParam List<Integer> standardIdList,
			@RequestParam int standardId) {

		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, standardIdList, standardId),HttpStatus.OK);
	}

	@GetMapping("/teacher/getTeachers")
	public ResponseEntity<List<Teacher>> getAllTeacher() {
		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(),HttpStatus.OK);
	}

	@PostMapping("/standard/add")
	public ResponseEntity<Standard> addStandardDetails(@RequestBody Standard standard) {
		return new ResponseEntity<Standard>(standardService.addDetails(standard), HttpStatus.CREATED);
	}

	@PutMapping("/standard/update")
	public ResponseEntity<Standard> updateStandardDetails(@RequestBody Standard standard,@RequestParam List<Integer> studentIdList) {
		return new ResponseEntity<Standard>(standardService.updateDetails(standard, studentIdList),HttpStatus.OK);
	}

}