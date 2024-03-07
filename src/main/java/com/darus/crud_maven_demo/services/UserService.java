package com.darus.crud_maven_demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darus.crud_maven_demo.entities.UserEntity;
import com.darus.crud_maven_demo.repositories.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public Optional<UserEntity> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}
	
	@Override
	public UserEntity updateById(UserEntity request, Long id){
		UserEntity user = userRepository.findById(id).get();
		user.setName(request.getName());
		user.setName(request.getEmail());
		return user;
	}
	
	@Override
	public UserEntity deleteUser(Long id){
		UserEntity user = userRepository.findById(id).get();
		if(user != null)
		user.setActive(false);
		return user;
	}

	@Override
	public ArrayList<UserEntity> findByIsActive(boolean isActive) {
		return (ArrayList<UserEntity>) userRepository.findByIsActive(true);
	}
}
