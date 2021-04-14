package com.cg.spc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Exam;
import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IExamRepository;
import com.cg.spc.repositories.IStandardRepository;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class StandardServiceImpl implements IStandardService{

	@Autowired
	private IStandardRepository standardRepository;
	
	@Autowired
	private IExamRepository examRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public Standard addDetails(Standard standard) {
		return standardRepository.save(standard);
	}

	@Override
	public Standard getDetailsById(int id) {
		Standard standard = standardRepository.findById(id).get();
		return standard;
	}

	@Override
	public Standard updateDetails(Standard standard,List<Integer> examIdList,List<Integer> studentIdList) {
		List<Exam> examList = new ArrayList<Exam>();
		for (Integer examId : examIdList) {
			Exam exam = examRepository.findById(examId).get();
			examList.add(exam);
		}
		List<Student> studentList = new ArrayList<Student>();
		for (Integer studentId : studentIdList) {
			Student student = studentRepository.findById(studentId).get();
			student.setStandard(standard);
			studentList.add(student);
		}
		standard.setStudentList(studentList);
		standard.setExamList(examList);
		return standardRepository.save(standard);
	}

	@Override
	public Standard deleteDetailsById(int id) {
		Standard standard = standardRepository.findById(id).get();
		standardRepository.deleteById(id);
		return standard;
	}

}
