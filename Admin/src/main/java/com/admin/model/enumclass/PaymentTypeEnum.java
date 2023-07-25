package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentTypeEnum {
	// OrderGroup 결제 방법
	CARD(0, "카드", "카드결제"),
	BANK(1, "현금", "무통장입금");
	
	private Integer id;
	private String title;
	private String description;

}
