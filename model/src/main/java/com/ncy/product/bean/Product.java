package com.ncy.product.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Data
@Accessors(chain = true)
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
