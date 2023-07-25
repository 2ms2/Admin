package com.admin.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.OrderDetail;
import com.admin.model.enumclass.OrderStatusEnum;
import com.admin.repository.OrderDetailRepository;

public class OrderDetailRepositoryTest extends AdminApplicationTests {
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	OrderGroupRepository orderGroupRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus(OrderStatusEnum.WAITING);
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2)); // 현재일자 + 2일
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(54000));
        orderDetail.setOrderGroup(orderGroupRepository.getOne(1L));
        orderDetail.setItem(itemRepository.getOne(1L));
        orderDetail.setCreatedAt(LocalDateTime.now());
        
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);

    }
	
}
