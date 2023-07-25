package com.admin.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.AdminUser;
import com.admin.model.enumclass.StatusEnum;
import com.admin.repository.AdminUserRepository;

public class AdminUserRepositoryTest extends AdminApplicationTests {
	
	@Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("adminUser01");
        adminUser.setPassword("admin01");
        adminUser.setStatus(StatusEnum.REGISTERED);
        adminUser.setRole("관리자");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assert.assertNotNull(newAdminUser);
        
    }
    
}
