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
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Validated
@Entity
@Table(name="tags")
public class TagEntity {

	public TagEntity() {}

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
	private String description;
	

	@Column
	@NotEmpty
	private boolean active;
	
	@ManyToMany
	@JoinTable(
		name = "publicaion_tag", 
		joinColumns= @JoinColumn(name = "tag_id"),
		inverseJoinColumns = @JoinColumn(name = "publication_id"))
    Set<PublicationEntity> publicationTags;
}
