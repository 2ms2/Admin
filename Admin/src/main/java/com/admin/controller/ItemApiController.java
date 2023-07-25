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
import com.admin.model.network.request.ItemApiRequest;
import com.admin.model.network.response.ItemApiResponse;
import com.admin.service.ItemApiService;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

	@Autowired
	private ItemApiService itemApiService;
	
	@Override
	@PostMapping("")
	public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
		return itemApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<ItemApiResponse> read(@PathVariable Long id) {
		return itemApiService.read(id);
		
	}
	
	@Override
	@PutMapping("")
	public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
		return itemApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(@PathVariable Long id) {
		return itemApiService.delete(id);
		
	}
	
}