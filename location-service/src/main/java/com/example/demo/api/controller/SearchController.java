package com.example.demo.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.response.SearchResponse;
import com.example.demo.jpa.entity.User;
import com.example.demo.service.SearchService;

@RestController
@RequestMapping("search")
public class SearchController {
	
	private final SearchService searchService;
	
	SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@GetMapping("/nearby")
	@ResponseBody
	public SearchResponse<User> searchNearByUsers(@RequestParam(name="lat") double lat, 
			@RequestParam(name="lon") double lon, @RequestParam(name="radius") double radius) {
		List<User> users = new ArrayList<User>();
		users = (List<User>) this.searchService.findNearbyUsers(lat, lon, radius);
		return new SearchResponse<User>(users);
	}
}
