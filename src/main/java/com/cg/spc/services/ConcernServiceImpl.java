package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Concern;
import com.cg.spc.repositories.IConcernRepository;

@Service
public class ConcernServiceImpl implements IConcernService{

	@Autowired
	private IConcernRepository concernRepository;
	
	@Override
	public Concern addConcern(Concern concern) {
		return concernRepository.save(concern);
	}

	@Override
	public Concern updateConcern(Concern concern) {
		return concernRepository.save(concern);
	}

	@Override
	public List<Concern> getAllConcerns() {
		return concernRepository.findAll();
	}

	@Override
	public Concern deleteById(int id) {
		Concern concern = concernRepository.findById(id).get();
		concernRepository.deleteById(id);
		return concern;
	}

}
