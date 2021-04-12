package com.cg.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ReportCard;
import com.cg.spc.repositories.IReportCardRepository;

@Service
public class ReportCardImpl  implements IReportCard{

	@Autowired
	private IReportCardRepository reportCardRepository;
	
	@Override
	public ReportCard addDetails(ReportCard reportCard) {
		return reportCardRepository.save(reportCard);
	}

	@Override
	public ReportCard getDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).get();
		return reportCard;
	}

	@Override
	public ReportCard updateDetails(ReportCard reportCard) {
		return reportCardRepository.save(reportCard);
	}

	@Override
	public ReportCard deleteDetailsById(int id) {
		ReportCard reportCard = reportCardRepository.findById(id).get();
		reportCardRepository.deleteById(id);
		return reportCard;
	}
	
}
