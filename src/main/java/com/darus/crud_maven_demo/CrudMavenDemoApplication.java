package com.darus.crud_maven_demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.darus.crud_maven_demo.repositories.INewsRepository;
import com.darus.crud_maven_demo.repositories.ITagRepository;
import com.darus.crud_maven_demo.repositories.IUserRepository;

@SpringBootApplication
public class CrudMavenDemoApplication implements CommandLineRunner {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ITagRepository tagRepository;
	
	@Autowired
	INewsRepository newsRepository;
	

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
		userRepository.save(user);
		
		NewsEntity news = new NewsEntity();
		news.setTitle("nba");
		news.setDescription("Pierden lo warrior");
		news.setSummary("Los warrios pierden contra laker 100 contr 101");
		Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );
		news.setPublication_date(date);
		news.setActive(true);
		news.setUser(user);
		newsRepository.save(news);
		
		List<NewsEntity> _userNewsLiked = new ArrayList<>();
		_userNewsLiked.add(news);
		
//		Set<NewsEntity> userNewsLiked = new HashSet<>(_userNewsLiked);
		
		user.setNewsLiked(_userNewsLiked);
		userRepository.save(user);
		
		


		TagEntity tag = new TagEntity();
		tag.setName("deporte");
		tag.setDescription("todos los deportes");
		tag.setActive(true);
		tagRepository.save(tag);
		
		
	}

}
