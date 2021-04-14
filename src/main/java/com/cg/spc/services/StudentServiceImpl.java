package com.cg.spc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.StudentNotFoundException;
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
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
	}

	@Override
	public Student deleteStudentById(int id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
		studentRepository.deleteById(id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		int studentId = student.getId();
		@SuppressWarnings("unused")
		Student studentObj = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		Student st = studentRepository.save(student);
		return st.getId();
	}

	@Override
	public Student addStudent(Student student) {
		int studentId = student.getId();
		@SuppressWarnings("unused")
		Student studentObj = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		return studentRepository.save(student);
	}

}
