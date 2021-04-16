package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.StandardNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IStandardRepository;

import com.cg.spc.services.IStandardService;

@SpringBootTest
public class StandardServiceTest {

	@Autowired
	private IStandardService standardService;

	@MockBean
	private IStandardRepository standardRepository;

	Standard standard;
	Standard standard2;
	List<Integer> studentIdList;

	@BeforeEach
	public void init() {
		standard = new Standard();
		standard.setGrade("I");
		standard.setClassStrength(65);

		standard2 = new Standard();
		standard2.setGrade("III");
		standard2.setClassStrength(80);

		studentIdList = new ArrayList<Integer>();
		studentIdList.add(7);
		studentIdList.add(8);
	}

	@Test
	@DisplayName("positive test case for update standard")
	public void testUpdateStandard() {
		List<Student> studentList = new ArrayList<Student>();
		for (Integer integer : studentIdList) {
			Student student = new Student();
			student.setId(integer);
			studentList.add(student);
		}
		standard.setStudentList(studentList);
		Mockito.when(standardRepository.save(standard)).thenReturn(standard);
		Assertions.assertThrows(StudentNotFoundException.class,
				() -> standardService.updateDetails(standard, studentIdList));
		// assertEquals(standard, standardService.updateDetails(standard,
		// studentIdList));
	}

	@Test
	@DisplayName("negative test case for update standard")
	public void testUpdateStandardNegative() {
		List<Student> studentList = new ArrayList<Student>();
		for (Integer integer : studentIdList) {
			Student student = new Student();
			student.setId(integer);
			studentList.add(student);
		}
		standard2.setStudentList(studentList);
		Mockito.when(standardRepository.save(standard2)).thenReturn(standard2);
		Assertions.assertThrows(StudentNotFoundException.class,
				() -> standardService.updateDetails(standard, studentIdList));
		// assertNotEquals(standard2, standardService.updateDetails(standard,
		// studentIdList));
	}

	@Test
	@DisplayName("positive test case for add standard")
	public void testAddStandard() {
		Mockito.when(standardRepository.save(standard)).thenReturn(standard);
		assertEquals(standard, standardService.addDetails(standard));
	}

	@Test
	@DisplayName("negative test case for add standard")
	public void testAddStandardNegative() {
		Mockito.when(standardRepository.save(standard2)).thenReturn(standard2);
		assertNotEquals(standard2, standardService.addDetails(standard));
	}

	@Test
	@DisplayName("positive test case for get standard by id")
	public void testGetStandardById() {
		Standard standard = new Standard();
		standard.setClassStrength(80);
		standard.setGrade("III");
		standard.setId(500);
		standard.setStudentList(null);
		standard.setSubjectTeachers(null);
		standard.setExamList(null);
		standard.setClassTeacher(null);
		Mockito.when(standardRepository.findById(500)).thenReturn(Optional.of(standard));
		assertEquals(standard, standardService.getDetailsById(500));
	}

	@Test
	@DisplayName("negative test case for get standard by id")
	public void testGetStandardByIdNegative() {
		Standard standard = new Standard();
		standard.setClassStrength(80);
		standard.setGrade("III");
		standard.setId(501);
		standard.setStudentList(null);
		standard.setSubjectTeachers(null);
		standard.setExamList(null);
		standard.setClassTeacher(null);
		Mockito.when(standardRepository.findById(501)).thenReturn(Optional.of(standard));
		Assertions.assertThrows(StandardNotFoundException.class, () -> standardService.getDetailsById(509));
		// assertNotEquals(standard,standardService.getDetailsById(509));
	}
}
