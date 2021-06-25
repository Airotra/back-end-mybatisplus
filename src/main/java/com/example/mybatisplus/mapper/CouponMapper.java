package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Coupon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-24
 */
public interface CouponMapper extends BaseMapper<Coupon> {

    List<Coupon> getAllCoupon();
}
