package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-24
 */
public interface CouponService extends IService<Coupon> {

    List<Coupon> getAllCoupon();
}
