package com.cg.spc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Exam;
import com.cg.spc.entities.Standard;
import com.cg.spc.exceptions.DateNotFoundException;
import com.cg.spc.exceptions.ExamNotFoundException;
import com.cg.spc.exceptions.StandardNotFoundException;
import com.cg.spc.repositories.IExamRepository;
import com.cg.spc.repositories.IStandardRepository;

/**
 * 
 * 
 * Implementation class for ExamService
 *
 */
@Service
public class ExamServiceImpl implements IExamService {

	@Autowired
	private IExamRepository examRepository;
	
	@Autowired
	private IStandardRepository standardRepository;
	 
	/**
	 * @param exam, standardIdList
	 * 
	 * @return exam
	 * 
	 * 	- Exam details will be added besed on the standardId.
	 */
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

	/**
	 * @param id
	 * 
	 * @return diary
	 * 
	 * 	- if the exam id matches then Exam details will be deleted.
	 */
	@Override
	public Exam deleteExamById(int id) {
		Exam exam=examRepository.findById(id).orElseThrow(() -> new ExamNotFoundException());
		examRepository.deleteById(id);
		return exam;
	}
	
	
	/**
	 * @param exam, standardIdList
	 * 
	 * @return exam
	 * 
	 * 	- Exam details will be updated based on the standardId.
	 * 
	 */
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

	/**
	 * @param id
	 * 
	 * @return exam
	 * 
	 * 	- if the exam id matches then Exam details will be retrieved.
	 * 
	 */
	@Override
	public Exam getExamById(int id) {
		Exam exam = examRepository.findById(id).orElseThrow(() -> new ExamNotFoundException());
		return exam;
	}

	/**
	 * @param id
	 * 
	 * @return exam
	 * 
	 * 	- if the exam id matches then Exam details will be retrieved.
	 * 
	 */
	@Override
	public List<Exam> getAllExamDetails() {
		return examRepository.findAll();
	}
	
	/**
	 * @param examdate
	 * 
	 * @return exam
	 * 
	 * 	- if the exam date matches then Exam details will be retrieved.
	 * 
	 */
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
