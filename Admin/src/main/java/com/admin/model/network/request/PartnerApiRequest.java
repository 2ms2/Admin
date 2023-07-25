package com.admin.model.network.request;

import java.time.LocalDateTime;

import com.admin.model.enumclass.PartnerStatusEnum;

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
public class PartnerApiRequest {
	private Long id;
    private String name;
    private PartnerStatusEnum status;
    private String address;
    private String callCenter;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
    private Long categoryId;
    
}
