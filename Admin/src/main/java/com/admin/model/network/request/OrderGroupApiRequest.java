package com.admin.model.network.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.admin.model.enumclass.DeliveryStatusEnum;
import com.admin.model.enumclass.OrderGroupTypeEnum;
import com.admin.model.enumclass.PaymentTypeEnum;

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
public class OrderGroupApiRequest {
	private Long id;
    private DeliveryStatusEnum status;
    private OrderGroupTypeEnum orderType;
    private String revAddress;
    private String revName;
    private PaymentTypeEnum paymentType;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    
    private Long customerId;
}
