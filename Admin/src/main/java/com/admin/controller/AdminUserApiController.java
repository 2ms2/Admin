package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.network.Header;
import com.admin.model.network.request.AdminUserApiRequest;
import com.admin.model.network.response.AdminUserApiResponse;
import com.admin.service.AdminUserApiService;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse>{
	
	@Autowired
	private AdminUserApiService adminUserApiService;
	
	@Override
	@PostMapping("")
	public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
		return adminUserApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<AdminUserApiResponse> read(Long id) {
		return adminUserApiService.read(id);
		
	}

	@Override
	@PutMapping("")
	public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
		return adminUserApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(Long id) {
		return adminUserApiService.delete(id);
		
	}

}
