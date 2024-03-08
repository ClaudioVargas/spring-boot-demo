package com.darus.crud_maven_demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.darus.crud_maven_demo.services.UserService;
import com.darus.crud_maven_demo.entities.UserEntity;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	 @Autowired
	 private UserService userService;
	
	 @GetMapping
	 public ArrayList<UserEntity> getusers() {
		 return this.userService.findByIsActive(true);
	 }
	 
	 @GetMapping(path = "/{id}")
	 public Optional<UserEntity> getuserById(@PathVariable Long id) {
		 return this.userService.getUserById(id);
	 }
	 
	 @PostMapping
	 public ResponseEntity<?> saveUser(@RequestBody UserEntity request) {
		 UserEntity newUser = null;
		 Map<String, Object> response = new HashMap<>();
		 try {
			 newUser = userService.saveUser(request);
		 } catch(DataAccessException e) {
			 response.put("Error", e);
			 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 response.put("user", newUser);
		 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	 }
	 
	 @PutMapping(path = "/{id}")
	 public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
		 return this.userService.updateById(user, id);
	 }
	 
	 @PutMapping(path = "delete/{id}")
	 public UserEntity deleteUser( @PathVariable Long id) {
		 return this.userService.deleteUser(id);
	 }

}
