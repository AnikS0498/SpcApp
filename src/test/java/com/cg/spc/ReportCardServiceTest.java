package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.ReportCard;
import com.cg.spc.entities.Student;
import com.cg.spc.entities.Subject;
import com.cg.spc.repositories.IReportCardRepository;
import com.cg.spc.services.IReportCardService;

@SpringBootTest
public class ReportCardServiceTest {

	@Autowired
	private IReportCardService reportCardService;
	
	@MockBean
	private IReportCardRepository reportCardRepository;
	
//	@Autowired
//	private IReportCardService reportCardService;
	
	@Test
	@DisplayName("positive test case for add details")
	public void testAddDetails()
	{
		ReportCard reportCard = new ReportCard();
		Map marksheet = new HashMap<Subject, Integer>();
		marksheet.put(Subject.ENGLISH,78);
		marksheet.put(Subject.HINDI,98);
		marksheet.put(Subject.MATHS,89);
		marksheet.put(Subject.SOCIAL_STUDIES,78);
		marksheet.put(Subject.SCIENCE,78);
		marksheet.put(Subject.HISTORY_CIVICS,56);
		marksheet.put(Subject.GEOGRAPHY,65);
		Student student = new Student();
		student.setId(36);
		reportCard.setMarksheet(marksheet);
		reportCard.setStudent(student);
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		assertEquals(reportCard, reportCardService.addDetails(reportCard, 36));
		
	}
	
}
