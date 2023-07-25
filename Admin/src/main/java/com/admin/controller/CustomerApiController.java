package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.network.Header;
import com.admin.model.network.request.CustomerApiRequest;
import com.admin.model.network.response.CustomerApiResponse;
import com.admin.service.CustomerApiService;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController implements CrudInterface<CustomerApiRequest, CustomerApiResponse> {
	
	@Autowired
	private CustomerApiService customerApiService;
	
	@Override
	@PostMapping("")
	public Header<CustomerApiResponse> create(@RequestBody Header<CustomerApiRequest> request) {
		return customerApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<CustomerApiResponse> read(@PathVariable Long id) {
		return customerApiService.read(id);
		
	}

	@Override
	@PutMapping("")
	public Header<CustomerApiResponse> update(@RequestBody Header<CustomerApiRequest> request) {
		return customerApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		return customerApiService.delete(id);
		
	}
	
}
