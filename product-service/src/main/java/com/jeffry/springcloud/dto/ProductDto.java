package com.jeffry.springcloud.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String name;
    private String desc;
    private BigDecimal price;
    private int categoryID;
    private String coupon_code;
}
