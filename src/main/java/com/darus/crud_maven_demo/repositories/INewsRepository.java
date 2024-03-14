package com.darus.crud_maven_demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darus.crud_maven_demo.entities.NewsEntity;

@Repository
public interface INewsRepository extends JpaRepository<NewsEntity, Long> {
	
	ArrayList<NewsEntity> findAllNewsByUserId(Long id);
	boolean existsById(Long id);

}
