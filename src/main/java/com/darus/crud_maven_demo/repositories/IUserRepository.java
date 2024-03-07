package com.darus.crud_maven_demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darus.crud_maven_demo.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	ArrayList<UserEntity> findByActive(boolean active);
	

}
