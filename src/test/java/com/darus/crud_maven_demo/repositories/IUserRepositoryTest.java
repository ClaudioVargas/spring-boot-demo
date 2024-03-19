package com.darus.crud_maven_demo.repositories;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.darus.crud_maven_demo.entities.UserEntity;

@DataJpaTest
class IUserRepositoryTest {
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	private IUserRepository userRepository;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void findUserActive() {
		ArrayList<UserEntity> users =  userRepository.findByActive(true);
		assertEquals(true, users.size() > 0);
	}
	
	@Test
	void saveUser() {
		UserEntity user = new UserEntity();
		user.setName("cindy");
		user.setEmail("cindy@mail.cl");
		user.setActive(true);
		userRepository.save(user);

		assertEquals(true, user.getId() > 0);

	}
	
	@Test
	void updateUser() {
		Optional<UserEntity> userDB = userRepository.findById((long)1);
		UserEntity user = userDB.map( u -> u).orElse(null);
		UserEntity userEdit = null;
		if(user.getId() > 0) {
			user.setEmail("claudioEditado@mail.cl");
			userEdit = userRepository.save(user);
		}

		assertEquals("claudioEditado@mail.cl", userEdit.getEmail());

	}

}





