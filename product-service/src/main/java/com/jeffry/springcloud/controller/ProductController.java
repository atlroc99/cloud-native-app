package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.dto.ProductDto;
import com.jeffry.springcloud.service.ProductService;
import com.jeffry.springcloud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    private String test() {
        return "PRODUCT-SERVICE: Up and running...";
    }

    @GetMapping("/products/{id}")
     public Product getProduct(@PathVariable(value = "id") Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("products/category")
    public Set<ProductDto> getProductByCategoryId(@RequestParam("categoryID") int categoryID) {
        return productService.getProductsByCategoryID(categoryID);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }


}
