package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PartnerStatusEnum {
	// 파트너사 승인 상태
	APPROVAL(0, "승인", "상품 등록 상태"),
	REFUSAL(1, "거절", "상품 해지 상태"),
	WAITING(3, "대기", "상품 등록 대기 상태");
	
	private Integer id;
	private String title;
	private String description;
}
