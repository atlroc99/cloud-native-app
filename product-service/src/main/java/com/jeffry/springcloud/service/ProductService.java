package com.jeffry.springcloud.service;

import com.jeffry.springcloud.dto.Coupon;

import com.jeffry.springcloud.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import com.jeffry.springcloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Value("${couponService.url}")
    private String coupon_base_url;

    @Transactional
    public Product createProduct(Product product) {
        log.info(">>> fetch coupon code: " + coupon_base_url + "/" + product.getCouponCode());
        Coupon coupon = restTemplate.getForObject(coupon_base_url+ "/" + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
         return productRepository.save(product);
    }
    
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
