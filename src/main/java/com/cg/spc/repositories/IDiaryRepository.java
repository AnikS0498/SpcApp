package com.cg.spc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Diary;

public interface IDiaryRepository extends JpaRepository<Diary, Integer> {
	
	@Query("select e from Exam e where e.student = (select s from Student s where s.id = ?)")
	public Diary findByStudentId(int sId);
	
}
