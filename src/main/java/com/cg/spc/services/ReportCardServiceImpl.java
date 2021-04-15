package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spc.entities.ReportCard;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.ReportCardNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IReportCardRepository;
import com.cg.spc.repositories.IStudentRepository;

@Service
public class ReportCardServiceImpl  implements IReportCardService{

	@Autowired
	private IReportCardRepository reportCardRepository;
	
	@Autowired
	private IStudentRepository studentRepository;
	
	
	@Override
	public ReportCard addDetails(ReportCard reportCard,int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		reportCard.setStudent(student);
		return reportCardRepository.save(reportCard);
	}

	@Override
	public ReportCard getDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).get();
		return reportCard;
	}

	@Override
	public ReportCard updateDetails(ReportCard reportCard,int studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
		reportCard.setStudent(student);
		return reportCardRepository.save(reportCard);
	}

	@Override
	public ReportCard deleteDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).get();
		reportCardRepository.deleteById(id);
		return reportCard;
	}

	@Override
    public ReportCard getReportCardByStudentId(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
        if(student.getReportCard()==null) {
            throw new ReportCardNotFoundException();
        }
        return reportCardRepository.findByStudentId(id);
    }
	
}
