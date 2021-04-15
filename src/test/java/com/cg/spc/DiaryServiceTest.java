package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Diary;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IDiaryRepository;
import com.cg.spc.services.IDiaryService;

@SpringBootTest
public class DiaryServiceTest {

	@Autowired
	private IDiaryService diaryService;
	
	@MockBean
	private IDiaryRepository diaryRepository;
	
	Diary diary;
	Diary diary2;
	
	@BeforeEach
	public void init() {
		diary = new Diary();
		diary.setGeneratedDate(LocalDate.of(2021, 03, 04));
		diary.setRemark("Good Student");
		Student student = new Student();
		student.setId(9);
		diary.setStudent(student);
		
		diary2 = new Diary();
		diary2.setGeneratedDate(LocalDate.of(2021, 03, 12));
		diary2.setRemark("Great Academic Performance");
		Student student2 = new Student();
		student2.setId(12);
		diary2.setStudent(student2);
	}
	
	@Test
	@DisplayName("Positive test case for add diary")
	public void testAddDiary() {		
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		assertEquals(diary, diaryService.addDiary(diary, 9));
	}
	
	@Test
	@DisplayName("Negative test case for add diary")
	public void testAddDiaryNegative() {
		Mockito.when(diaryRepository.save(diary2)).thenReturn(diary2);
		assertNotEquals(diary2, diaryService.addDiary(diary, 9));
	}	
		
	@Test
	@DisplayName("Positive test case for update diary")
	public void testUpdateDiary() {		
		Mockito.when(diaryRepository.save(diary)).thenReturn(diary);
		assertEquals(diary,diaryService.updateDiary(diary, 12));
	}
	
	@Test
	@DisplayName("Negative test case for update diary")
	public void testUpdateDiaryNegative() {
		Mockito.when(diaryRepository.save(diary2)).thenReturn(diary2);
		assertNotEquals(diary2,diaryService.updateDiary(diary, 12));
	}
}
