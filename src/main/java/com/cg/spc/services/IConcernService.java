package com.cg.spc.services;

import java.util.List;

import com.cg.spc.entities.Concern;

public interface IConcernService {
	public Concern addConcern(Concern concern, int parentId);
	public Concern updateConcern(Concern concern);
	public List<Concern> getAllConcerns();
	public Concern deleteById(int id);
//	public List<Concern> getAllConcernsByParentId(int parentId);
//	public List<Concern> getAllUnResolvedConcerns(boolean resolved);
//	public List<Concern> getAllUnResolvedConcernsByParentId(int parentId);
}
