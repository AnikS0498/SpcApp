package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;
import com.cg.spc.exceptions.ConcernResolvedException;
import com.cg.spc.exceptions.ParentNotFoundException;
import com.cg.spc.repositories.IConcernRepository;
import com.cg.spc.repositories.IParentRepository;

/**
 * 
 * 
 * Implementation class for ConcernService
 *
 */

@Service
public class ConcernServiceImpl implements IConcernService {

	@Autowired
	private IConcernRepository concernRepository;

	@Autowired
	private IParentRepository parentRepository;

	
	/**
	 * @param concern, id
	 * 
	 * @return concern
	 * 
	 * 	- if the parentId matches then concern will be updated
	 * 
	 */
	@Override
	public Concern updateConcern(Concern concern, int parentId) {
		if (!concern.isResolved()) {
			Parent parent = parentRepository.findById(parentId).orElseThrow(() -> new ParentNotFoundException());
			concern.setParent(parent);
			concern.setResolved(true);
			return concernRepository.save(concern);
		} else {
			return null;
		}
	}

	/**
	 * @return concern
	 * 
	 * 	- getting all the concerns
	 */
	@Override
	public List<Concern> getAllConcerns() {
		return concernRepository.findAll();
	}

	/**
	 * @param id
	 * 
	 * @return concern
	 * 
	 * 	- if the id matches then concern will be deleted
	 * 
	 */
	@Override
	public Concern deleteById(int id) {
		Concern concern = concernRepository.findById(id).orElseThrow(() -> new ConcernResolvedException());
		concernRepository.deleteById(id);
		return concern;
	}

	/**
	 * @param concern, id
	 * 
	 * @return concern
	 * 
	 * 	- if the parentId matches then concern will be added
	 * 
	 */
	@Override
	public Concern addConcern(Concern concern, int parentId) {
		Parent parent = parentRepository.findById(parentId).orElseThrow(() -> new ParentNotFoundException());
		concern.setParent(parent);
		return concernRepository.save(concern);
	}

}
