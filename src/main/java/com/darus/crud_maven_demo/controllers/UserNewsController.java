package com.darus.crud_maven_demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darus.crud_maven_demo.entities.UserNewsEntity;
import com.darus.crud_maven_demo.services.UserNewsService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/userNews")
public class UserNewsController {
	
	@Autowired
	private UserNewsService userNewsService;
	
	@GetMapping
	public ArrayList<UserNewsEntity> getAll() {
		return this.userNewsService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ArrayList<UserNewsEntity> getuserNews(@PathVariable Long id) {
		return this.userNewsService.findByUserId(id);
	}
}
