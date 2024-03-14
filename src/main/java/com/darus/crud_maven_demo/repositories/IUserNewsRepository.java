package com.darus.crud_maven_demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darus.crud_maven_demo.entities.UserNewsEntity;

public interface IUserNewsRepository extends JpaRepository<UserNewsEntity, Long>{
	ArrayList<UserNewsEntity> findByUserId(long id);
}
