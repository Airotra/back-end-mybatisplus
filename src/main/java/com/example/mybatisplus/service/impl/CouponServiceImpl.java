package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Coupon;
import com.example.mybatisplus.mapper.CouponMapper;
import com.example.mybatisplus.service.CouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-24
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {

    @Override
    public List<Coupon> getAllCoupon() {
        return baseMapper.getAllCoupon();
    }
}
