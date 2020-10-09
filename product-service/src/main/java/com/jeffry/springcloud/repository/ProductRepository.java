package com.jeffry.springcloud.repository;

import com.jeffry.springcloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findAllByCategoryID(int categoryID);
}
