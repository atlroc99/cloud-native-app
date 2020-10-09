package com.jeffry.springcloud.restClient;

import com.jeffry.springcloud.dto.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*request is directly going to the coupon-service. had we request going thru the api-gateway, we
would put the api-gateway service name inside the feignClient */
@RestController
@FeignClient(name = "COUPON-SERVICE")
public interface CouponClient {

    String COUPON = "/coupons/couponapi";

    @GetMapping(COUPON + "/")
    String testCouponService();

    @GetMapping(COUPON + "/coupons/{code}")
    Coupon getCoupon(@PathVariable(name = "code") String code);
}
