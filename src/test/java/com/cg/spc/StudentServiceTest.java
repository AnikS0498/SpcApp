package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IStudentRepository;
import com.cg.spc.services.IStudentService;

@SpringBootTest
public class StudentServiceTest {
	

	@Autowired
	private IStudentService studentService;

	@MockBean
	private IStudentRepository studentRepo;


	@Test
	@DisplayName("Positive test case for add student")
	public void testAddStudent() {
		Student student = new Student();
		student.setName("Ravan");
		Mockito.when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student.getName(), studentService.addStudent(student).getName());
	}

	@Test
	@DisplayName("Negative test case for add student")
	public void testAddStudentNegative() {
		Student student = new Student();
		student.setName("Ravan");
		Mockito.when(studentRepo.save(student)).thenReturn(student);
		assertNotEquals("Shyam", studentService.addStudent(student).getName());
	}

	
}
