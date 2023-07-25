package com.admin.model.network.request;

import com.admin.model.enumclass.CategoryTypeEnum;
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
public class CategoryApiRequest {
	private Long id;
    private CategoryTypeEnum type; // 의류 / 악세서리 / 가방
    private String title;

}
