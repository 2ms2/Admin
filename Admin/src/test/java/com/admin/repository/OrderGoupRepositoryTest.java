package com.admin.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.OrderGroup;
import com.admin.model.enumclass.DeliveryStatusEnum;
import com.admin.model.enumclass.OrderGroupTypeEnum;
import com.admin.model.enumclass.PaymentTypeEnum;

public class OrderGoupRepositoryTest extends AdminApplicationTests {
	
	@Autowired
    private OrderGroupRepository orderGroupRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

    @Test
    public void created() {

	    // 객체 생성
	    OrderGroup orderGroup = new OrderGroup();
	    orderGroup.setStatus(DeliveryStatusEnum.DELIVERY_WAIT);
	    orderGroup.setOrderType(OrderGroupTypeEnum.ALL);
	    orderGroup.setRevAddress("서울시 강남구");
	    orderGroup.setRevName("홍길동");
	    orderGroup.setPaymentType(PaymentTypeEnum.CARD);
	    orderGroup.setTotalPrice(BigDecimal.valueOf(54000));
	    orderGroup.setTotalQuantity(1);
	    orderGroup.setOrderAt(LocalDateTime.now().minusDays(2)); // 현재날짜 -2일
	    orderGroup.setArrivalDate(LocalDateTime.now());
	    orderGroup.setCreatedAt(LocalDateTime.now());
	    orderGroup.setCustomer(customerRepository.getOne(1L));

	    OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
	    Assert.assertNotNull(newOrderGroup);
	    
    }
    
}
