package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.spc.entities.Standard;
import com.cg.spc.repositories.IStandardRepository;

public class StandardServiceImpl implements IStandardService{

	@Autowired
	private IStandardRepository standardRepository;
	
	@Override
	public Standard addDetails(Standard standard) {
		return standardRepository.save(standard);
	}

	@Override
	public Standard getDetailsById(int id) {
		Standard standard = standardRepository.findById(id).get();
		return standard;
	}

	@Override
	public Standard updateDetails(Standard standard) {
		return standardRepository.save(standard);
	}

	@Override
	public Standard deleteDetailsById(int id) {
		Standard standard = standardRepository.findById(id).get();
		standardRepository.deleteById(id);
		return standard;
	}

}
