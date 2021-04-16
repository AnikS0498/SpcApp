package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Exam;
import com.cg.spc.entities.Standard;
import com.cg.spc.entities.Subject;
import com.cg.spc.repositories.IExamRepository;
import com.cg.spc.repositories.IStandardRepository;
import com.cg.spc.services.IExamService;


public class ExamServiceTest {

	@Autowired
	private IExamService examService;
	
	@MockBean
	private IExamRepository examRepository;
	
	@MockBean
	private IStandardRepository standardRepository;

	@Test
	@DisplayName("positive test case for get exam by Id")
	public void testExamById()
	{
		Exam exam=new Exam();
		exam.setId(500);
		exam.setDuration("3 Hours");
		Mockito.when(examRepository.findById(500)).thenReturn(Optional.of(exam));
		assertEquals(exam, examService.getExamById(500));
	}
	
	@Test
	@DisplayName("negative test case for get exam by Id")
	public void testExamByIdNegative()
	{
		Exam exam=new Exam();
		exam.setId(501);
		exam.setDuration("3 Hours");
		Mockito.when(examRepository.findById(501)).thenReturn(Optional.of(exam));
		assertNotEquals(exam, examService.getExamById(509));
	}
	
	@Test
	@DisplayName("positive test case for get exam by date")
	public void testGetExamByDate()
	{
		Exam exam=new Exam();
		exam.setId(501);
		exam.setExamDate(LocalDate.of(2021, 04, 01));
		Mockito.when(examRepository.findByExamDate(LocalDate.of(2021, 04, 01))).thenReturn(exam);
		assertEquals(exam,examService.getExamByDate(LocalDate.of(2021, 04, 01)));
	}
	
	@Test
	@DisplayName("negative test case for get exam by date")
	public void testGetExamByDateNegative()
	{
		Exam exam=new Exam();
		exam.setId(501);
		exam.setExamDate(LocalDate.of(2021, 04, 01));
		Mockito.when(examRepository.findByExamDate(LocalDate.of(2021, 04, 01))).thenReturn(exam);
		assertNotEquals(exam,examService.getExamByDate(LocalDate.of(2021, 06, 01)));
	}
	
	@Test
	@DisplayName("positive test case of get all exam details")
	public void testGetAllExamDetails()
	{
		Exam exam = new Exam();
		exam.setId(501);
		exam.setDuration("3 Hours");
		exam.setExamDate(LocalDate.of(2021, 04, 01));
		
		Exam exam1 = new Exam();
		exam1.setId(503);
		exam1.setDuration("2 Hours");
		exam1.setExamDate(LocalDate.of(2021, 06, 01));
		
		List<Exam> examList = new ArrayList<Exam>();
		examList.add(exam1);
		examList.add(exam);
		
		Mockito.when(examRepository.findAll()).thenReturn(examList);
		assertEquals(examList,examService.getAllExamDetails());
	}
	
	@Test
	@DisplayName("negative test case of get all exam details")
	public void testGetAllExamDetailsNegative()
	{
		Exam exam = new Exam();
		exam.setId(501);
		exam.setDuration("3 Hours");
		exam.setExamDate(LocalDate.of(2021, 04, 01));
		
		Exam exam1 = new Exam();
		exam1.setId(503);
		exam1.setDuration("2 Hours");
		exam1.setExamDate(LocalDate.of(2021, 06, 01));
		
		List<Exam> examList = new ArrayList<Exam>();
		examList.add(exam1);
		examList.add(exam);
		
		List<Exam> examList1 = new ArrayList<Exam>();
		examList.add(exam);
		examList.add(exam1);
		
		Mockito.when(examRepository.findAll()).thenReturn(examList);
		assertNotEquals(examList1,examService.getAllExamDetails());
	}
	
	@Test
	@DisplayName("positive test case for add exam")
	public void testAddExam()
	{
		Exam exam = new Exam();
			exam.setDuration("3 hours");
			exam.setExamDate(LocalDate.of(2021, 04, 01));
			exam.setId(100);
			exam.setMarks(100);
			exam.setSubject(Subject.HINDI);
			
		Standard standard = new Standard();
			standard.setClassStrength(80);
			standard.setGrade("III");
			standard.setId(500);

		Standard standard2 = new Standard();
			standard2.setClassStrength(60);
			standard2.setGrade("II");
			standard2.setId(501);
			
		List<Integer> intList = new ArrayList<Integer>();
			intList.add(500);
			intList.add(501);
			
		List<Standard> standardList = new ArrayList<Standard>();
			standardList.add(standard);
			standardList.add(standard2);

		exam.setStandard(standardList);
		
		//Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(examRepository.save(exam)).thenReturn(exam);
		
		assertEquals(exam, examService.addExam(exam, intList));
	}
	
	@Test
	@DisplayName("negative test case for add exam")
	public void testAddExamNegative()
	{
		Exam exam = new Exam();
			exam.setDuration("3 hours");
			exam.setExamDate(LocalDate.of(2021, 04, 01));
			exam.setId(100);
			exam.setMarks(100);
			exam.setSubject(Subject.HINDI);
			
		Standard standard = new Standard();
			standard.setClassStrength(80);
			standard.setGrade("III");
			standard.setId(500);

		Standard standard2 = new Standard();
			standard2.setClassStrength(60);
			standard2.setGrade("II");
			standard2.setId(501);
			
		List<Integer> intList = new ArrayList<Integer>();
			intList.add(509);
			intList.add(510);
			
		List<Standard> standardList = new ArrayList<Standard>();
			standardList.add(standard);
			standardList.add(standard2);

		exam.setStandard(standardList);
		
		//Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(examRepository.save(exam)).thenReturn(exam);
		
		assertNotEquals(exam, examService.addExam(exam, intList));
	}
	
	@Test
	@DisplayName("positive test case for add exam")
	public void testUpdateExam()
	{
		Exam exam = new Exam();
			exam.setDuration("3 hours");
			exam.setExamDate(LocalDate.of(2021, 04, 01));
			exam.setId(100);
			exam.setMarks(100);
			exam.setSubject(Subject.HINDI);
			
		Standard standard = new Standard();
			standard.setClassStrength(80);
			standard.setGrade("III");
			standard.setId(500);

		Standard standard2 = new Standard();
			standard2.setClassStrength(60);
			standard2.setGrade("II");
			standard2.setId(501);
			
		List<Integer> intList = new ArrayList<Integer>();
			intList.add(500);
			intList.add(501);
			
		List<Standard> standardList = new ArrayList<Standard>();
			standardList.add(standard);
			standardList.add(standard2);

		exam.setStandard(standardList);
		
		//Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(examRepository.save(exam)).thenReturn(exam);
		
		assertEquals(exam, examService.addExam(exam, intList));
	}
	
	@Test
	@DisplayName("negative test case for add exam")
	public void testUpdateExamNegative()
	{
		Exam exam = new Exam();
			exam.setDuration("3 hours");
			exam.setExamDate(LocalDate.of(2021, 04, 01));
			exam.setId(100);
			exam.setMarks(100);
			exam.setSubject(Subject.HINDI);
			
		Standard standard = new Standard();
			standard.setClassStrength(80);
			standard.setGrade("III");
			standard.setId(500);

		Standard standard2 = new Standard();
			standard2.setClassStrength(60);
			standard2.setGrade("II");
			standard2.setId(501);
			
		List<Integer> intList = new ArrayList<Integer>();
			intList.add(509);
			intList.add(510);
			
		List<Standard> standardList = new ArrayList<Standard>();
			standardList.add(standard);
			standardList.add(standard2);

		exam.setStandard(standardList);
		
		//Mockito.when(standardRepository.findById(standard.getId())).thenReturn(Optional.of(standard));
		Mockito.when(examRepository.save(exam)).thenReturn(exam);
		
		assertNotEquals(exam, examService.addExam(exam, intList));
	}
	
	
}
