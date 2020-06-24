package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.UserRepository;

@Service
public class NearbyUsersByQuery implements NearbyUsers<User> {

	private final UserRepository userRepository;
	
	NearbyUsersByQuery(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findNearbyUsers(double lat, double lng, double radius) {
		return this.userRepository.findNearbyUsers(lat, lng, radius);
	}

}
