package com.cg.spc.services;

import com.cg.spc.entities.ReportCard;

public interface IReportCard {
	
	public ReportCard addDetails(ReportCard reportCard);
	public ReportCard getDetailsById(int id);
	public ReportCard updateDetails(ReportCard reportCard);
	public ReportCard deleteDetailsById(int id);
}
