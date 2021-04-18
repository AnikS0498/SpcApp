package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.AttendanceNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IAttendanceRepository;
import com.cg.spc.repositories.IStudentRepository;


/**
 * 
 * 
 * Implementation class for AttendanceService
 *
 */
@Service
public class AttendanceServiceImpl implements IAttendanceService{

	@Autowired
	private IAttendanceRepository attendanceRepository;

	@Autowired
	private IStudentRepository studentRepository;

 /**
  * @param attendance, studentId
  * 
  * @return attendance
  * 
  * 	- if the studentId matches then attendance will be added
  * 
  */
	@Override
	public Attendance addAttendance(Attendance attendance, int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		attendance.setStudent(student);
		student.setAttendance(attendance);
		return attendanceRepository.save(attendance);
	}
	
	/**
	 * @param attendance, studentId
	 * 
	 * @return attendance
	 * 
	 * 	- if the studentId matches then attendance will be updated
	 * 
	 */
	@Override
	public Attendance updateAttendance(Attendance attendance, int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		attendance.setStudent(student);
		student.setAttendance(attendance);
		return attendanceRepository.save(attendance);
	}
	
	/**
	 * @param id 
	 * 
	 * @return attendance
	 * 
	 * 	- if the id matches then attendance will be retrieved
	 * 
	 */
	

	@Override
	public Attendance getAttendanceById(int id) {
		return attendanceRepository.findById(id).orElseThrow(() -> new AttendanceNotFoundException());
	}
	
	/**
	 * @param id
	 * 
	 * @return attendance
	 * 
	 * 	- if the studentId matches then attendance will be deleted
	 * 
	 */
	@Override
	public Attendance deleteById(int id) {
		Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new AttendanceNotFoundException());
		attendanceRepository.deleteById(id);
		return attendance;	
		}
	
	/**
	 * @param id
	 * 
	 * @return attendance
	 * 
	 * 	- if the studentId matches then attendance will be retrieved
	 * 
	 */
	@Override
	public Attendance getAttendanceByStudentId(int id) {
		@SuppressWarnings("unused")
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
		return attendanceRepository.findByStudentId(id);
	}
}
