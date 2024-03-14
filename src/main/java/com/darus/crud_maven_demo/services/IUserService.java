package com.darus.crud_maven_demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.entities.UserEntity;

public interface IUserService {
	
	public ArrayList<UserEntity> findByIsActive(boolean isActive);
	
	public Optional<UserEntity> getUserById(Long id);
	
	public UserEntity saveUser(UserEntity user);
	
	public UserEntity updateById(UserEntity request, Long id);
	
	public UserEntity deleteUser(Long id);
	
	

}
