package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.spc.entities.Fee;
import com.cg.spc.repositories.IFeeRepository;

public class FeeServiceImpl implements IFeeService{

	@Autowired
	private IFeeRepository feeRepository;
	
	@Override
	public Fee getFeeById(int id) {
		return feeRepository.findById(id).get();
	}

	@Override
	public Fee updateFeeDetails(Fee fee) {
		return feeRepository.save(fee);
	}

	@Override
	public Fee deleteFeeDetails(int id) {
		Fee fee = feeRepository.findById(id).get();
		feeRepository.deleteById(id);
		return fee;
	}

	@Override
	public List<Fee> getAllFee() {
		return feeRepository.findAll();
	}

	@Override
	public Fee addFeeDetails(Fee fee) {
		return feeRepository.save(fee);
	}

}
