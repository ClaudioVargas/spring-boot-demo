package com.darus.crud_maven_demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Validated
@Entity(name="newsEntity")
@Table(name="news")
public class NewsEntity {
	
	public NewsEntity(){}
	
	@Id
	private Long id;
	
	@NotEmpty
	@Column(nullable = false)
	@Size(min=3, max=200)
	private String title; 
	
	@NotEmpty
	@Column(nullable = false)
	@Size(min=3, max=50)
	private String subTitle; //news_site

	@Column
	@NotEmpty
	@Size(min=3, max=200)
	private String description; // sumary
	
	@NotEmpty
	@Column(nullable = false)
	@Size(min=3, max=200)
	private String urlImage; 


	@Column
	@NotNull
	private Date publishedAt;
	
	@Column
	@NotNull
	private Date updatedAt;
	
	@Column
	@NotNull
	private boolean active;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	
	@OneToMany(mappedBy = "news",
			cascade = CascadeType.ALL)
	private List<UserNewsEntity> newsTags = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<UserNewsEntity> getNewsTags() {
		return newsTags;
	}

	public void setNewsTags(List<UserNewsEntity> newsTags) {
		this.newsTags = newsTags;
	}
	
	
}
