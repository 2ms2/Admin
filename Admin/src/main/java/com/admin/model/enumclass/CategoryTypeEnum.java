package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryTypeEnum {
	// 카테고리 분류
	CLOTHES(0, "의류"),
	ACCESSORY(1, "악세서리"),
	BAG(2,"가방");
	
	private Integer id;
	private String title;
	
}
