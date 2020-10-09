package com.jeffry.springcloud.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Coupon {
    private String id;
    private String code;
    private BigDecimal discount;
    private String exp_date;
    private int categoryId;
}
