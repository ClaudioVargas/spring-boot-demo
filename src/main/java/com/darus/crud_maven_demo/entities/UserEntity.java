package com.darus.crud_maven_demo.entities;

import java.util.Set;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;

@Validated
@Entity
@Table(name="users")
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
	@NotEmpty
	private boolean active;
	
	@OneToMany(mappedBy="user")
    private Set<PublicationEntity> publications;
	
	@ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private AddressEntity address;
	
	

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

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

	public Set<PublicationEntity> getPublications() {
		return publications;
	}

	public void setPublications(Set<PublicationEntity> publications) {
		this.publications = publications;
	}




}
