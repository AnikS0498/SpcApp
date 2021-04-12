package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Exam;
import com.cg.spc.repositories.IExamRepository;

@Service
public class ExamServiceImpl implements IExamService {

	@Autowired
	private IExamRepository examRepository;
	
	@Override
	public Exam addExam(Exam exam) {
		
		return examRepository.save(exam);
	}

	@Override
	public Exam deleteExamById(int id) {
		
		Exam exam=examRepository.findById(id).get();
		
		examRepository.deleteById(id);
		
		return exam;
	}

	@Override
	public Exam updateExam(Exam exam) {
		
		return examRepository.save(exam);
	}

	@Override
	public Exam getExamById(int id) {
	
		Exam exam = examRepository.findById(id).get();
		
		return exam;
	}

	@Override
	public List<Exam> getAllExamDetails() {
		
		return examRepository.findAll();
	}

	
}
