package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
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
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IReportCardRepository;
import com.cg.spc.repositories.IStudentRepository;
import com.cg.spc.services.IReportCardService;

@SpringBootTest
public class ReportCardServiceTest {

	@Autowired
	private IReportCardService reportCardService;
	
	@MockBean
	private IReportCardRepository reportCardRepository;
	
	@MockBean
    private IStudentRepository studentRepository;  
	
	ReportCard reportCard;
	
	Student student;
	
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
		student = new Student();
		student.setId(300);;
		student.setName("Rahul");
		reportCard.setMarksheet(marksheet);
		reportCard.setStudent(student);
		}
	
	@Test
	@DisplayName("positive test case for add details")
	public void testAddDetails()
	{
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		assertEquals(reportCard, reportCardService.addDetails(reportCard, 300));
	}
	
	@Test
	@DisplayName("Negative test case for add details")
	public void testAddDetailsNegative()
	{
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		Assertions.assertThrows(StudentNotFoundException.class,()-> reportCardService.addDetails(reportCard, 19));
	}
	
	@Test
	@DisplayName("positive test case for update details")
	public void testUpdateDetails()
	{
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		assertEquals(reportCard,reportCardService.updateDetails(reportCard, 300));
	}
	
	@Test
	@DisplayName("Negative test case for update details")
	public void testUpdateDetailsNegative()
	{
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(reportCardRepository.save(reportCard)).thenReturn(reportCard);
		Assertions.assertThrows(StudentNotFoundException.class,()-> reportCardService.updateDetails(reportCard, 101));
	}
	
}
