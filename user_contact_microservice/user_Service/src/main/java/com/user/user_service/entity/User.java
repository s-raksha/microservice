package com.user.user_service.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long userId;
	private String userName;
	private String phoneNumber;

	List<Contact> contacts = new ArrayList<>();
	
	public User(Long userId, String userName, String phoneNumber) {
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}

}