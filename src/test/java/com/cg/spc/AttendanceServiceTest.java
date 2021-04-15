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

		attendance.setAttendanceDate(LocalDate.of(2021, 3, 19));
		attendance.setPresent(true);

		Mockito.when(attendanceRepository.save(attendance)).thenReturn(attendance);
		assertEquals(attendance, attendanceService.addAttendance(attendance,38));
	}

	
	  @Test
	  
	  @DisplayName("Negative test case for add attendance")
	  
	  public void testAddAttendancetNegative() {
	  
	  Attendance attendance = new Attendance();
	  
	  attendance.setAttendanceDate(LocalDate.of(2021, 3, 19));
	  attendance.setPresent(true);
	  
	  Mockito.when(attendanceRepository.save(attendance)).thenReturn(attendance);
	  assertNotEquals(attendance, attendanceService.addAttendance(attendance, 36));
	  }
	 

}