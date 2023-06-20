package com.spring_REST.product;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    @Size(min = 8, max = 20)
    private String productName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Size(min = 0, max = 300)
    private String productDesc;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10, fraction = 0)
    private Integer stockAlertQuantity;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10, fraction = 3)
    private BigDecimal unitPrice;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 0, fraction = 2, message = "Discount factor must lie between 0 to 1")
    private BigDecimal discount;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10, fraction = 0)
    private Integer quantity;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10, fraction = 3)
    private BigDecimal productPrice;

    public Product() {


    }

    public Product(@NotBlank String productName, ProductCategory category, String productDesc,
            Integer stockAlertQuantity, BigDecimal unitPrice, BigDecimal discount, Integer quantity,
            BigDecimal productPrice) {
        this.productName = productName;
        this.category = category;
        this.productDesc = productDesc;
        this.stockAlertQuantity = stockAlertQuantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    

    

    
    

    

}
