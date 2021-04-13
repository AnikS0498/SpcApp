package com.cg.spc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Teacher;
import com.cg.spc.repositories.IStandardRepository;
import com.cg.spc.repositories.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	private ITeacherRepository teacherRepository;
	
	@Autowired
	private IStandardRepository standardRepository;
	
	@Override
	public List<String> getAllTeachers() {
		//return teacherRepository.findAll();
		return teacherRepository.findAllTeacher();
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public Teacher deleteTeacherById(int id) {
		Teacher teacher = teacherRepository.findById(id).get();
		teacherRepository.deleteById(id);
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher,List<Integer> standardIdList,int standardId) {
		List<Standard> standardList = new ArrayList<Standard>();
		for (Integer id : standardIdList) {
			Standard standard = standardRepository.findById(id).get();
			standardList.add(standard);
		}
		teacher.setStandardList(standardList);
		Standard standard = standardRepository.findById(standardId).get();
		teacher.setStandard(standard);
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

}
