package com.cg.spc.services;

import java.util.List;
import com.cg.spc.entities.Exam;

public interface IExamService {

	public Exam addExam(Exam exam,List<Integer> standardIdList);
	public Exam deleteExamById(int id);
	public Exam updateExam(Exam exam,List<Integer> standardIdList);
	public Exam getExamById(int id);
	public List<Exam> getAllExamDetails();
}
