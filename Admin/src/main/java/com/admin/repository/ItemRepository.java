package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
}
