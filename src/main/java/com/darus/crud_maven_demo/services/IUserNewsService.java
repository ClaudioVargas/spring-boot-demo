package com.darus.crud_maven_demo.services;

import java.util.ArrayList;
import com.darus.crud_maven_demo.entities.UserNewsEntity;

public interface IUserNewsService {

	
	public UserNewsEntity save(UserNewsEntity userEntity);
	public ArrayList<UserNewsEntity> findAll();
	public ArrayList<UserNewsEntity> findByUserId(Long id);

}
