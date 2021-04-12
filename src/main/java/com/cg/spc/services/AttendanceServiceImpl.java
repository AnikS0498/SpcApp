package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.spc.entities.Attendance;
import com.cg.spc.repositories.IAttendanceRepository;

public class AttendanceServiceImpl implements IAttendanceService{

	@Autowired
	private IAttendanceRepository attendanceRepository;

	@Override
	public Attendance addAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
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
