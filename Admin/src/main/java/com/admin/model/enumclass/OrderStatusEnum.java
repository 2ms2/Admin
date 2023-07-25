package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
	// OrderDetail 주문 상태
	FINISH(0, "주문완료", "결제 완료 상태"),
	WAITING(1, "입금대기", "결제 미완료 상태");
	
	private Integer id;
	private String title;
	private String description;
	
}
