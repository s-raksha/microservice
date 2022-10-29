package com.contact.contact_service.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.contact_service.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	List<Contact> contacts = Arrays.asList(new Contact(1L, "ini@gmail.com", "ini", 1001L),
			new Contact(1L, "akash@gmail.com", "akash", 1001L), new Contact(1L, "ini@gmail.com", "ini", 1002L),
			new Contact(1L, "raghu@gmail.com", "raghu", 1001L), new Contact(1L, "akash@gmail.com", "akash", 1002L),
			new Contact(1L, "ini@gmail.com", "ini", 1003L));

	@Override
	public List<Contact> getContactOfUser(Long userId) {
		return contacts.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}