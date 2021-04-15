package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
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
	
	ReportCard reportCard;
	
	ReportCard reportCard2;
	
	@BeforeEach
	public void init() {
		reportCard = new ReportCard();
		Map<Subject, Integer> marksheet = new HashMap<Subject, Integer>();
		marksheet.put(Subject.ENGLISH,78);
		marksheet.put(Subject.HINDI,98);
		marksheet.put(Subject.MATHS,89);
		marksheet.put(Subject.SOCIAL_STUDIES,78);
		marksheet.put(Subject.SCIENCE,78);
		marksheet.put(Subject.HISTORY_CIVICS,56);
		marksheet.put(Subject.GEOGRAPHY,65);
		Student student = new Student();
		student.setId(8);
		reportCard.setMarksheet(marksheet);
		reportCard.setStudent(student);
		
		reportCard2 = new ReportCard();
		Map<Subject, Integer> marksheet2 = new HashMap<Subject, Integer>();
		marksheet.put(Subject.ENGLISH,77);
		marksheet.put(Subject.HINDI,95);
		marksheet.put(Subject.MATHS,84);
		marksheet.put(Subject.SOCIAL_STUDIES,74);
		marksheet.put(Subject.SCIENCE,72);
		marksheet.put(Subject.HISTORY_CIVICS,64);
		marksheet.put(Subject.GEOGRAPHY,68);
		Student student2 = new Student();
		student2.setId(9);
		reportCard2.setMarksheet(marksheet2);
		reportCard2.setStudent(student2);
		}
	
	@Test
	@DisplayName("positive test case for add details")
	public void testAddDetails()
	{
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		assertEquals(reportCard, reportCardService.addDetails(reportCard, 8));
	}
	
	@Test
	@DisplayName("Negative test case for add details")
	public void testAddDetailsNegative()
	{
		Mockito.when(reportCardRepository.save(reportCard2)).thenReturn(reportCard2);
		assertNotEquals(reportCard2, reportCardService.addDetails(reportCard, 8));
	}
	
	@Test
	@DisplayName("positive test case for update details")
	public void testUpdateDetails()
	{
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		assertEquals(reportCard,reportCardService.updateDetails(reportCard, 8));
	}
	
	@Test
	@DisplayName("Negative test case for add details")
	public void testUpdateDetailsNegative()
	{
		Mockito.when(reportCardRepository.save(reportCard2)).thenReturn(reportCard2);
		assertNotEquals(reportCard2, reportCardService.updateDetails(reportCard, 8));
	}
	
}
