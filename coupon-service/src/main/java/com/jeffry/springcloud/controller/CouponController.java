package com.jeffry.springcloud.controller;

import com.jeffry.springcloud.entity.Coupon;
import com.jeffry.springcloud.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping()
    public String test() {
        return "COUPON-SERVICE: UP AND RUNNING...";
    }

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody(required = true) Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @GetMapping("coupons/{code}")
    public Coupon getCoupon(@PathVariable(name = "code") String code) throws Exception {
        return couponService.getCoupon(code);
    }

    @GetMapping("/coupons")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }
    
}
