package com.admin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.entity.Customer;
import com.admin.model.enumclass.StatusEnum;
import com.admin.model.network.Header;
import com.admin.model.network.request.CustomerApiRequest;
import com.admin.model.network.response.CustomerApiResponse;
import com.admin.repository.CustomerRepository;

@Service
public class CustomerApiService implements CrudInterface<CustomerApiRequest, CustomerApiResponse> {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Header<CustomerApiResponse> create(Header<CustomerApiRequest> request) {
		// 1. request data 가져오기
		CustomerApiRequest customerApiRequest = request.getData();

        // 2. customer 생성하기
        Customer customer = Customer.builder()
        							  .account(customerApiRequest.getAccount())
        							  .password(customerApiRequest.getPassword())
        							  .status(StatusEnum.REGISTERED)
        							  .phoneNumber(customerApiRequest.getPhoneNumber())
        							  .email(customerApiRequest.getEmail())
        							  .registeredAt(LocalDateTime.now())
        							  .build();

        Customer newCustome = customerRepository.save(customer);

        // 3. 생성된 데이터로 UserApiResponse return
        // read, update 등 다른곳에서도 쓰일 수 있기 때문에 메서드(response)를 따로 빼준다.
        return response(newCustome);
		
	}

	@Override
	public Header<CustomerApiResponse> read(Long id) {
		// id를 가지고 repository를 통해서 데이터를 가져온다
        Optional<Customer> optional = customerRepository.findById(id);

        // 해당데이터와 유저가 오면 Customer를 가지고 CustomerApiResponse를 return해준다
        return optional
                .map(customer -> response(customer)) // 유저가 있다면
                .orElseGet( () -> Header.ERROR("데이터 없음") ); // 유저가 없다면
		
	}

	@Override
	public Header<CustomerApiResponse> update(Header<CustomerApiRequest> request) {
		 // 1. data를 가져온다
		CustomerApiRequest customerApiRequest = request.getData();

        // 2. id를 가지고 user 데이터를 찾는다
        Optional<Customer> optional = customerRepository.findById(customerApiRequest.getId());
        
        return optional.map(customer -> {
        	// 3. data를가지고 update를 시켜준다
    		customer.setAccount(customerApiRequest.getAccount())
    					 .setPassword(customerApiRequest.getPassword())
    					 .setStatus(customerApiRequest.getStatus())
    					 .setPhoneNumber(customerApiRequest.getPhoneNumber())
    					 .setEmail(customerApiRequest.getEmail())
    					 .setRegisteredAt(customerApiRequest.getRegisteredAt())
    					 .setUnregisteredAt(customerApiRequest.getUnregisteredAt());
    		
    		return customer;
        
        	
        })
        .map(customer -> customerRepository.save(customer)) // update가 일어난다.
        .map(customer -> response(customer)) // userApiResponse가 만들어진다
        .orElseGet( () -> Header.ERROR("데이터 없음") );
	}

	@Override
	public Header delete(Long id) {
		// 1. id를 가지고 repository를 통해서 customer를 찾는다
		Optional<Customer> optional = customerRepository.findById(id);

        // 2. repository를 통해서 delete를 해준다
        // 3. response return
        return optional.map(customer -> {
        	customerRepository.delete(customer);
            return Header.OK();
            
        })
        .orElseGet( () -> Header.ERROR("데이터 없음") );
		
	}
	
	// customer객체를 가지고 CustomerApiResponse를 만들어서 리턴 - 공통
    private Header<CustomerApiResponse> response(Customer customer) {
    	// body부분에 들어간다
    	CustomerApiResponse customerApiResponse = CustomerApiResponse.builder()
                														  .id(customer.getId())
															              .account(customer.getAccount())
															              .password(customer.getPassword())
															              .email(customer.getEmail())
															              .phoneNumber(customer.getPhoneNumber())
															              .status(customer.getStatus())
															              .registeredAt(customer.getRegisteredAt())
															              .unregisteredAt(customer.getUnregisteredAt())
															              .build();

        // Header와 data를 합쳐서 return시켜 주겠다
        return Header.OK(customerApiResponse);

    }

}// CustomerApiService
