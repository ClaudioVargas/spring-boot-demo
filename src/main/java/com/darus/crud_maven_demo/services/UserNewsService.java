package com.darus.crud_maven_demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darus.crud_maven_demo.entities.UserNewsEntity;
import com.darus.crud_maven_demo.repositories.IUserNewsRepository;

@Service
public class UserNewsService implements IUserNewsService {
	
	@Autowired
	IUserNewsRepository userNewsRepository;

	@Override
	public ArrayList<UserNewsEntity> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<UserNewsEntity>) userNewsRepository.findAll();
	}
	
	@Override
	public ArrayList<UserNewsEntity> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return userNewsRepository.findByUserId(id);
	}

	@Override
	public UserNewsEntity save(UserNewsEntity userNews) {
		// TODO Auto-generated method stub
		return userNewsRepository.save(userNews);
	}

}
