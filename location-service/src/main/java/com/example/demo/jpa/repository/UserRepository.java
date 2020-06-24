package com.example.demo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT u.id\r\n" + 
			"      , u.name\r\n" +
			"      , u.address\r\n" +
			"      , u.zipcode\r\n" + 
			"      , u.lat\r\n" + 
			"      , u.lng\r\n" + 
			"\r\n" + 
			"      , ( ACOS( COS( RADIANS( ?1  ) ) \r\n" + 
			"              * COS( RADIANS( u.lat ) )\r\n" + 
			"              * COS( RADIANS( u.lng ) - RADIANS( ?2 ) )\r\n" + 
			"              + SIN( RADIANS( ?1  ) )\r\n" + 
			"              * SIN( RADIANS( u.lat ) )\r\n" + 
			"          )\r\n" + 
			"        * 6371\r\n" + 
			"        ) AS distance_in_km\r\n" + 
			"\r\n" + 
			"  FROM user u\r\n" + 
			"  HAVING distance_in_km <= ?3\r\n" + 
			" ORDER BY distance_in_km ASC\r\n" + 
			" LIMIT 100", nativeQuery = true)
	List<User> findNearbyUsers(double lat, double lng, double radius);
}
