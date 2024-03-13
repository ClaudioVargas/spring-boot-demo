package com.darus.crud_maven_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darus.crud_maven_demo.entities.NewsEntity;


public interface INewsRepository extends JpaRepository<NewsEntity, Long> {

}
