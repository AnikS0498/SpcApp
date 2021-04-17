package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Diary;
import com.cg.spc.entities.Student;
import com.cg.spc.exceptions.DiaryNotFoundException;
import com.cg.spc.exceptions.StudentNotFoundException;
import com.cg.spc.repositories.IDiaryRepository;
import com.cg.spc.repositories.IStudentRepository;
import com.cg.spc.services.IDiaryService;

@SpringBootTest
public class DiaryServiceTest {

	@Autowired
	private IDiaryService diaryService;
	
	
	@MockBean
	private IDiaryRepository diaryRepository;
	
	@MockBean
	private IStudentRepository studentRepository;
	
	Diary diary;
	Diary diary2;
	
	Student student;
	Student student2;
	
	@BeforeEach
	public void init() {
		diary = new Diary();
		diary.setId(200);
		diary.setGeneratedDate(LocalDate.of(2021, 03, 04));
		diary.setRemark("Good Student");
		student = new Student();
		student.setId(9);
		student.setName("Sparsh");
		student.setDiary(diary);
		diary.setStudent(student);
		
		diary2 = new Diary();
		diary2.setId(210);
		diary2.setGeneratedDate(LocalDate.of(2021, 04, 06));
		diary2.setRemark("Excellent Student");
		student2 = new Student();
		student2.setId(10);
		student2.setName("Sky");
		student2.setDiary(diary);
		diary2.setStudent(student);
		
	}
	
	@Test
	@DisplayName("Positive test case for add diary")
	public void testAddDiary() {	
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		assertEquals(diary, diaryService.addDiary(diary, 9));
	}
	
	@Test
	@DisplayName("Negative test case for add diary")
	public void testAddDiaryNegative() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		Assertions.assertThrows(StudentNotFoundException.class,()-> diaryService.addDiary(diary, 19));
		
	}	
		
	@Test
	@DisplayName("Positive test case for update diary")
	public void testUpdateDiary() {		
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		assertEquals(diary,diaryService.updateDiary(diary, 9));
	}
	
	@Test
	@DisplayName("Negative test case for update diary")
	public void testUpdateDiaryNegative() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		Assertions.assertThrows(StudentNotFoundException.class,()-> diaryService.updateDiary(diary, 19));
	}
	
	@Test
	@DisplayName("positive test case for get diary by id")
	public void testGetDiaryById() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.findById(diary.getId())).thenReturn(Optional.of(diary));
		assertEquals(diary, diaryService.getDiaryById(200));
				
	}
	
	@Test
	@DisplayName("negative test case for get diary by id")
	public void testGetDiaryByIdNegative() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.findById(diary.getId())).thenReturn(Optional.of(diary));
		Assertions.assertThrows(DiaryNotFoundException.class,() ->diaryService.getDiaryById(201));
				
	}
	
	@Test
	@DisplayName("positive test case for get all diary")
	public void testGetAllDiary() {
		
		List<Diary> diaryList = new ArrayList<Diary>();
		
		diaryList.add(diary);
		diaryList.add(diary2);
		
		Mockito.when(diaryRepository.findAll()).thenReturn(diaryList);
		assertEquals(diaryList.size(), 2);
		
	}
	
	@Test
	@DisplayName("negative test case for get all diary")
	public void testGetAllDiaryNegative() {
		
		List<Diary> diaryList = new ArrayList<Diary>();
		
		diaryList.add(diary);
		diaryList.add(diary2);
		
		Mockito.when(diaryRepository.findAll()).thenReturn(diaryList);
		assertNotEquals(diaryList.size(), 3);
		
	}
	
	@Test
	@DisplayName("positive test case for get diary by student")
	public void testGetDiaryByStudent() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.findByStudentId(9)).thenReturn(diary);
		assertEquals(diary,diaryService.getDiaryByStudentId(9));
	
	}
	
	@Test
	@DisplayName("negative test case for get diary by student")
	public void testGetDiaryByStudentNegative() {
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
		Mockito.when(diaryRepository.findByStudentId(9)).thenReturn(diary);
		Assertions.assertThrows(StudentNotFoundException.class,() ->diaryService.getDiaryByStudentId(12));
	
	}
	
	@Test
	@DisplayName("positive test case for delete details by id")
	public void testDeleteDetailsById() {
		
		Mockito.when(diaryRepository.findById(diary.getId())).thenReturn(Optional.of(diary));
		diaryService.deleteDiaryById(200);
		Mockito.verify(diaryRepository, Mockito.times(1)).deleteById(200);
	}
	
	@Test
	@DisplayName("negative test case for delete details by id")
	public void testDeleteDetailsByIdNegative() {
		
		Mockito.when(diaryRepository.findById(diary.getId())).thenReturn(Optional.of(diary));
		Assertions.assertThrows(DiaryNotFoundException.class, () -> diaryService.deleteDiaryById(201));
		
	}
	
}
