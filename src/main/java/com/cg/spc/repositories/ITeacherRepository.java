package com.cg.spc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer>{
	
	@Query("select t.name from Teacher t")
	public List<String> findAllTeacher();
}
