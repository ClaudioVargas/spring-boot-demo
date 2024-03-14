package com.darus.crud_maven_demo.repositories;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.entities.UserEntity;
import java.util.List;
import java.util.Set;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	ArrayList<UserEntity> findByActive(boolean active);
}
