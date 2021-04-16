package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.ConcernType;
import com.cg.spc.entities.Parent;
import com.cg.spc.exceptions.ParentNotFoundException;
import com.cg.spc.repositories.IConcernRepository;
import com.cg.spc.repositories.IParentRepository;
import com.cg.spc.services.IConcernService;

@SpringBootTest
public class ConcernServiceTest {

	@Autowired
	private IConcernService concernService;

	@MockBean
	private IConcernRepository concernRepository;
	
	@MockBean
	private IParentRepository parentRepository;

	Concern concern;

	Parent parent;
	
	@BeforeEach
	public void init() {
		concern = new Concern();
		concern.setConcern("child getting low marks");
		concern.setConcernType(ConcernType.ACADEMIC);
		parent = new Parent();
		parent.setId(500);
		concern.setParent(parent);
	}

	@Test
	@DisplayName("positive test case for add concern")
	public void testAddConcern() {
		Mockito.when(parentRepository.findById(500)).thenReturn(Optional.of(parent));
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.addConcern(concern, 500));
	}

	@Test
	@DisplayName("negative test case for add concern")
	public void testAddConcernNegative() {
		Mockito.when(parentRepository.findById(500)).thenReturn(Optional.of(parent));
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		Assertions.assertThrows(ParentNotFoundException.class, ()->concernService.updateConcern(concern, 501));
	}
	
	@Test
	@DisplayName("positive test case for update concern")
	public void testUpdateConcern() {
		Mockito.when(parentRepository.findById(500)).thenReturn(Optional.of(parent));
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.updateConcern(concern, 500));
	}

	@Test
	@DisplayName("negative test case for update concern")
	public void testUpdateConcernNegative() {
		Mockito.when(parentRepository.findById(500)).thenReturn(Optional.of(parent));
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		Assertions.assertThrows(ParentNotFoundException.class, ()->concernService.updateConcern(concern, 501));
	}
}