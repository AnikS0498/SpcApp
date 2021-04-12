package com.cg.spc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fee {
	
	/*id : int
	-student : Student (OneToOne) uni
	-feeDue : double
	-feePaid : double
	-totalFee : Final double*/
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Student student;
	private double feeDue;
	private double feePaid;
	private final double totalFee = 10000;
	
	public Fee() {
		super();
	}
	
	public Fee(int id, Student student, double feeDue, double feePaid) {
		super();
		this.id = id;
		this.student = student;
		this.feeDue = feeDue;
		this.feePaid = feePaid;
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

	public double getFeeDue() {
		return feeDue;
	}

	public void setFeeDue(double feeDue) {
		this.feeDue = feeDue;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public double getTotalFee() {
		return totalFee;
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", student=" + student + ", feeDue=" + feeDue + ", feePaid=" + feePaid + ", totalFee="
				+ totalFee + "]";
	}
	

}
