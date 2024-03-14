package com.darus.crud_maven_demo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;

@Validated
@Entity( name="userEntity")
@Table(name="users")
@JsonIgnoreProperties({ "news", "newsLiked" })
public class UserEntity {
	
	public UserEntity() {}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false)
	@Size(min=3, max=20)
	private String name;

	@Column
	@NotEmpty
	@Email
	private String email;
	

	@Column
	@NotNull
	private boolean active;
	
	@OneToMany(mappedBy="user")
    private Set<NewsEntity> news;
	
	
	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL)
	private List<UserNewsEntity> userNews = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<NewsEntity> getNews() {
		return news;
	}


	public void setNews(Set<NewsEntity> news) {
		this.news = news;
	}


	public List<UserNewsEntity> getUserNews() {
		return userNews;
	}


	public void setUserNews(List<UserNewsEntity> userNews) {
		this.userNews = userNews;
	}


}
