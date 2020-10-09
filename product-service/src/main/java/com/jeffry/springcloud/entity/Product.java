package com.jeffry.springcloud.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(nullable = false, unique = true, length = 45)
    private String ID;

    private String name;
    private String description ;
    private BigDecimal price;

    //marking this field as transient bc we don't want ot create this as a column and add fields in the db
    //this is only to handle incoming request data
    //we can create a web-model object and use model mapper for this
    @Transient
    private String couponCode;
}
