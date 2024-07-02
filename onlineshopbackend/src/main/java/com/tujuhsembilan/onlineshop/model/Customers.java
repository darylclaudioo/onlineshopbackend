package com.tujuhsembilan.onlineshop.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customers {
    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "last_order_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastOrderDate;

    @Column(name = "pic")
    private String pic;
}
