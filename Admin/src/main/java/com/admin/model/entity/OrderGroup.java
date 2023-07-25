package com.admin.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.admin.model.enumclass.DeliveryStatusEnum;
import com.admin.model.enumclass.OrderGroupTypeEnum;
import com.admin.model.enumclass.PaymentTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_order_group_seq")
    @SequenceGenerator(name = "admin_order_group_seq", initialValue = 1, allocationSize = 1, sequenceName = "ADMIN_ORDER_GROUP_SEQ")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status;
    
    @Enumerated(EnumType.STRING)
    private OrderGroupTypeEnum orderType; // 주문의 형태 - 일괄, 개별
    
    private String revAddress;
    private String revName;
    
    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType; // 카드 / 현금
    
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    // OrderGroup N : Customer 1
    @ManyToOne
    private Customer customer;
    
  	// OrderGoup 1 : OrderDetail N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
