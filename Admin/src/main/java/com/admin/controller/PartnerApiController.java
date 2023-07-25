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
import com.admin.model.network.request.PartnerApiRequest;
import com.admin.model.network.response.PartnerApiResponse;
import com.admin.service.PartnerApiService;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse>{

	@Autowired
	private PartnerApiService partnerApiService;
	
	@Override
	@PostMapping("")
	public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
		return partnerApiService.create(request);
		
	}

	@Override
	@GetMapping("{id}")
	public Header<PartnerApiResponse> read(Long id) {
		return partnerApiService.read(id);
		
	}

	@Override
	@PutMapping("")
	public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
		return partnerApiService.update(request);
		
	}

	@Override
	@DeleteMapping("{id}")
	public Header delete(Long id) {
		return partnerApiService.delete(id);
		
	}
	
}
