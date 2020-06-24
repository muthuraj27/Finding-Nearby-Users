package com.example.demo.api.response;

import java.util.List;

public class SearchResponse<T> {

	private List<T> data;
	
	public List<T> getData() {
		return data;
	}

	public SearchResponse(List<T> data) {
		super();
		this.data = data;
	}
	
}
