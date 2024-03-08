package com.darus.crud_maven_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.darus.crud_maven_demo.entities.AddressEntity;
import com.darus.crud_maven_demo.entities.PublicationEntity;
import com.darus.crud_maven_demo.entities.TagEntity;
import com.darus.crud_maven_demo.entities.UserEntity;
import com.darus.crud_maven_demo.repositories.IAddressRepository;
import com.darus.crud_maven_demo.repositories.IPublicationRepository;
import com.darus.crud_maven_demo.repositories.ITagRepository;
import com.darus.crud_maven_demo.repositories.IUserRepository;

@SpringBootApplication
public class CrudMavenDemoApplication implements CommandLineRunner {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	ITagRepository tagRepository;
	
	@Autowired
	IPublicationRepository publicationRepository;
	

	@Autowired
	IAddressRepository addressRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CrudMavenDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AddressEntity address = new AddressEntity();
		address.setStreet("calle 1");
		address.setNumber( (long)11);
		address.setActive(true);
		
		UserEntity user = new UserEntity();
		user.setName("claudio");
		user.setEmail("claudio@mail.cl");
		user.setActive(true);
		user.setAddress(address);
		userRepository.save(user);
		
		PublicationEntity publication = new PublicationEntity();
		publication.setTitle("nba");
		publication.setBody("Pierden lo warrior");
		publication.setActive(true);
		publication.setUser(user);
		publicationRepository.save(publication);


		TagEntity tag = new TagEntity();
		tag.setName("deporte");
		tag.setDescription("todos los deportes");
		tag.setActive(true);
		tagRepository.save(tag);
		
		
	}

}
