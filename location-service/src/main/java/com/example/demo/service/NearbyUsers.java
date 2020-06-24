package com.example.demo.service;

import java.util.List;

public interface NearbyUsers<T> {

	List<T> findNearbyUsers(double lat, double lng, double radius);
}
