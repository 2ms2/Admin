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
import com.admin.model.network.request.OrderGroupApiRequest;
import com.admin.model.network.response.OrderGroupApiResponse;
import com.admin.service.OrderGroupApiService;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {
	
	@Autowired
	private OrderGroupApiService orderGroupApiService;
	
	@Override
	@PostMapping("")
	public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
		return orderGroupApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
		return orderGroupApiService.read(id);
		
	}

	@Override
	@PutMapping("")
	public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
		return orderGroupApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(Long id) {
		return orderGroupApiService.delete(id);
		
	}

}
