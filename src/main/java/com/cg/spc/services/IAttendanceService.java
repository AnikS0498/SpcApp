package com.cg.spc.services;

import com.cg.spc.entities.Attendance;

public interface IAttendanceService {
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendance(Attendance attendance);
	public Attendance getAttendanceById(int id);
	public Attendance deleteById(int id);
}
