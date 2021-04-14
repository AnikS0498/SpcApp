package com.cg.spc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student deleteStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.deleteById(id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		Student st=studentRepository.save(student);
		return st.getId();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

}
