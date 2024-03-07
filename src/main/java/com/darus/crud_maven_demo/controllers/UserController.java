package com.darus.crud_maven_demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	 public UserEntity saveuser(@RequestBody UserEntity user) {
		 return this.userService.saveUser(user);
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
