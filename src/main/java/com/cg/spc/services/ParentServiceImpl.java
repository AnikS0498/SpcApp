package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Parent;
import com.cg.spc.repositories.IParentRepository;


@Service
public class ParentServiceImpl implements IParentService{
	
	@Autowired
	private IParentRepository parentRepository;
	
	
	@Override
	public List<Parent> getAllParent() {
		return parentRepository.findAll();
	}

	@Override
	public Parent getParentById(int id) {
		return parentRepository.findById(id).get();
	}

	@Override
	public Parent addParentDetails(Parent parent) {
		return parentRepository.save(parent);
	}

	@Override
	public Parent deleteParentDetails(int id) {
		Parent parent = parentRepository.findById(id).get();
		parentRepository.deleteById(id);
		return parent;
	}

	
	@Override
	public Parent updateParentDetails(Parent parent)
	{
		return parentRepository.save(parent);
	}

}
