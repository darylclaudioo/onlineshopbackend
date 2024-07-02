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

@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Items {
    @Id
    @Column(name = "items_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemsId;

    @Column(name = "items_name")
    private String itemsName;

    @Column(name = "items_code")
    private String itemsCode;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Integer price;
    
    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "last_re_stock")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastReStock;
}
