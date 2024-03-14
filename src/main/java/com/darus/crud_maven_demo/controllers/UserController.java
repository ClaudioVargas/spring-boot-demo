package com.darus.crud_maven_demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darus.crud_maven_demo.services.NewsService;
import com.darus.crud_maven_demo.services.UserNewsService;
import com.darus.crud_maven_demo.services.UserService;
import com.darus.crud_maven_demo.entities.NewsEntity;
import com.darus.crud_maven_demo.entities.UserEntity;
import com.darus.crud_maven_demo.entities.UserNewsEntity;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private NewsService newsService;

	@Autowired
	private UserNewsService userNewsService;

	@GetMapping
	public ArrayList<UserEntity> getusers() {
		return this.userService.findByIsActive(true);
	}

	@GetMapping(path = "/{id}")
	public Optional<UserEntity> getuserById(@PathVariable Long id) {
		return this.userService.getUserById(id);
	}

	@GetMapping(path = "getNewsByUser/{id}")
	public ArrayList<NewsEntity> getNewsByUser(@PathVariable Long id) {
		return this.newsService.findAllNewsByUserId(id);
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserEntity request, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		UserEntity newUser = null;
		try {
			newUser = userService.saveUser(request);
		} catch (DataAccessException e) {
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("user", newUser);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PostMapping(path = "saveuserNews/{userId}")
	public ResponseEntity<?> saveUserNews(@PathVariable Long userId, @RequestBody NewsEntity news)
			throws ParseException {
		System.out.println("*************111*******************");
		Map<String, Object> response = new HashMap<>();

		UserNewsEntity newUserNews = null;
		try {
			Optional<UserEntity> userEntity = userService.getUserById(userId);

			if (userEntity != null) {

//				Optional<NewsEntity> newsDb = newsService.findById(news.getId());
				//
				// System.out.println("*************News*******************"+newsDb.get().getId());
				// if(newsDb.get() != null && userDb.get().getId() == 1) {
				// response.put("Error", "Ya existe");
				// return new ResponseEntity<Map<String, Object>>(response,
				// HttpStatus.BAD_REQUEST);
				// }
				System.out.println("*************111-11111*******************" + news.getId());
				NewsEntity newsEntity = new NewsEntity();
				newsEntity.setId(news.getId());
				newsEntity.setTitle(news.getTitle());
				newsEntity.setSubTitle(news.getSubTitle());
				newsEntity.setDescription(news.getDescription());
				newsEntity.setUrlImage(news.getUrlImage());
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-20");
				newsEntity.setPublishedAt(date1);
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-20");
				newsEntity.setUpdatedAt(date2);
				UserEntity user = new UserEntity();
				user.setId(userId);
				newsEntity.setUser(user);
				newsEntity.setActive(true);

				NewsEntity newNews = newsService.save(newsEntity);

				if (newNews != null) {
					System.out.println("*************222*******************");
					UserNewsEntity userNews = new UserNewsEntity();

					System.out.println("*************333*******************" + user.getId());
					userNews.setUser(user);
					NewsEntity _news = new NewsEntity();
					_news.setId(newNews.getId());

					System.out.println("*************444*******************" + newsEntity.getId());
					userNews.setNews(newsEntity);

					newUserNews = userNewsService.save(userNews);
				}
			}

		} catch (DataAccessException e) {
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("user", newUserNews);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
		return this.userService.updateById(user, id);
	}

	@PutMapping(path = "delete/{id}")
	public UserEntity deleteUser(@PathVariable Long id) {
		return this.userService.deleteUser(id);
	}

}
