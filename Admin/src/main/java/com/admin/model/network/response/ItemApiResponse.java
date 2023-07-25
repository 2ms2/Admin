package com.admin.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.admin.model.enumclass.ItemTypeEnum;

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
public class ItemApiResponse {
    private Long id;
    private ItemTypeEnum status;
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    
    private Long partnerId;

}
