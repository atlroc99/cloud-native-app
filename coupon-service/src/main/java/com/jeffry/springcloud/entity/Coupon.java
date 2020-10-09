package com.jeffry.springcloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "coupon")
public class Coupon {

    public Coupon(){
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String ID;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(name = "expiration_date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private java.util.Date exp_date;
}
