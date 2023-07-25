package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemTypeEnum {
	// 아이템 등록 상태
	REGISTERED(0, "등록", "상품 등록 상태"),
	UNREGISTERED(1, "해지", "상품 해지 상태"),
	WAITING(3, "대기", "상품 등록 대기 상태");
	
	private Integer id;
	private String title;
	private String description;
	
}
