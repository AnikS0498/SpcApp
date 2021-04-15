package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;
import com.cg.spc.exceptions.ParentNotFoundException;
import com.cg.spc.repositories.IConcernRepository;
import com.cg.spc.repositories.IParentRepository;

@Service
public class ConcernServiceImpl implements IConcernService {

	@Autowired
	private IConcernRepository concernRepository;

	@Autowired
	private IParentRepository parentRepository;

	@Override
	public Concern updateConcern(Concern concern, int parentId) {
		if (!concern.isResolved()) {
			Parent parent = parentRepository.findById(parentId).get();
			concern.setParent(parent);
			concern.setResolved(true);
			return concernRepository.save(concern);
		} else {
			return null;
		}
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

	@Override
	public Concern addConcern(Concern concern, int parentId) {
		Parent parent = parentRepository.findById(parentId).orElseThrow(() -> new ParentNotFoundException());
		concern.setParent(parent);
		return concernRepository.save(concern);
	}

}
