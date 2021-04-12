package com.cg.spc.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "attendance",cascade = CascadeType.ALL)
	private Student student;
	
	@Column
	private LocalDate attendanceDate;
	
	@Column(length = 5)
	private boolean isPresent;

	public Attendance() {
		super();
		
	}

	public Attendance(Student student, LocalDate attendanceDate, boolean isPresent) {
		super();
		this.student = student;
		this.attendanceDate = attendanceDate;
		this.isPresent = isPresent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", student=" + student + ", attendanceDate=" + attendanceDate + ", isPresent="
				+ isPresent + "]";
	}
	
}
