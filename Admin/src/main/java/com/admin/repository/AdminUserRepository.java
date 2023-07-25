package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.entity.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	
}
