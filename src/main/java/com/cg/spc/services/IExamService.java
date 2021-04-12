package com.cg.spc.services;

import java.util.List;

import com.cg.spc.entities.Exam;

public interface IExamService {

	public Exam addExam(Exam exam);
	public Exam deleteExamById(int id);
	public Exam updateExam(Exam exam);
	public Exam getExamById(int id);
	public List<Exam> getAllExamDetails();
}
