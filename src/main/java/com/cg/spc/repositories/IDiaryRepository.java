package com.cg.spc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Diary;

public interface IDiaryRepository extends JpaRepository<Diary, Integer> {
	

}
