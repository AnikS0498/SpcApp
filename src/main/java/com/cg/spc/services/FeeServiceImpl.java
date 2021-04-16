package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.FeeNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IFeeRepository;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class FeeServiceImpl implements IFeeService{

	@Autowired
	private IFeeRepository feeRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public Fee getFeeById(int id) {
		return feeRepository.findById(id).orElseThrow(() -> new FeeNotFoundException());
	}

	@Override
	public Fee updateFeeDetails(Fee fee, int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		fee.setStudent(student);
		student.setFee(fee);
		return feeRepository.save(fee);
	}

	@Override
	public Fee deleteFeeDetails(int id) {
		Fee fee = feeRepository.findById(id).orElseThrow(() -> new FeeNotFoundException());
		feeRepository.deleteById(id);
		return fee;
	}

	@Override
	public List<Fee> getAllFee() {
		return feeRepository.findAll();
	}

	@Override
	public Fee addFeeDetails(Fee fee, int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		fee.setStudent(student);
		student.setFee(fee);
		return feeRepository.save(fee);
	}

//	@Override
//	public Fee getFeeByStudentId(int id) {
//		@SuppressWarnings("unused")
//		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
//		return feeRepository.findByStudentId(id);
//	}

	@Override
    public Fee getFeeByStudentId(int id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
//        int flag = 0;
//        List<Fee> feeList = new ArrayList<Fee>();
//        feeList = getAllFee();
//        for(Fee fee: feeList) {
//            if(fee.getStudent().equals(student)) {
//            	flag = 1;
//            	break;
//            }
//        }
//        if(flag==0)
//        	throw new FeeNotFoundException();
		if(student.getFee() == null) {
			throw new FeeNotFoundException();
		}
        return feeRepository.findByStudentId(id);
    }
}