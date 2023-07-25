package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
}
