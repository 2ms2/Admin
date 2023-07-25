package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.network.Header;
import com.admin.model.network.request.CategoryApiRequest;
import com.admin.model.network.response.CategoryApiResponse;
import com.admin.repository.CategoryRepository;

@Service
public class CategoryApiService implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
		return null;
		
	}

	@Override
	public Header<CategoryApiResponse> read(Long id) {
		return null;
		
	}

	@Override
	public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
		return null;
		
	}

	@Override
	public Header delete(Long id) {
		return null;
		
	}

}
