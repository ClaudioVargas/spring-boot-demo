package com.darus.crud_maven_demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.darus.crud_maven_demo.entities.NewsEntity;

public interface INewsService {
	
	public ArrayList<NewsEntity> findAllNewsByUserId(Long id);
	
	public NewsEntity save(NewsEntity news);
	
	public boolean existsById(Long id);
	
	public Optional<NewsEntity> findById(Long id); 

}
