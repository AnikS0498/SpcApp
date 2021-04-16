package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IStudentRepository;
import com.cg.spc.services.IStudentService;

@SpringBootTest
public class StudentServiceTest {
	

	@Autowired
	private IStudentService studentService;

	@MockBean
	private IStudentRepository studentRepository;
	
	Student student;
	
	@BeforeEach
	public void init() {
		student = new Student();
		student.setId(101);
		student.setName("Babu Rao");
		student.setAttendance(null);
		student.setDiary(null);
		student.setFee(null);
		student.setParent(null);
		student.setReportCard(null);
	}


	@Test
	@DisplayName("Positive test case for add student")
	public void testAddStudent() {
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertEquals("Babu Rao", studentService.addStudent(student).getName());
	}

	@Test
	@DisplayName("Negative test case for add student")
	public void testAddStudentNegative() {
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertNotEquals("Shyam", studentService.addStudent(student).getName());
	}
	
	
	@Test
	@DisplayName("Positive test case for getting all students")
	public void testGetAllStudents() {
		Mockito.when(studentRepository.findAll()).thenReturn(Stream.of(student).collect(Collectors.toList()));
		assertEquals(1, studentService.getAllStudents().size());
	}
	
	
	@Test
	@DisplayName("Negative test case for getting all students")
	public void testGetAllStudentsNegative() {
		Mockito.when(studentRepository.findAll()).thenReturn(Stream.of(student).collect(Collectors.toList()));
		assertNotEquals(2, studentService.getAllStudents().size());
	}
	
	@Test
	@DisplayName("Positive test case for update Student")
	public void testUpdateStudent() {
		student.setName("Babu Rao Ganpat Rao Apte");
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertEquals("Babu Rao Ganpat Rao Apte", studentService.updateStudent(student).getName());
	}
	
	@Test
	@DisplayName("Negative test case for update Student")
	public void testUpdateStudentNegative() {
		student.setName("Babu Rao Ganpat Rao Apte");
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertNotEquals("Babu Rao", studentService.updateStudent(student).getName());
	}
	
	@Test
	@DisplayName("Positive test case for getting student by ID")
	public void testGetStudentById() {
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		assertEquals(student, studentService.getStudentById(101));
	}
	
	@Test
	@DisplayName("Negative test case for getting student by ID")
	public void testGetByStudentIdNegative() {
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Assertions.assertThrows(StudentNotFoundException.class, ()->studentService.getStudentById(102));
	}

	
}