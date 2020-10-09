package com.jeffry.springcloud.service;

import com.jeffry.springcloud.dto.Coupon;

import com.jeffry.springcloud.dto.ProductDto;
import com.jeffry.springcloud.entity.Category;
import com.jeffry.springcloud.repository.CategoryRepostiory;
import com.jeffry.springcloud.repository.ProductRepository;
import com.jeffry.springcloud.restClient.CouponClient;
import lombok.extern.slf4j.Slf4j;
import com.jeffry.springcloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService implements Serializable {

    private final ProductRepository productRepository;
    private final CategoryRepostiory categoryRepostiory;
    private final CouponClient couponClient;

    @Value("${couponService.url}")
    private String coupon_base_url;

    public ProductService(ProductRepository productRepository, CouponClient couponClient, CategoryRepostiory categoryRepostiory) {
        this.productRepository = productRepository;
        this.couponClient = couponClient;
        this.categoryRepostiory = categoryRepostiory;
    }
    @Transactional
    public Product createProduct(Product product) {
        log.info(">>> fetch coupon code: " + coupon_base_url + "/" + product.getCouponCode());
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));

        log.info(">>> get Product Category by CategoryID: " + product.getCategoryId());
        product.setCategory(categoryRepostiory.findById(product.getCategoryId()).get());

        log.info(">>> Adding new Product: " + product);
        Product newProduct =  productRepository.save(product);
        if (Objects.nonNull(newProduct) && !isNullOrEmpty(product.getID())) {
            log.info(">>>Added " + product.getName() + " Successful");
        }

        return newProduct;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Cacheable(cacheNames = "productsByCategoryIDCache")
    public Set<ProductDto> getProductsByCategoryID(int categoryID) {
        Set<ProductDto> productDtos = productRepository.findAllByCategoryID(categoryID)
                .stream()
                .map(product -> Transformer.toProductDto(product))
                .collect(Collectors.toSet());
        return productDtos;
    }

    private boolean isNullOrEmpty(String val) {
        if (val == null || val.trim().length() == 0 ) {
            return true;
        }
        return false;
    }

}
