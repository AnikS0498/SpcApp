package com.cg.spc.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "attendance")
	private Student student;
	
	@Column
	private LocalDate date;
	
	@Column(length = 5)
	private boolean isPresent;

	public Attendance() {
		super();
		
	}
	
	public Attendance(Student student, LocalDate date, boolean isPresent) {
		super();
		this.student = student;
		this.date = date;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", student=" + student + ", date=" + date + ", isPresent=" + isPresent + "]";
	}

	
	
}
