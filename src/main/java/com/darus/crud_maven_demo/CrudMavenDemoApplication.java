package com.darus.crud_maven_demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.entities.TagEntity;
import com.darus.crud_maven_demo.entities.UserEntity;
import com.darus.crud_maven_demo.entities.UserNewsEntity;
import com.darus.crud_maven_demo.repositories.INewsRepository;
import com.darus.crud_maven_demo.repositories.ITagRepository;
import com.darus.crud_maven_demo.repositories.IUserNewsRepository;
import com.darus.crud_maven_demo.repositories.IUserRepository;

@SpringBootApplication
public class CrudMavenDemoApplication implements CommandLineRunner {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ITagRepository tagRepository;
	
	@Autowired
	INewsRepository newsRepository;

	@Autowired
	IUserNewsRepository userNewsRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CrudMavenDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		UserEntity user = new UserEntity();
		user.setName("claudio");
		user.setEmail("claudio@mail.cl");
		user.setActive(true);
		
		UserEntity user2 = new UserEntity();
		user2.setName("cindy");
		user2.setEmail("cindy@mail.cl");
		user2.setActive(true);
		
		userRepository.save(user);
		
		userRepository.save(user2);
		
//		NewsEntity news = new NewsEntity();
//		news.setTitle("nba");
//		news.setDescription("Pierden lo warrior");
//		news.setSummary("Los warrios pierden contra laker 100 contr 101");
//		Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
//		news.setPublication_date(date);
//		news.setActive(true);
//		news.setUser(user);
//		newsRepository.save(news);
//		
//		NewsEntity news2 = new NewsEntity();
//		news2.setTitle("nba");
//		news2.setDescription("Pierden lo warrior");
//		news2.setSummary("Los warrios pierden contra laker 100 contr 101");
//		Date date2 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
//		news2.setPublication_date(date2);
//		news2.setActive(true);
//		news2.setUser(user);
//		newsRepository.save(news2);
		
//		UserNewsEntity userNews = new UserNewsEntity();
//		userNews.setNews(news);
//		userNews.setUser(user);
//		
//		UserNewsEntity userNews2 = new UserNewsEntity();
//		userNews2.setNews(news);
//		userNews2.setUser(user2);
//		
//		UserNewsEntity userNews3 = new UserNewsEntity();
//		userNews3.setNews(news2);
//		userNews3.setUser(user2);
//
//		userNewsRepository.save(userNews);
//		userNewsRepository.save(userNews2);
//		userNewsRepository.save(userNews3);
		


//		TagEntity tag = new TagEntity();
//		tag.setName("deporte");
//		tag.setDescription("todos los deportes");
//		tag.setActive(true);
//		tagRepository.save(tag);
//		

		
	}

}
