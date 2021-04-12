package com.cg.spc.services;

import com.cg.spc.entities.Fee;

import java.util.List;

public interface IFeeService {

	public Fee getFeeById(int id);
	public Fee updateFeeDetails(Fee fee);
	public Fee deleteFeeDetails(int id);
	public List<Fee> getAllFee();
	public Fee addFeeDetails(Fee fee);
	
}
