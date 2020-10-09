package com.jeffry.springcloud.repository;

import com.jeffry.springcloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
