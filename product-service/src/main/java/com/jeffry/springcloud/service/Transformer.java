package com.jeffry.springcloud.service;

import com.jeffry.springcloud.dto.ProductDto;
import com.jeffry.springcloud.entity.Product;

public class Transformer {
    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDesc(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryID(product.getCategoryId());
        return productDto;
    }

    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDesc());
        product.setPrice(productDto.getPrice());
        product.setCouponCode(productDto.getCoupon_code());
        return product;
    }
}
