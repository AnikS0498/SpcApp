package com.cg.spc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Standard {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String grade;
	
	private Teacher classTeacher;
	
	@Column
	private int classStrength;
	
	public Standard() {
		super();
	}

	public Standard(String grade, Teacher classTeacher, int classStrength) {
		super();
		this.grade = grade;
		this.classTeacher = classTeacher;
		this.classStrength = classStrength;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public int getClassStrength() {
		return classStrength;
	}

	public void setClassStrength(int classStrength) {
		this.classStrength = classStrength;
	}

	@Override
	public String toString() {
		return "Standard [id=" + id + ", grade=" + grade + ", classTeacher=" + classTeacher + ", classStrength="
				+ classStrength + "]";
	}
	
	
	
}
