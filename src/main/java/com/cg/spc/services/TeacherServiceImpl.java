package com.cg.spc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Teacher;
import com.cg.spc.exceptions.StandardNotFoundException;
import com.cg.spc.exceptions.TeacherNotFoundException;
import com.cg.spc.repositories.IStandardRepository;
import com.cg.spc.repositories.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	private ITeacherRepository teacherRepository;
	
	@Autowired
	private IStandardRepository standardRepository;
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException());
	}

	@Override
	public Teacher deleteTeacherById(int id) {
		Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException());
		teacherRepository.deleteById(id);
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher,List<Integer> standardIdList,int standardId) {
		List<Standard> standardList = new ArrayList<Standard>();
		for (Integer id : standardIdList) {
			Standard standard = standardRepository.findById(id).orElseThrow(() -> new StandardNotFoundException());
			standardList.add(standard);
		}
		teacher.setStandardList(standardList);
		Standard standard = standardRepository.findById(standardId).orElseThrow(() -> new StandardNotFoundException());
		teacher.setStandard(standard);
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

}
