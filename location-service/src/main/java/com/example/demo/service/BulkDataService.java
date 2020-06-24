package com.example.demo.service;

import java.io.InputStreamReader;
import java.util.List;

import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.util.ListCollector;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.UserRepository;

@Service
public class BulkDataService {
	
	private final UserRepository userRepository;

	BulkDataService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void loadUsersFromCSV(MultipartFile file) throws Exception {
		List<User> users = CsvParser.mapTo(User.class)
				.forEach(new InputStreamReader(file.getInputStream()), new ListCollector<User>()).getList();
		this.userRepository.saveAll(users);
	}
}
