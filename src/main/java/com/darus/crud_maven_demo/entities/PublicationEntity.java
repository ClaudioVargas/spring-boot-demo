package com.darus.crud_maven_demo.entities;

import java.util.Set;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Validated
@Entity
@Table(name="publications")
public class PublicationEntity {
	
	public PublicationEntity(){}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false)
	@Size(min=3, max=100)
	private String title; 

	@Column
	@NotEmpty
	private String body;
	
	@Column
	@NotNull
	private boolean active;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity user;
	 
	@ManyToMany
	@JoinTable(
		name = "publicaion_tag", 
		joinColumns = @JoinColumn(name = "publication_id"), 
		inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<TagEntity> publicationTags;
	 
	//SETTERS AND GETTERS 
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


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
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



	
}
