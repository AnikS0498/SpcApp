package com.cg.spc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
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
import com.cg.spc.entities.Subject;
import com.cg.spc.entities.Teacher;
import com.cg.spc.exceptions.StandardNotFoundException;
import com.cg.spc.exceptions.TeacherNotFoundException;
import com.cg.spc.repositories.IStandardRepository;
import com.cg.spc.repositories.ITeacherRepository;
import com.cg.spc.services.ITeacherService;



@SpringBootTest
class TeacherServiceTest {

	@Autowired
	private ITeacherService teacherService;

	@MockBean
	private ITeacherRepository teacherRepository;

	@MockBean
	private IStandardRepository standardRepository;

	@Test
	@DisplayName("positive test case for add parent")
	public void testAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("teacher1");
		teacher.setSubject(Subject.ENGLISH);
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertEquals(teacher, teacherService.addTeacher(teacher));

	}

	@Test
	@DisplayName("negative test case for add parent")
	public void negativeTestAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("teacher1");
		teacher.setSubject(Subject.ENGLISH);
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertNotEquals("teacher2", teacherService.addTeacher(teacher).getName());

	}

	@BeforeEach
	public void init() {
		
	}

	@Test
	@DisplayName("positive test case for update parent")
	public void testUpdateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("teacher1");
		teacher.setSubject(Subject.ENGLISH);
		// Standard standard = new Standard();
		java.util.List<Standard> standardList = new ArrayList<>();
		
		java.util.List<Integer> intList = new ArrayList<>();
		intList.add(101);
		
		Standard standard = new Standard();
		standard.setId(101);
		standard.setGrade("I");
		standard.setClassStrength(40);
		standard.setExamList(null);
		standard.setStudentList(null);
		standard.setClassTeacher(teacher);
		teacher.setStandard(standard);
		standardList.add(standard);
		teacher.setStandardList(standardList);
		
		
		Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertEquals(teacher, teacherService.updateTeacher(teacher, intList, 101));

	}
	
	@Test
	@DisplayName("negative test case for update parent")
	public void negativeTestUpdateTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("teacher1");
		teacher.setSubject(Subject.ENGLISH);
		// Standard standard = new Standard();
		java.util.List<Standard> standardList = new ArrayList<>();
		
		java.util.List<Integer> intList = new ArrayList<>();
		intList.add(101);
		
		Standard standard = new Standard();
		standard.setId(101);
		standard.setGrade("I");
		standard.setClassStrength(40);
		standard.setExamList(null);
		standard.setStudentList(null);
		standard.setClassTeacher(teacher);
		teacher.setStandard(standard);
		standardList.add(standard);
		teacher.setStandardList(standardList);
		
		
		Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		Assertions.assertThrows(StandardNotFoundException.class, ()->teacherService.updateTeacher(teacher, intList, 100));
		

	}
	
	
	@Test
	@DisplayName("positive test for getTeacherById")
	public void getTeacherByIdTest() {
		Teacher teacher = new Teacher();
		teacher.setId(100);
		teacher.setName("Shaw Ji");
		teacher.setStandard(null);
		teacher.setStandardList(null);
		teacher.setSubject(Subject.ENGLISH);
		
		Mockito.when(teacherRepository.findById(100)).thenReturn(Optional.of(teacher));
		assertThat(teacherService.getTeacherById(100)).isEqualTo(teacher);
		
		
	}
	
	@Test
	@DisplayName("negative test for getTeacherById")
	public void negativeTestGetTeacherById() {
		Teacher teacher = new Teacher();
		teacher.setId(100);
		teacher.setName("Shaw Ji");
		teacher.setStandard(null);
		teacher.setStandardList(null);
		teacher.setSubject(Subject.ENGLISH);
		
		Mockito.when(teacherRepository.findById(100)).thenReturn(Optional.of(teacher));
		Assertions.assertThrows(TeacherNotFoundException.class,()-> teacherService.getTeacherById(101));
		
	}
	
	@Test
	@DisplayName("positive test for getAllTeachers")
	public void getAllTeachers() {
		Teacher teacher = new Teacher();
		teacher.setId(100);
		teacher.setName("Shaw Ji");
		teacher.setStandard(null);
		teacher.setStandardList(null);
		teacher.setSubject(Subject.ENGLISH);
		
		Teacher teacher1 = new Teacher();
		teacher1.setId(100);
		teacher1.setName("Shaw Ji");
		teacher1.setStandard(null);
		teacher1.setStandardList(null);
		teacher1.setSubject(Subject.ENGLISH);
		
		java.util.List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacher);
		teacherList.add(teacher1);
		
		Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
		assertThat(teacherService.getAllTeachers()).isEqualTo(teacherList);
	}

	
//	@Test
//	@DisplayName("positive test for deleteTeacher")
//	public void deleteTeacherTest() {
//		
//		Teacher teacher = new Teacher();
//		teacher.setId(100);
//		teacher.setName("Shaw Ji");
//		teacher.setStandard(null);
//		teacher.setStandardList(null);
//		teacher.setSubject(Subject.ENGLISH);
//		
//		Teacher teacher1 = new Teacher();
//		teacher1.setId(101);
//		teacher1.setName("Shaw Ji");
//		teacher1.setStandard(null);
//		teacher1.setStandardList(null);
//		teacher1.setSubject(Subject.ENGLISH);
//		
//		when(teacherRepository.findById(101)).thenReturn(Optional.of(teacher1));
//		verify(teacherRepository, teacherService.deleteTeacherById(101));
//		
//	}


}
