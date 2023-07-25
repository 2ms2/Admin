package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

}