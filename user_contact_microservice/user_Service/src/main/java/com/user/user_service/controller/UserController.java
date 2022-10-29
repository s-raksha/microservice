package com.user.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.user_service.entity.Contact;
import com.user.user_service.entity.User;
import com.user.user_service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {

		User user = userService.getUser(userId);
		List<Contact> contacts = restTemplate.getForObject("http://CONTACT/contact/user/" + userId, List.class);
		user.setContacts(contacts);
		return user;
	}

}