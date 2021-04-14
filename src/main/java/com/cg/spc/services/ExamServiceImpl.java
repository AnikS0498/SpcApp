package com.cg.spc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Exam;
import com.cg.spc.entities.Standard;
import com.cg.spc.repositories.IExamRepository;
import com.cg.spc.repositories.IStandardRepository;

@Service
public class ExamServiceImpl implements IExamService {

	@Autowired
	private IExamRepository examRepository;
	
	@Autowired
	private IStandardRepository standardRepository;
	
	@Override
	public Exam addExam(Exam exam,List<Integer> standardIdList) {
		List<Standard> standardList = new ArrayList<Standard>();
		for (Integer standardId : standardIdList) {
			Standard standard = standardRepository.findById(standardId).get();
			standardList.add(standard);
		}
		exam.setStandard(standardList);
		return examRepository.save(exam);
	}

	@Override
	public Exam deleteExamById(int id) {
		
		Exam exam=examRepository.findById(id).get();
		
		examRepository.deleteById(id);
		
		return exam;
	}

	@Override
	public Exam updateExam(Exam exam,List<Integer> standardIdList) {
		List<Standard> standardList = new ArrayList<Standard>();
		for (Integer standardId : standardIdList) {
			Standard standard = standardRepository.findById(standardId).get();
			standardList.add(standard);
		}
		exam.setStandard(standardList);
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

	@Override
	public Exam getExamByDate(LocalDate date) {
		return examRepository.findByExamDate(date);
	}

	
}
