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

/**
 * 
 * 
 * Implementation class for TeacherService
 *
 */

@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	private ITeacherRepository teacherRepository;
	
	@Autowired
	private IStandardRepository standardRepository;
	

	/**
	 * 
	 * @return teacher
	 * 
	 * 	- all the teacher details will be retrieved.
	 */
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}


	/**
	 * @param id
	 * 
	 * @return teacher
	 * 
	 * 	- if teacher id is matched then the teacher details will be retrieved.
	 */
	@Override
	public Teacher getTeacherById(int id) {
		return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException());
	}


	/**
	 * @param id
	 * 
	 * @return teacher
	 * 
	 * 	- if teacher id is matched then the teacher details will be deleted.
	 */
	@Override
	public Teacher deleteTeacherById(int id) {
		Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException());
		teacherRepository.deleteById(id);
		return teacher;
	}


	/**
	 * @param teacher, standardList, standardId
	 * 
	 * @return teacher
	 * 
	 * 	- if standard id is valid then the teacher detail is updated.  
	 */
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
