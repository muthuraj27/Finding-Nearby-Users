package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
	
	NearbyUsers<?> nearbyUsers;
	
	SearchService(NearbyUsers<?> nearbyUsers) {
		this.nearbyUsers = nearbyUsers;
	}

	public List<?> findNearbyUsers(double lat, double lng, double radius) {
		return this.nearbyUsers.findNearbyUsers(lat, lng, radius);
	}
}
