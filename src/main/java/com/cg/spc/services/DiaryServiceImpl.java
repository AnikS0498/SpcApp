package com.cg.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Diary;
import com.cg.spc.repositories.IDiaryRepository;

@Service
public class DiaryServiceImpl implements IDiaryService{
	
	@Autowired
	private IDiaryRepository diaryRepository;

	@Override
	public Diary addDiary(Diary diary) {
	
		return diaryRepository.save(diary);
	}

	@Override
	public Diary updateDiary(Diary diary) {
		
		return diaryRepository.save(diary);
	}

	@Override
	public Diary getDiaryById(int id) {
		
		Diary diary = diaryRepository.findById(id).get();
		
		return diary;
	}

	@Override
	public Diary deleteDiaryById(int id) {
	
		Diary diary = diaryRepository.findById(id).get();
		
		diaryRepository.deleteById(id);
				
		return diary;
	}

	@Override
	public List<Diary> getAllDiaryDetails() {
	
		return diaryRepository.findAll();
	}

}
