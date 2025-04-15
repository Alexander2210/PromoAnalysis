package com.example.promoanalysis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "actuals")
public class ActualEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ship_to_code")
    private String shipToCode;

    @Column(name = "product_code")
    private String productCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_to_code", referencedColumnName = "shipToCode", insertable = false, updatable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code", referencedColumnName = "productCode", insertable = false, updatable = false)
    private ProductEntity product;
    private LocalDate date;
    private Double volumeUnits;
    private BigDecimal actualSalesValue;

    @Enumerated(EnumType.STRING)
    private PromoFlag promoFlag;
}