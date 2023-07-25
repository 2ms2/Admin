package com.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	// 회원 상태
	REGISTERED(0, "가입", "가입된 회원"),
	UNREGISTERED(1, "탈퇴", "탈퇴한 회원");
	
	private Integer id;
	private String title;
	private String description;

}