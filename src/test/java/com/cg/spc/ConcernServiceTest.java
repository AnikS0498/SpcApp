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
import com.cg.spc.services.IConcernService;

@SpringBootTest
public class ConcernServiceTest {

	@Autowired
	private IConcernService concernService;

	@MockBean
	private IConcernRepository concernRepository;
	
	
	@Test
	@DisplayName("positive test case for add concern")
	public void testAddConcern() {
		Concern concern = new Concern();
		concern.setConcern("child getting low marks");
		concern.setConcernType(ConcernType.ACADEMIC);;
		Parent parent = new Parent();
		parent.setId(1);
		concern.setParent(parent);
		Mockito.when(concernRepository.save(concern)).thenReturn(concern);
		assertEquals(concern, concernService.addConcern(concern, 1));
	}

	@Test
	@DisplayName("negative test case for add concern")
	public void testAddConcernNegative() {
		Concern concern = new Concern();
		concern.setConcernType(ConcernType.ACADEMIC);
		concern.setConcern("child getting low marks");
		Parent parent = new Parent();
		parent.setId(1);
		concern.setParent(parent);
		Concern concern2 = new Concern();
		concern2.setConcernType(ConcernType.ACADEMIC);
		concern2.setConcern("child getting low marks");
		Parent parent1 = new Parent();
		parent1.setId(2);
		concern2.setParent(parent1);
		assertNotEquals(concern2, concernService.addConcern(concern, 1));
	}
}