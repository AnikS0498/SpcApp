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


/**
 * 
 * 
 * Implementation class for FeeService
 *
 */

@Service
public class FeeServiceImpl implements IFeeService{

	@Autowired
	private IFeeRepository feeRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	/**
	 * @param id
	 * 
	 * @return fee
	 * 
	 * 	- if the fee id matches then fee details will be retrieved.
	 * 
	 */
	@Override
	public Fee getFeeById(int id) {
		return feeRepository.findById(id).orElseThrow(() -> new FeeNotFoundException());
	}

	/**
	 * @param id, studentId
	 * 
	 * @return fee
	 * 
	 * 	- if the studentId matches then fee details will be retrieved.
	 * 
	 */
	@Override
	public Fee updateFeeDetails(Fee fee, int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		fee.setStudent(student);
		student.setFee(fee);
		return feeRepository.save(fee);
	}

	/**
	 * @param id
	 * 
	 * @return fee
	 * 
	 * 	- if the fee id matches then fee details will be deleted.
	 * 
	 */
	@Override
	public Fee deleteFeeDetails(int id) {
		Fee fee = feeRepository.findById(id).orElseThrow(() -> new FeeNotFoundException());
		feeRepository.deleteById(id);
		return fee;
	}
	
	/**
	 * @return fee
	 * 
	 * 	- all fee details will be retrieved.
	 * 
	 */
	@Override
	public List<Fee> getAllFee() {
		return feeRepository.findAll();
	}
	
	
	/**
	 * @param fee, studentId
	 * 
	 * @return fee
	 * 
	 * 	- if the fee id matches then fee details will be retrieved.
	 */
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
	
	/**
	 * @param fee, studentId
	 * 
	 * @return fee
	 * 
	 * 	- if the fee id matches then fee details will be retrieved.
	 */
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