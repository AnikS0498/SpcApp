package com.cg.spc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spc.entities.Parent;
import com.cg.spc.repositories.IParentRepository;
import com.cg.spc.services.IParentService;

@SpringBootTest
public class ParentServiceTest {

	@Autowired
	private IParentService parentService;

	@MockBean
	private IParentRepository parentRepo;

	

//     @Test
//     @DisplayName("positive test case for add concern")
//     public void testAddConcern()
//     {
//         Concern concern = new Concern();
//         concern.setConcern("child getting low marks consistently");
//         concern.setParent(null);
//         Mockito.when(concernService.addConcern(concern, 0))
//     }

	@Test
	@DisplayName("positive test case for add parent")
	public void testAddParent() {
		Parent parent = new Parent();
		parent.setName("elon");
		parent.setContact("9876543210");
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		assertEquals(parent.getName(), parentService.addParentDetails(parent).getName());
	}

	@Test
	@DisplayName("negative test case for add parent")
	public void negativeTestAddParent() {
		Parent parent = new Parent();
		parent.setContact("1234567890");
		parent.setName("elon");
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		assertNotEquals("musk", parentService.addParentDetails(parent).getName());
	}

	@Test
	@DisplayName("positive test case for update parent")
	public void testUpdateParentDetails() {
		Parent parent = new Parent();
		parent.setName("neil");
		parent.setContact("9552179245");
		List<Integer> studentIdList = new ArrayList<>();
		studentIdList.add(38);
		studentIdList.add(39);
		studentIdList.add(40);
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		assertEquals(parent.getId(), parentService.updateParentDetails(parent, studentIdList));
	}

	@Test
	@DisplayName("negative test case for update parent")
	public void negativeTestUpdateParentDetails() {
		Parent parent = new Parent();
		parent.setName("neil");
		parent.setContact("9552179245");
		List<Integer> studentIdList = new ArrayList<>();
		studentIdList.add(38);
		studentIdList.add(39);
		studentIdList.add(40);
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		assertNotEquals(359, parentService.updateParentDetails(parent, studentIdList));
	}

}