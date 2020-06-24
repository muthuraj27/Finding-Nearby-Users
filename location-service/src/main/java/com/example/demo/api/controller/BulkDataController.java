package com.example.demo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.BulkDataService;

@RestController
@RequestMapping("bulk")
public class BulkDataController {

	private final BulkDataService bulkDataService;

	BulkDataController(BulkDataService bulkDataService) {
		this.bulkDataService = bulkDataService;
	}

	@PostMapping("/users")
	public ResponseEntity<?> handleBulkUserInsert(@RequestParam("file") MultipartFile file) {
		ResponseEntity<?> status;
		try {
			if (this.validateBulkUsersFile(file)) {
				bulkDataService.loadUsersFromCSV(file);
				status = new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				status = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println("exception occurred while bulk inserting user data " + e);
			status = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return status;
	}

	boolean validateBulkUsersFile(MultipartFile file) {
		boolean valid = true;
		if (file == null || file.getSize() <= 0 || !file.getOriginalFilename().contains(".csv")) {
			valid = false;
		}
		return valid;
	}

}
