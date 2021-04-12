package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Teacher;
import com.cg.spc.repositories.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	private ITeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
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
	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

}
