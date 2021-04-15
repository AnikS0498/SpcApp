package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
import com.cg.spc.repositories.IConcernRepository;
import com.cg.spc.services.IConcernService;

@SpringBootTest
public class ConcernServiceTest {

	@Autowired
	private IConcernService concernService;

	@MockBean
	private IConcernRepository concernRepository;

	Concern concern;

	Concern concern2;

	@BeforeEach
	public void init() {
		concern = new Concern();
		concern.setConcern("child getting low marks");
		concern.setConcernType(ConcernType.ACADEMIC);
		;
		Parent parent = new Parent();
		parent.setId(1);
		concern.setParent(parent);

		concern2 = new Concern();
		concern2.setConcernType(ConcernType.FEES);
		concern2.setConcern("Fee details is not correct");
		Parent parent2 = new Parent();
		parent2.setId(2);
		concern2.setParent(parent2);
	}

	@Test
	@DisplayName("positive test case for add concern")
	public void testAddConcern() {
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.addConcern(concern, 1));
	}

	@Test
	@DisplayName("negative test case for add concern")
	public void testAddConcernNegative() {
		Mockito.when(concernRepository.save(concern2)).thenReturn(concern2);
		assertNotEquals(concern2, concernService.addConcern(concern, 1));
	}
	
	@Test
	@DisplayName("positive test case for add concern")
	public void testUpdateConcern() {
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.updateConcern(concern, 1));
	}

	@Test
	@DisplayName("negative test case for add concern")
	public void testUpdateConcernNegative() {
		Mockito.when(concernRepository.save(concern2)).thenReturn(concern2);
		assertNotEquals(concern2, concernService.updateConcern(concern, 1));
	}
}