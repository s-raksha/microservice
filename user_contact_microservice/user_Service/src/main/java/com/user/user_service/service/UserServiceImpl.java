package com.user.user_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.user_service.entity.User;

@Service
public class UserServiceImpl implements UserService {

	List<User> users = Arrays.asList(new User(1001L, "Raksha", "91675476"), new User(1002L, "Ini", "1234"),
			new User(1003L, "Akash", "23456"), new User(1004L, "Raghu", "56785"));

	@Override
	public User getUser(Long userId) {
		return users.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
	}

}