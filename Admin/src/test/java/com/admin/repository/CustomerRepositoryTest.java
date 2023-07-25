package com.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.Customer;
import com.admin.model.enumclass.StatusEnum;
import com.admin.repository.CustomerRepository;

import jakarta.transaction.Transactional;

public class CustomerRepositoryTest extends AdminApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void create() {
		String account = "홍길동";
        String password = "hong";
        StatusEnum status = StatusEnum.REGISTERED;
        String email = "hong@test.com";
        String phoneNumber = "010-1111-1111";
        LocalDateTime registeredAt = LocalDateTime.now();
        
        Customer customer = Customer.builder()
        							  .account(account)
        							  .password(password)
        							  .status(status)
        							  .email(email)
        							  .phoneNumber(phoneNumber)
        							  .registeredAt(registeredAt)
        							  .build();
        
        Customer newCustomer = customerRepository.save(customer);
        Assert.assertNotNull(newCustomer);
        
	}// create
	
	@Test
	@Transactional
	public void read() {
		Customer customer = customerRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
		
		// customer가 NotNull 일때만 실행 시키겠다.
		if (customer != null) { 
			customer.getOrderGroupList().stream().forEach(orderGroup -> {
				System.out.println("-------------- 주문묶음 --------------");
                System.out.println("수령인: " + orderGroup.getRevName());
                System.out.println("수령지: " + orderGroup.getRevAddress());
                System.out.println("총금액: " + orderGroup.getTotalPrice());
                System.out.println("총수량: " + orderGroup.getTotalQuantity());
               
                System.out.println("-------------- 주문상세 --------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                	System.out.println("주문의 상품: " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태: " + orderDetail.getStatus());
                    System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
	
                });
                
			});
		
		}// if
		
	}// read
	
	@Test
	public void update() {
		// 업데이트를 하기 위해서는 특정 데이터를 셀렉해야된다
		Optional<Customer> customer = customerRepository.findById(24L);
		
		customer.ifPresent(selectCustomer -> { // id가 존재한다면 업데이트 해준다
			selectCustomer.setEmail("joah@test.com")
								 .setUpdatedAt(LocalDateTime.now());
		
		  customerRepository.save(selectCustomer);

		});
		
	}// update
	
	@Test
	@Transactional
	public void delete() {
		Optional<Customer> customer = customerRepository.findById(2L);
		
		Assert.assertTrue(customer.isPresent()); // 반드시 데이터가 존재 해야되기 때문에
																 // customer는 isPresent()가 True이어야 한다.

		customer.ifPresent(selectCustomer -> {
			customerRepository.delete(selectCustomer);

		});

		Optional<Customer> deleteCustomer = customerRepository.findById(1L);
		
		// 제대로 삭제됐는지 확인해보기
		Assert.assertFalse(deleteCustomer.isPresent()); // 값이 반드시 false 이어야 한다
		
	}// delete
	
}