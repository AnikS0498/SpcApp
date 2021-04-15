package com.cg.spc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Subject;
import com.cg.spc.entities.Teacher;
import com.cg.spc.repositories.ITeacherRepository;
import com.cg.spc.services.ITeacherService;

class TeacherServiceTest {

	@Autowired
	private ITeacherService teacherService;
	
	@MockBean
	private ITeacherRepository teacherRepository;
	
	@Test
	@DisplayName("positive test case for add parent")
	public void testAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("teacher1");
		teacher.setSubject(Subject.ENGLISH);
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		assertEquals(teacher, teacherService.addTeacher(teacher));
		
	}

}
