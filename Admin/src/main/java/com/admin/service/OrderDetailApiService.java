package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.network.Header;
import com.admin.model.network.request.OrderDetailApiRequest;
import com.admin.model.network.response.OrderDetailApiResponse;
import com.admin.repository.ItemRepository;
import com.admin.repository.OrderDetailRepository;
import com.admin.repository.OrderGroupRepository;

@Service
public class OrderDetailApiService  implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse>{
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderGroupRepository orderGroupRepository;

	@Override
	public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
		return null;
	
	}

	@Override
	public Header<OrderDetailApiResponse> read(Long id) {
		return null;
		
	}

	@Override
	public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
		return null;
		
	}

	@Override
	public Header delete(Long id) {
		return null;
		
	}

}
