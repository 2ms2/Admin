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
public class CustomerApiRequest {
	// 공통부는 빼고 데이터 부분만 정의
	private Long id; // 업데이트 시 필요
    private String account;
    private String password;
    private StatusEnum status;
    private String email;
    private String phoneNumber;
    // 업데이트 시 필요
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
}
