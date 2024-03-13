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
	
//	UserEntity findNews(Long id);
	

	
//	users_liked_news
	@Query(value = "select  n.ID as id, n.USER_ID as userId, n.ACTIVE as active, n.PUBLICATION_DATE as publicationDate, n.TITLE as title, n.DESCRIPTION as description, n.SUMMARY as sumary  \r\n"
			+ "from USERS_LIKED_NEWS  uln  \r\n"
			+ "inner join news  n on n.id = uln.news_id\r\n"
			+ "where uln.user_id = ?1", nativeQuery = true)
	ArrayList<?> findNewsById(long id);	

}
