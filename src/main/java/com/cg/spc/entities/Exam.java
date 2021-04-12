package com.cg.spc.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Entity
public class Exam {

	private LocalDate date;

	@Enumerated(EnumType.STRING)
	private Subject subject;

	@ManyToMany(mappedBy = "examList")
	private List<Standard> standard;

	private String duration;

	private int marks;

	public Exam() {
		super();
	}

	public Exam(LocalDate date, Subject subject, List<Standard> standard, String duration, int marks) {
		super();
		this.date = date;
		this.subject = subject;
		this.standard = standard;
		this.duration = duration;
		this.marks = marks;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Standard> getStandard() {
		return standard;
	}

	public void setStandard(List<Standard> standard) {
		this.standard = standard;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Exam [date=" + date + ", subject=" + subject + ", standard=" + standard + ", duration=" + duration
				+ ", marks=" + marks + "]";
	}

}
