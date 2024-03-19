package com.darus.crud_maven_demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.entities.UserEntity;

@DataJpaTest
class INewsRepositoryTest {
	
	@Autowired
	INewsRepository newsRepository;

	@Autowired
	TestEntityManager testEntityManager;

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
	void saveNews() {
		
		try {
			NewsEntity news = new NewsEntity();
			news.setTitle("nba");
			news.setSubTitle("Pierden lo warrior");
			news.setDescription("Los warrios pierden contra laker 100 contr 101");
			Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
			news.setPublishedAt(date);
			news.setActive(true);
			UserEntity user = new UserEntity();
			user.setId((long)1);
			news.setUser(user);
			NewsEntity newNews = newsRepository.save(news);
			assertEquals(true, newNews.getId() > 0);
		} catch (Exception e) {}
	}
	
	@Test
	void updateNews() {
		Optional<NewsEntity> newsDb = newsRepository.findById((long) 1);
		NewsEntity news = newsDb.map( n -> n).orElse(null);
		NewsEntity newsEdit = null;
		if(news.getId() > 0) {
			news.setTitle("titulo editado");
			newsEdit  = newsRepository.save(news);
		}

		assertEquals("titulo editado", newsEdit.getTitle());
	}

}
