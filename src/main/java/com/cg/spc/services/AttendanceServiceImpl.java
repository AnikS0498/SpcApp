package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IAttendanceRepository;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class AttendanceServiceImpl implements IAttendanceService{

	@Autowired
	private IAttendanceRepository attendanceRepository;

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public Attendance addAttendance(Attendance attendance, int studentId) {
		Student student = studentRepository.findById(studentId).get();
		attendance.setStudent(student);
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateAttendance(Attendance attendance, int studentId) {
		Student student = studentRepository.findById(studentId).get();
		attendance.setStudent(student);
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance getAttendanceById(int id) {
		return attendanceRepository.findById(id).get();
	}

	@Override
	public Attendance deleteById(int id) {
		Attendance attendance = attendanceRepository.findById(id).get();
		attendanceRepository.deleteById(id);
		return attendance;	}
}
