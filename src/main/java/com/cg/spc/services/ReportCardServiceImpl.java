package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.ReportCard;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.ReportCardNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IReportCardRepository;
import com.cg.spc.repositories.IStudentRepository;

/**
 * 
 * 
 * Implementation class for ReportCardService
 *
 */

@Service
public class ReportCardServiceImpl  implements IReportCardService{

	@Autowired
	private IReportCardRepository reportCardRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	/**
	 * @param reportCard, studentId
	 * 
	 * @return reportCard
	 * 
	 * 	- if the  studentId matches then the reportCard details will be added.
	 */
	@Override
	public ReportCard addDetails(ReportCard reportCard,int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		reportCard.setStudent(student);
		return reportCardRepository.save(reportCard);
	}

	/**
	 * @param id
	 * 
	 * @return reportCard
	 * 
	 * 	- if the  reportCardId matches then the reportCard details will be retrieved.
	 */
	@Override
	public ReportCard getDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).orElseThrow(()-> new ReportCardNotFoundException());
		return reportCard;
	}

	/**
	 * @param reportCard, studentId
	 * 
	 * @return reportCard
	 * 
	 * 	- if the  studentId matches then the reportCard details will be updated.
	 */
	@Override
	public ReportCard updateDetails(ReportCard reportCard,int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		reportCard.setStudent(student);
		return reportCardRepository.save(reportCard);
	}
	
	/**
	 * @param id
	 * 
	 * @return reportCard
	 * 
	 * 	- if the  ReportCard id matches then the ReportCard details will be deleted.
	 */
	@Override
	public ReportCard deleteDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).orElseThrow(()-> new ReportCardNotFoundException());
		reportCardRepository.deleteById(id);
		return reportCard;
	}

	/**
	 * @param id
	 * 
	 * @return reportCard
	 * 
	 * 	- if the  Student id matches then the ReportCard details will be retrieved.
	 */
	@Override
    public ReportCard getReportCardByStudentId(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
        if(student.getReportCard()==null) {
            throw new ReportCardNotFoundException();
        }
        return reportCardRepository.findByStudentId(id);
    }
	
}
