package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import tintin.model.User;
import tintin.services.DatesServiceImpl;
import tintin.services.StudentServiceImpl;
import tintin.services.UserServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TinTinProjectAppTests {

	@Autowired
	private UserServiceImpl user;
	@Autowired
	private StudentServiceImpl student;
	@Autowired
	private DatesServiceImpl date;

	@BeforeEach
	void initTest() {
		User user = new User();
		user.setUsername("Floresilla");
	}
	
	
	@Test
	@Order(1)
	void testLoginUser() throws Exception {
		
	}
	
	void testUserExists() throws Exception{
		
	}
	
	void testUserActive() throws Exception{
		
	}
	
	void testUserIsStudent() throws Exception{
		
	}
	
	void testUserPassCipher() throws Exception{
		
	}
	
	

	@Test
	//@BeforeEach
	void testChangePassUser() throws Exception {
		
	}

	@Test
	void testGetStudent() throws Exception {

	}

	@Test
	void testGetStudentRegister() throws Exception {

	}

	@Test
	void testGetDates() throws Exception {

	}

}
