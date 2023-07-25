package com.admin.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.Item;
import com.admin.model.enumclass.ItemTypeEnum;
import com.admin.repository.ItemRepository;

public class ItemRepositoryTest extends AdminApplicationTests {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Test
	public void create() {
		Item item = new Item();
        item.setStatus(ItemTypeEnum.REGISTERED);
        item.setName("크롭반팔티");
        item.setTitle("반팔");
        item.setContent("콜라보!");
        item.setPrice(BigDecimal.valueOf(54000));
        item.setBrandName("뉴발란스");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setPartner(partnerRepository.getOne(1L));

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
        
	}// create
	
	@Test
    public void read() {
		Long id = 1L;
        
        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent()); // true가 반환된다.

    }// read
	
}
