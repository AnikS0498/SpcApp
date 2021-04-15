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

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;
import com.cg.spc.repositories.IFeeRepository;
import com.cg.spc.services.IFeeService;

@SpringBootTest
public class FeeServiceTest {

	@Autowired
	private IFeeService feeService;

	@MockBean
	private IFeeRepository feeRepository;

	Fee fee1;
	Fee fee2;

	@BeforeEach
	public void init() {
		fee1 = new Fee();
		fee1.setFeeDue(16000);
		fee1.setFeePaid(8000);
		Student student = new Student();
		student.setId(36);
		student.setName("Pankaj");
		fee1.setStudent(student);

		fee2 = new Fee();
		fee2.setFeeDue(16000);
		fee2.setFeePaid(8000);
		Student student2 = new Student();
		student2.setId(45);
		student2.setName("Robert");
		fee2.setStudent(student2);
	}

	@Test
	@DisplayName("positive test case for add fee details")
	public void testAddFeeDetails() {
		Mockito.when(feeRepository.save(fee1)).thenReturn(fee1);
		assertEquals(fee1, feeService.addFeeDetails(fee1, 36));
	}

	@Test
	@DisplayName("negative test case for add fee details")
	public void testAddFeeDetailsNegative() {
		Mockito.when(feeRepository.save(fee1)).thenReturn(fee1);
		assertNotEquals(fee2, feeService.addFeeDetails(fee1, 36));

	}
	
	@Test
	@DisplayName("positive test case for update fee details")
	public void testUpdateDetails() {
		Mockito.when(feeRepository.save(fee1)).thenReturn(fee1);
		assertEquals(fee1, feeService.addFeeDetails(fee1, 36));
	}
	
	@Test
	@DisplayName("positive test case for update fee details")
	public void testUpdateDetailsNegative() {
		Mockito.when(feeRepository.save(fee1)).thenReturn(fee1);
		assertNotEquals(fee2, feeService.addFeeDetails(fee1, 36));
	}
	
	/*
	 * @Test
	 * 
	 * @DisplayName("positive test case for get fee by ID ") public void
	 * testGetFeeById() { assertEquals(fee1, feeService.getFeeById(36)); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("negative test case for get fee by ID ") public void
	 * testGetFeeByIdNegative() { assertNotEquals(fee2, feeService.getFeeById(36));
	 * }
	 */

}
