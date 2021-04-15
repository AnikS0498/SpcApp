package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IAttendanceRepository;
import com.cg.spc.services.IAttendanceService;

@SpringBootTest
public class AttendanceServiceTest {

	@Autowired
	private IAttendanceService attendanceService;

	@MockBean
	private IAttendanceRepository attendanceRepository;

	@Test
	@DisplayName("Positive test case for add attendance")
	public void testAddAttendance() {

		Attendance attendance = new Attendance();
		attendance.setAttendanceDate(LocalDate.of(2021, 03, 19));
		attendance.setPresent(true);
		
		Student student = new Student();
		student.setId(10);
		attendance.setStudent(student);

		Mockito.when(attendanceRepository.save(attendance)).thenReturn(attendance);
		assertEquals(attendance, attendanceService.addAttendance(attendance,10));
	}

	
	  @Test
	  @DisplayName("Negative test case for add attendance") 
	  public void testAddAttendancetNegative() {
	  
	  Attendance attendance = new Attendance();
	  attendance.setAttendanceDate(LocalDate.of(2021, 03, 12));
	  attendance.setPresent(true);
	  
	  Student student = new Student();
	  student.setId(20);
	  attendance.setStudent(student);
	  
	  Attendance attendance2 = new Attendance();
	  attendance2.setAttendanceDate(LocalDate.of(2021, 03, 12));
	  attendance2.setPresent(true);
	  
	  Student student2 = new Student();
	  student2.setId(30);
	  attendance2.setStudent(student2);
	  
	  assertNotEquals(attendance2, attendanceService.addAttendance(attendance, 20));
	  }
	 

}