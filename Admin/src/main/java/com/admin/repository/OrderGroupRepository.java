package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.entity.OrderGroup;

public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
	
}