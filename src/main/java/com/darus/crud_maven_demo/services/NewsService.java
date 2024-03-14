package com.darus.crud_maven_demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.repositories.INewsRepository;

@Service
public class NewsService implements INewsService {

	@Autowired
	INewsRepository newsRepository;
	
	@Override
	public ArrayList<NewsEntity> findAllNewsByUserId(Long id) {
		// TODO Auto-generated method stub
		return (ArrayList<NewsEntity>)newsRepository.findAllNewsByUserId(id);
	}

	@Override
	public NewsEntity save(NewsEntity news) {
		// TODO Auto-generated method stub
		return newsRepository.save(news);
	}

	@Override
	public boolean existsById(Long id) {
		return newsRepository.existsById(id);
	}

	@Override
	public Optional<NewsEntity> findById(Long id) {
		return newsRepository.findById(id);
	}
	

}
