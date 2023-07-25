package com.admin.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.admin.model.enumclass.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailApiResponse {
	private Long id;
    private OrderStatusEnum status; // 주문완료 / 입금대기    
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    
    private Long itemId;
    private Long oderGoupId;
	
}
