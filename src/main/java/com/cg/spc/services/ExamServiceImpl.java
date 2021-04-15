package com.cg.spc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Exam;
import com.cg.spc.entities.Standard;
import com.cg.spc.exceptions.DateNotFoundException;
import com.cg.spc.exceptions.StandardNotFoundException;
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
			Standard standard = standardRepository.findById(standardId).orElseThrow(() -> new StandardNotFoundException());
			standard.setExamList(getAllExamDetails());
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
			Standard standard = standardRepository.findById(standardId).orElseThrow(() -> new StandardNotFoundException());
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
        String examDate = date.toString();
        int flag = 0;
        List<Exam> examList = new ArrayList<Exam>();
        examList = getAllExamDetails();
        for(Exam exam: examList) {
            String examString = exam.getExamDate().toString();
            if(examString.equals(examDate)) {
                flag = 1;
                break;
            }
        }
        if(flag==0)
            throw new DateNotFoundException();
        return examRepository.findByExamDate(date);
    }
}
