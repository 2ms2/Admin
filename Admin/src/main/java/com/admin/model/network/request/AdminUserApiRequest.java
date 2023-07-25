package com.admin.model.network.request;

import java.time.LocalDateTime;

import com.admin.model.enumclass.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserApiRequest {
	private Long id;
    private String account;
    private String password;
    private StatusEnum status; // 가입 / 탈퇴
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private int loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
}
