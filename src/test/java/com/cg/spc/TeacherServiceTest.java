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
	
	Teacher teacher;
	Teacher teacher1;
	Standard standard;
	
	@BeforeEach
	public void init() {
		
			
			teacher = new Teacher();
			teacher.setId(100);
			teacher.setName("Shaw Ji");
			teacher.setStandard(null);
			teacher.setStandardList(null);
			teacher.setSubject(Subject.ENGLISH);
			
			teacher1 = new Teacher();
			teacher1.setId(100);
			teacher1.setName("Shaw Ji");
			teacher1.setStandard(null);
			teacher1.setStandardList(null);
			teacher1.setSubject(Subject.ENGLISH);
			
		
		
	}

	@Test
	@DisplayName("positive test case for add parent")
	public void testAddTeacher() {
		
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertEquals(teacher, teacherService.addTeacher(teacher));

	}

	@Test
	@DisplayName("negative test case for add parent")
	public void testAddTeacherNegative() {
		
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertNotEquals("teacher2", teacherService.addTeacher(teacher).getName());

	}

	

	@Test
	@DisplayName("positive test case for update parent")
	public void testUpdateTeacher() {
		
		java.util.List<Standard> standardList = new ArrayList<>();
		
		java.util.List<Integer> intList = new ArrayList<>();
		intList.add(101);
		
		standard = new Standard();
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
	public void testUpdateTeacherNegative() {
		
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
	public void testGetTeacherById() {
		Mockito.when(teacherRepository.findById(100)).thenReturn(Optional.of(teacher));
		assertThat(teacherService.getTeacherById(100)).isEqualTo(teacher);
		
		
	}
	
	@Test
	@DisplayName("negative test for getTeacherById")
	public void testGetTeacherByIdNegative() {
		
		Mockito.when(teacherRepository.findById(100)).thenReturn(Optional.of(teacher));
		Assertions.assertThrows(TeacherNotFoundException.class,()-> teacherService.getTeacherById(101));
		
	}
	
	@Test
	@DisplayName("positive test for getAllTeachers")
	public void testGetAllTeachers() {
		
		java.util.List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacher);
		teacherList.add(teacher1);
		
		Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
		assertThat(teacherService.getAllTeachers()).isEqualTo(teacherList);
	}
	
	
	@Test
	@DisplayName("negative test for getAllTeachers")
	public void testGetAllTeachersNegative() {
		
		java.util.List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacher);
		teacherList.add(teacher1);
		
		Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
		assertNotEquals(10, teacherService.getAllTeachers().size());
		
	}

	
	@Test
	@DisplayName("positive test for deleteTeacher")
	public void testDeleteTeacher() {
		
		Mockito.when(teacherRepository.findById(teacher.getId())).thenReturn(Optional.of(teacher));
		teacherService.deleteTeacherById(100);
		Mockito.verify(teacherRepository, Mockito.times(1)).deleteById(100);
		
	}


}
