package com.admin.repository;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.Partner;
import com.admin.model.enumclass.PartnerStatusEnum;
import com.admin.model.enumclass.StatusEnum;
import com.admin.repository.PartnerRepository;

public class PartnerRepositoryTest extends AdminApplicationTests {
	
	@Autowired
    private PartnerRepository partnerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String name = "Partner01";
        PartnerStatusEnum status = PartnerStatusEnum.APPROVAL;
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1234-1234";
        String businessNumber = "1234567890000";
        String ceoName = "최송이";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        
        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        
        partner.setCategory(categoryRepository.getOne(1L));
        
        Partner newPartner = partnerRepository.save(partner);

        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);

    }
    
}
