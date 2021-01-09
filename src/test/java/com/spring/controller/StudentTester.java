package com.spring.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.spring.ApplicationTestCaseRunner;
import com.spring.dto.StudentDTO;

public class StudentTester extends ApplicationTestCaseRunner{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void defaultTest() throws Exception {
	}
	
	@Test
	public void isStudentSaveSuccessWithAllValues() throws Exception {
		
		String uri = "/student/save";
			
		RequestBuilder builder = postRequest(uri, prepareStudentWithAllValues());
		MvcResult result = mockMvc.perform(builder).andReturn();

		if (HttpStatus.CREATED.value() == result.getResponse().getStatus()) {
			Assert.assertEquals(HttpStatus.CREATED.value(),  result.getResponse().getStatus());		
			System.out.println("Test code successful");
		} else {
			Assert.assertEquals(HttpStatus.NOT_FOUND.value(),  result.getResponse().getStatus());
			System.out.println("Test code Failed");
		}

	}

	@Test
	public void fetchStudent() throws Exception {

		String selectUri = "/student/find-all";

		RequestBuilder getBuilder = getRequest(selectUri);
		MvcResult getResult = mockMvc.perform(getBuilder).andReturn();
		MockHttpServletResponse getResponse = getResult.getResponse();
		if (HttpStatus.FOUND.value() == getResponse.getStatus()) {
			Assert.assertEquals(HttpStatus.FOUND.value(), getResponse.getStatus());
			System.out.println("Fetch code successful");
		} else {
			Assert.assertEquals(HttpStatus.NOT_FOUND.value(), getResponse.getStatus());
			System.out.println("Fetch code Failed");
		}

	}


	public StudentDTO prepareStudentWithAllValues() {					
		return StudentDTO.builder().studentName("Zakir Khan").studentRoll(11).build();		
	}



}
