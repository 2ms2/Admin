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
import com.admin.model.network.request.OrderDetailApiRequest;
import com.admin.model.network.response.OrderDetailApiResponse;
import com.admin.service.OrderDetailApiService;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailController implements CrudInterface<OrderDetailApiRequest,OrderDetailApiResponse> {

	@Autowired
	private OrderDetailApiService orderDetailApiService;
	
	@Override
	@PostMapping("")
	public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
		return orderDetailApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<OrderDetailApiResponse> read(@PathVariable Long id) {
		return orderDetailApiService.read(id);
		
	}

	@Override
	@PutMapping("")
	public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
		return orderDetailApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		return orderDetailApiService.delete(id);
		
	}

}
