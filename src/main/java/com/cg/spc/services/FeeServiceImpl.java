package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IFeeRepository;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class FeeServiceImpl implements IFeeService{

	@Autowired
	private IFeeRepository feeRepository;
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@Override
	public Fee getFeeById(int id) {
		return feeRepository.findById(id).get();
	}

	@Override
	public Fee updateFeeDetails(Fee fee, int studentId) {
		Student student = studentRepo.findById(studentId).get();
		fee.setStudent(student);
		student.setFee(fee);
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
	public Fee addFeeDetails(Fee fee, int studentId) {
		Student student = studentRepo.findById(studentId).get();
		fee.setStudent(student);
		student.setFee(fee);
		return feeRepository.save(fee);
	}

	@Override
	public Fee getFeeByStudentId(int id) {
		return feeRepository.findByStudentId(id);
	}

}
