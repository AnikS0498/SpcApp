package com.cg.spc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Parent;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.ParentNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IParentRepository;
import com.cg.spc.repositories.IStudentRepository;


@Service
public class ParentServiceImpl implements IParentService{
	
	@Autowired
	private IParentRepository parentRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	
	@Override
	public List<Parent> getAllParent() {
		return parentRepository.findAll();
	}

	@Override
	public Parent getParentById(int id) {
		return parentRepository.findById(id).orElseThrow(() -> new ParentNotFoundException());
	}

	@Override
	public Parent addParentDetails(Parent parent) {
		return parentRepository.save(parent);
	}

	@Override
	public Parent deleteParentDetails(int id) {
		Parent parent = parentRepository.findById(id).orElseThrow(() -> new ParentNotFoundException());
		parentRepository.deleteById(id);
		return parent;
	}

	
	@Override
	public int updateParentDetails(Parent parent,List<Integer> studentIdList)
	{
		List<Student> studentList = new ArrayList<Student>();
		for (Integer studentId : studentIdList) {
			Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
			student.setParent(parent);
			studentList.add(student);
		}
		Parent pt = parentRepository.save(parent);
		return pt.getId();
	}

}
