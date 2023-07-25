package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.controller.ifs.CrudInterface;
import com.admin.model.entity.AdminUser;
import com.admin.model.enumclass.StatusEnum;
import com.admin.model.network.Header;
import com.admin.model.network.request.AdminUserApiRequest;
import com.admin.model.network.response.AdminUserApiResponse;
import com.admin.repository.AdminUserRepository;

@Service
public class AdminUserApiService  implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Override
	public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
		AdminUserApiRequest adminUserApiRequest = request.getData();
		
		AdminUser adminUser = AdminUser.builder()
										  .account(adminUserApiRequest.getAccount())
										  .password(adminUserApiRequest.getPassword())
	        							  .status(StatusEnum.REGISTERED)
	        							  .role(adminUserApiRequest.getRole())
										  .build();
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		
		return response(newAdminUser);
		
	}

	@Override
	public Header<AdminUserApiResponse> read(Long id) {
		return null;
		
	}

	@Override
	public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
		return null;
		
	}

	@Override
	public Header delete(Long id) {
		return null;
		
	}
	
	private Header<AdminUserApiResponse> response(AdminUser adminUser) {
		AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
																			.id(adminUser.getId())
																			.account(adminUser.getAccount())
																			.password(adminUser.getPassword())
																			.status(adminUser.getStatus())
																			.role(adminUser.getRole())
																			.build();
		
		return Header.OK(adminUserApiResponse);
	}

}
