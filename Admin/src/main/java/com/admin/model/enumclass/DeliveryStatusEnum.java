package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryStatusEnum {
	// OrderGroup 배송 상태
	DELIVERY_WAIT(0, "배송준비", "배송 준비 상태"),
	DELIVERY(1, "배송중", "배송중상 태"),
	DELIVERY_FINISH(2, "배송 완료", "배송완료 상태");

	private Integer id;
	private String title;
	private String description;
	
}
