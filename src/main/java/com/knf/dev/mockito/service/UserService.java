package com.knf.dev.mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;



	public User saveUser(User user) {
		
		return userRepository.save(user);
	}


	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public User updating(User s) {
		return userRepository.save(s);
	}

	public String deleteUser() {
		return userRepository.deleteById();
	}
}