package com.jeffry.springcloud.service;

import com.jeffry.springcloud.entity.Coupon;
import com.jeffry.springcloud.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Transactional
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Coupon getCoupon(String code) throws Exception {
        Optional<Coupon> coupon = couponRepository.findByCode(code);
        if (coupon.isPresent()) {
            return coupon.get();
        }
        
        throw new Exception(String.format("Coupon with code %s not found. ",code));
    }

    public List<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

}
