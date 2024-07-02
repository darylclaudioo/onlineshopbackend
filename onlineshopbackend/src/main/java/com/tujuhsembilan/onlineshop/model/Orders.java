package com.tujuhsembilan.onlineshop.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orders {
    @Id
    @Column(name = "order_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp orderDate;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "items_id", referencedColumnName = "items_id")
    private Items items;

    @Column(name = "quantity")
    private Integer quantity;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        this.totalPrice=this.items.getPrice()*this.getQuantity();
    }
}
