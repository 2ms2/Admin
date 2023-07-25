package com.admin.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.entity.OrderGroup;
import com.admin.model.network.Header;
import com.admin.model.network.request.OrderGroupApiRequest;
import com.admin.model.network.response.OrderGroupApiResponse;
import com.admin.repository.CustomerRepository;
import com.admin.repository.OrderGroupRepository;

@Service
public class OrderGroupApiService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse>{
	
	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
		OrderGroupApiRequest body = request.getData();
		
        OrderGroup orderGroup = OrderGroup.builder()
        								   .status(body.getStatus())
        								   .orderType(body.getOrderType())
        								   .revAddress(body.getRevAddress())
        								   .revName(body.getRevName())
        								   .paymentType(body.getPaymentType())
        								   .totalPrice(body.getTotalPrice())
        								   .totalQuantity(body.getTotalQuantity())
        								   .orderAt(LocalDateTime.now())
        								   .customer(customerRepository.getOne(body.getCustomerId()))
        								   .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        return response(newOrderGroup);
	}

	@Override
	public Header<OrderGroupApiResponse> read(Long id) {
		return orderGroupRepository.findById(id)
												.map(orderGroup -> response(orderGroup))
												.orElseGet(() -> Header.ERROR("데이터없음"));
		
    }

	@Override
	public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
		 OrderGroupApiRequest body = request.getData();

	        return orderGroupRepository.findById(body.getId())
	                .map(orderGroup -> {
	                			orderGroup
	                				.setStatus(body.getStatus())
	                				.setOrderType(body.getOrderType())
	                				.setRevAddress(body.getRevAddress())
	                				.setRevName(body.getRevName())
	                				.setPaymentType(body.getPaymentType())
	                            	.setTotalPrice(body.getTotalPrice())
	                            	.setTotalQuantity(body.getTotalQuantity())
	                            	.setOrderAt(body.getOrderAt())
	                            	.setArrivalDate(body.getArrivalDate())
	                            	.setCustomer(customerRepository.getOne(body.getCustomerId()));
	                   
	                	return orderGroup;
	                	
	                })
			       .map(changeOrderGroup -> orderGroupRepository.save(changeOrderGroup)) 
			       .map(this::response)
			       .orElseGet(() -> Header.ERROR("데이터 없음"));
	        
	}

	@Override
	public Header delete(Long id) {
		return orderGroupRepository.findById(id)
                .map(orderGroup -> {
                	orderGroupRepository.delete(orderGroup);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터없음"));
		
	}
	
	// 공통 메서드
	private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
        											.id(orderGroup.getId())
        											.status(orderGroup.getStatus())
        											.orderType(orderGroup.getOrderType())
        											.revAddress(orderGroup.getRevAddress())
        											.revName(orderGroup.getRevName())
        											.paymentType(orderGroup.getPaymentType())
        											.totalPrice(orderGroup.getTotalPrice())
        											.totalQuantity(orderGroup.getTotalQuantity())
        											.orderAt(orderGroup.getOrderAt())
        											.arrivalDate(orderGroup.getArrivalDate())
        											.customerId(orderGroup.getCustomer().getId())
        											.build();

        return Header.OK(body);
        
    }

}