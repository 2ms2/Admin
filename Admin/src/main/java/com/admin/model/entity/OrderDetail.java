package com.admin.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.admin.model.enumclass.OrderStatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_order_detail_seq")
    @SequenceGenerator(name = "admin_order_detail_seq", initialValue = 1, allocationSize = 1, sequenceName = "ADMIN_ORDER_DETAIL_SEQ")
    private Long id;
 
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status; // 주문완료 / 입금대기
    
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    // OrderDetail N : item : 1
    @ManyToOne
    private Item item;
    
    // OrderDetail N : orderGroup 1
    @ManyToOne
    private OrderGroup orderGroup;

}