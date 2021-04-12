package com.cg.spc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Concern;

public interface IConcernRepository extends JpaRepository<Concern, Integer>{
	//public List<Concern> findByResolved(boolean resolved);
	
}
