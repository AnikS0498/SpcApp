package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.ConcernType;
import com.cg.spc.entities.Parent;
import com.cg.spc.repositories.IConcernRepository;
import com.cg.spc.repositories.IParentRepository;
import com.cg.spc.services.IConcernService;

@SpringBootTest
public class ConcernServiceTest {

	@Autowired
	private IConcernService concernService;
	
	//@Autowired
	//private Parent parent;

	@MockBean
	private IConcernRepository concernRepository;
	
	@MockBean
	private IParentRepository parentRepository;


	@Test
	@DisplayName("positive test case for add concern")
	public void testAddConcern() {
		Concern concern = new Concern();
		concern.setConcern("child getting low marks");
		Parent parent = parentRepository.findById(21).get();
		concern.setParent(parent);
		concern.setConcernType(ConcernType.ACADEMIC);
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.addConcern(concern, 21));
	}

	@Test
	@DisplayName("negative test case for add concern")
	public void testAddConcernNegative() {
		Concern concern = new Concern();
		concern.setConcern("child getting low marks");
		Parent parent = parentRepository.findById(21).get();
		concern.setParent(parent);
		concern.setConcernType(ConcernType.ACADEMIC);
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertNotEquals("xyzzzzzzzzz", concernService.addConcern(concern, 21));
	}
}