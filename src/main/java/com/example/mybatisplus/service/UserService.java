package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Coupon;
import com.example.mybatisplus.model.domain.Trolley;
import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-19
 */
public interface UserService extends IService<User> {

    UserVo getAddr(Long id);

    UserVo getUserCoupon(Long id);

    List getCoupon(Long id);
}
