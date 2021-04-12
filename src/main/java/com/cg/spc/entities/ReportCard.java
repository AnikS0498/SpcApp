package com.cg.spc.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReportCard {
	
	
	/*-id : int
	-Map<subjectId(Subject) , marks(int)>
	-student : Student (OneToOne) uni
	-isAttempted : boolean*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ElementCollection
	private Map <sujectId,marks> marksheet;
	@OneToOne
	private Student student;
	private boolean isAttempted;
	
	public ReportCard() {
		
	}
	
	public ReportCard(int id, Map<sujectId, marks> marksheet, Student student, boolean isAttempted) {
		super();
		this.id = id;
		this.marksheet = marksheet;
		this.student = student;
		this.isAttempted = isAttempted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<sujectId, marks> getMarksheet() {
		return marksheet;
	}

	public void setMarksheet(Map<sujectId, marks> marksheet) {
		this.marksheet = marksheet;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isAttempted() {
		return isAttempted;
	}

	public void setAttempted(boolean isAttempted) {
		this.isAttempted = isAttempted;
	}

	@Override
	public String toString() {
		return "ReportCard [id=" + id + ", isAttempted=" + isAttempted + "]";
	}
	

}
